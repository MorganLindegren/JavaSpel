package logikPaket;

import grafikPaket.MainScene;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage stage) throws Exception {
		Game game = new Game();
		Stage primaryStage = new Stage();
		MainScene mainScene = new MainScene();
		
		mainScene.start(primaryStage);
		game.run();
	}
}
