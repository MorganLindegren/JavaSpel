package grafikPaket;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.control.Button;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Iterator;
import javafx.animation.*;

/**
 * Mainen där spelets UI skaps och spelet startas samt stängs ner, ansvarar även för borttagning av objekt i listorna som används
 * för det grafiska inom spelet. Uppdaterar även det grafiska gränssnittet Interface canvas. Ansvarar även för att skriva ut
 * spelarens highscore på en .txt fil om det är högre än det tidigare rekordet
 */

public class MainScene extends Application{
	
	private ImageBackground background = new ImageBackground();
	private Interface canvas = new Interface(3, 6, 10, 12);
	private Timeline loop = new Timeline();


	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage primaryStage) throws Exception {
		
		//----------Game Scene--------
		primaryStage.setTitle("Plant on Zombie Warfare");
		
		StackPane pane = new StackPane();
		HBox layout = new HBox();
		GraphicsContext context = canvas.getGraphicsContext2D();
		Shop shop = new Shop(900, canvas.getIFmodel());
		
		canvas.drawGrid();
		canvas.setShop(shop);
		
		ImageView iv = new ImageView(background.getImage());
		
		loop = new Timeline(new KeyFrame(Duration.millis(1000.0/60), event -> update(context)));
		loop.setCycleCount(Animation.INDEFINITE);
		loop.play();
			
		layout.getChildren().addAll(shop, pane);
		pane.getChildren().addAll(iv, canvas);	
		Scene primaryScene = new Scene(layout, 1539, 899);
		
		//----------Main menu---------
		Text gameName = new Text();
		gameName.setText("Foliage VS Undead");
		gameName.setFont(Font.font("comicsans", FontWeight.BOLD, FontPosture.REGULAR, 80));
		
		Button startButton = new Button("Start Game");
		startButton.setOnAction(e -> {
			primaryStage.setScene(primaryScene);
		});
		
		Button exitButton = new Button("Exit Game");
		exitButton.setOnAction(e -> {
			System.exit(0);
		});
		
		Group textGroup = new Group(gameName);
		
		VBox menuBox = new VBox();
		VBox textBox = new VBox();
		
		StringBuilder highscore = new StringBuilder();
		String scoreString = null;
		
		BufferedReader reader = new BufferedReader(new FileReader("highscore.txt"));
		while ((scoreString = reader.readLine()) != null) {
			highscore.append(scoreString);
		}	
		reader.close();
		
		Text highScore = new Text("Highscore: " + highscore.toString());
		highScore.setFont(Font.font("comicsans", FontWeight.BOLD, FontPosture.REGULAR, 40));
		
		textBox.getChildren().addAll(textGroup, highScore);
		textBox.setAlignment(Pos.TOP_CENTER);
		
		menuBox.getChildren().addAll(startButton, exitButton);
		menuBox.setAlignment(Pos.CENTER);
		
		StackPane menuRoot = new StackPane();
		menuRoot.getChildren().addAll(textBox, menuBox);
		Scene MenuScene = new Scene(menuRoot, 1440, 900);
		
		primaryStage.setResizable(false);
		primaryStage.setScene(MenuScene);
		primaryStage.show();

	}
	
	public void update(GraphicsContext context) {
		
		context.clearRect(0, 0, 1440, 900);
		if (canvas.getIFmodel().getEnemywave1() != null) {
			canvas.setSpawnCycles();
		
		if (!(canvas == null)) {
			
			for (Tower tower : canvas.getIFmodel().getTowers()) {
				
					tower.updateTower(context);
					tower.update();
			}
			
			for (Tower towertemp : canvas.getIFmodel().getTowers()) {			
				for (Projectile projectile : towertemp.getProjectiles()) {
					for (Enemy enemy : canvas.getIFmodel().getAliveEnemies()) {
						
						projectile.checkCollision(enemy);				
							}			
						}	
					}					
				}
			
			
			if (canvas.getIFmodel().getAliveEnemies().size() > 0) {
				for (Enemy enemy : canvas.getIFmodel().getAliveEnemies()) {		
					enemy.updateYourself(context);				
				}
				
				Enemy enemy = canvas.getIFmodel().getAliveEnemies().get(0);
				
				Iterator<Enemy> iterator = canvas.getIFmodel().getAliveEnemies().iterator();
										
					while (iterator.hasNext()) {
													
						enemy = iterator.next();						
							
						if (enemy.getEnemyLogic().dead()) {
								
								
							iterator.remove();
								
							canvas.getShop().getShopLogic().increaseMoney();							
							canvas.getShop().updateMoney();
								
							canvas.getIFmodel().increaseScore();							
							canvas.getShop().updateScore();
							
						} else if (enemy.getHitbox().x == 0) {
								
							loop.setCycleCount(0);					
							loop.stop();				
							canvas.gameOver();	
							
							Writer writer = null;		
							try {
									
								
								StringBuilder highscore = new StringBuilder();							
								String scoreString = null;												
								BufferedReader reader = new BufferedReader(new FileReader("highscore.txt"));
								
								while ((scoreString = reader.readLine()) != null) {
									
									highscore.append(scoreString);						
								}	
									
								reader.close();
														
									if (Integer.valueOf(highscore.toString()) < canvas.getIFmodel().getScore()) {
									
										writer = new BufferedWriter(new OutputStreamWriter
												(new FileOutputStream("highscore.txt"), "utf-8"));							
										writer.write(canvas.getIFmodel().getScore().toString());
									}
														
							} catch (IOException e) {
								
								System.out.println(e);						
							} finally {						
								try {writer.close();} catch (Exception ex) {/*ignore*/}							
								
							
							}															
						}														
					}										
			}										
		}
		
		if (canvas.getIFmodel().getEnemywave2().isEmpty() && canvas.getIFmodel().getAliveEnemies().isEmpty()
				&& canvas.getIFmodel().getLevel() == 1)	{
			
			canvas.getIFmodel().setLevel();
			canvas.getShop().updateLevel();
			canvas.newLevel();
			
		}
		
		if (canvas.getWin()) {
			canvas.winText();
			loop.setCycleCount(1);
			loop.stop();
		}
	}
}
	


