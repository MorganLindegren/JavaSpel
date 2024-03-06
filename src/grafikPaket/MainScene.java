package grafikPaket;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import javafx.scene.control.Button;

import java.util.ArrayList;

import javafx.animation.*;

public class MainScene extends Application{
	
	Interface canvas;

	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage primaryStage) {
		
		//----------Game Scene--------
		primaryStage.setTitle("Plant on Zombie Warfare");
		final double targetFps = 60.0;
		final double nanoPerUpdate = 10000000000.0 / targetFps;
		
		StackPane pane = new StackPane();
//		HBox layout = new HBox();
		Interface canvas = new Interface();
		GraphicsContext context = canvas.getGraphicsContext2D();
		
		canvas.drawGrid();
		
		Image background = new Image(getClass().getResourceAsStream(("GreenGrass.jpg")));
		ImageView iv = new ImageView(background);
		
		Timeline loop = new Timeline(new KeyFrame(Duration.millis(1000.0/60), event -> update(context)));
		loop.setCycleCount(Animation.INDEFINITE);
		loop.play();
		
		pane.getChildren().addAll(iv, canvas);	
		Scene primaryScene = new Scene(pane, 1439, 899);
		
		//----------Main menu---------
		Text gameName = new Text();
		gameName.setText("Foliage VS Undead");
		gameName.setFont(Font.font("comic_sans", FontWeight.BOLD, FontPosture.REGULAR, 80));
		
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
//		primaryStage.setScene(primaryScene);
		primaryStage.setScene(MenuScene);
		primaryStage.show();

	}
	private void update(GraphicsContext context) {
		context.clearRect(0, 0, 1440, 900);
		
		for (ArrayList<TowerSprite> list : canvas.getIFmodel().getContents()) {
			
			for (int i = 0; i < 8; i++ ) {
				
				list.get(i).drawYourself(context);
				
			}		
		}	
	}
}
