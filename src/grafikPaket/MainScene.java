package grafikPaket;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import javafx.util.Duration;

import javafx.scene.control.Button;

import java.util.ArrayList;

import javafx.animation.*;

public class MainScene extends Application{
	
	private Interface canvas = new Interface();

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
		
		Image background = new Image(getClass().getResourceAsStream(("GreenGrass.jpg")));
		ImageView iv = new ImageView(background);
		
		Timeline loop = new Timeline(new KeyFrame(Duration.millis(1000.0/60), event -> update(context)));
		loop.setCycleCount(Animation.INDEFINITE);
		loop.play();
			
		layout.getChildren().addAll(shop, pane);
		pane.getChildren().addAll(iv, canvas);	
		Scene primaryScene = new Scene(layout, 1439, 899);
		
		//----------Main menu---------
		Text gameName = new Text();
		gameName.setText("Foliage VS Undead");
		gameName.setFont(Font.font("comicsans", FontWeight.BOLD, FontPosture.REGULAR, 80));
		
		Button startButton = new Button("Start Game");
		startButton.setOnAction(e -> {
			primaryStage.setScene(primaryScene);
		});
		
		Group textGroup = new Group(gameName);
		
		VBox menuBox = new VBox();
		VBox textBox = new VBox();
		
		textBox.getChildren().addAll(textGroup);
		textBox.setAlignment(Pos.TOP_CENTER);
		
		menuBox.getChildren().addAll(startButton);
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
		
		if (!(canvas == null)) {
			
			for (Tower tower : canvas.getIFmodel().getTowers()) {
				
					tower.updateTower(context);
					tower.update();
			}
			
			for (Tower tower : canvas.getIFmodel().getTowers()) {			
				for (Projectile projectile : tower.getProjectiles()) {
					for (Enemy enemy : canvas.getIFmodel().getAliveEnemies()) {
						projectile.checkCollision(enemy);
					}
				}			
			}
			for (SlowTower slowtower : canvas.getIFmodel().getSlowTowers()) {
				for (Projectile slowprojectile : slowtower.getProjectiles()) {
					for (Enemy enemy : canvas.getIFmodel().getAliveEnemies()) {
						slowprojectile.checkCollision(enemy);
						slowprojectile.slowEnemySpeed(enemy);
					}
				}
			}
			
			for (Enemy enemy : canvas.getIFmodel().getAliveEnemies()) {
				enemy.updateYourself(context);
			}
		}
	}

}
	


