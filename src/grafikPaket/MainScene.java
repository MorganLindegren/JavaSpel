package grafikPaket;

import javafx.application.Application;
import javafx.scene.layout.StackPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MainScene extends Application{

	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Plant on Zombie Warfare");
		
		StackPane root = new StackPane();
//		HBox layout = new HBox();
		Background canvas = new Background();
		
		canvas.drawGrid();
		
		Image background = new Image(getClass().getResourceAsStream(("GreenGrass.jpg")));
		ImageView iv = new ImageView(background);
		
		root.getChildren().addAll(iv, canvas);
		
		Scene primaryScene = new Scene(root, 1439, 899);
		primaryStage.setResizable(false);
		primaryStage.setScene(primaryScene);
		primaryStage.show();

	}
}
