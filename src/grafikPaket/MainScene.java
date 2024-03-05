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
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import javafx.scene.control.Button;

import javafx.animation.*;

public class MainScene extends Application{

	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage primaryStage) {
		
		//----------Game Scene--------
		primaryStage.setTitle("Plant on Zombie Warfare");
		final double targetFps = 60.0;
		final double nanoPerUpdate = 10000000000.0 / targetFps;
		
		Rectangle rect = new Rectangle(1300,0);
		rect.setLayoutX(-660);
		rect.setLayoutY(-360);
		Circle circ = new Circle(30, Color.WHITE);
		PathTransition pt = new PathTransition();
		
		pt.setNode(circ);
		pt.setPath(rect);
		pt.setDuration(Duration.seconds(3));
		pt.setAutoReverse(false);
		pt.setCycleCount(Animation.INDEFINITE);
		pt.play();
		
		StackPane root = new StackPane();
//		HBox layout = new HBox();
		Interface canvas = new Interface();
		
		canvas.drawGrid();
		
		Image background = new Image(getClass().getResourceAsStream(("GreenGrass.jpg")));
		ImageView iv = new ImageView(background);
		
		root.getChildren().addAll(iv, canvas, circ);	
		Scene primaryScene = new Scene(root, 1439, 899);
		
		//----------Main menu---------
		Text gameName = new Text();
		gameName.setText("Plant on Zombie Warfare");
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
}
