package grafikPaket;

import javafx.application.Application;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.animation.*;

public class MainScene extends Application{

	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage primaryStage) {
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
		primaryStage.setResizable(false);
		primaryStage.setScene(primaryScene);
		primaryStage.show();

	}
}
