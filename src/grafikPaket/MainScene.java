package grafikPaket;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MainScene extends Application{

	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Plant on Zombie Warfare");
		primaryStage.setWidth(1334); 
		primaryStage.setHeight(774);
		
		HBox layout = new HBox();
		Background canvas = new Background();
		
		layout.getChildren().add(layout);
		layout.getChildren().add(canvas);
		
		Scene primaryScene = new Scene(layout);
		primaryStage.setScene(primaryScene);
		primaryStage.show();
	}
}
