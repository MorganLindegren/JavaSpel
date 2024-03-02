package grafikPaket;

import javafx.application.Application;
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
//		primaryStage.setWidth(1334); 
//		primaryStage.setHeight(774);
		
		HBox layout = new HBox();
		Background canvas = new Background();
		
		
		Image background = new Image(getClass().getResourceAsStream(("GreenGrass.jpg")));
		ImageView iv = new ImageView(background);
		
		layout.getChildren().add(iv);
		layout.getChildren().add(canvas);
		
		Scene primaryScene = new Scene(layout, 1439, 899);
		primaryStage.setResizable(false);
		primaryStage.setScene(primaryScene);
		primaryStage.show();
	}
}
