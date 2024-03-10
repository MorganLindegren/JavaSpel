package grafikPaket;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import java.util.Random;

public class Interface extends Canvas{
	
	private Model gridModel = new Model();
	Timeline spawnTimer = new Timeline();
	private GraphicsContext context = getGraphicsContext2D();
	private Boolean gameStart = false;

	public Interface() {
		setWidth(1440);
		setHeight(900);
		setStyle("-fx-background-color: #a31239;"); 
		
	}
	
	public void createEnemyWaves() {
		
		
		for (int i = 0; i < 20; i++) {
			Random rand = new Random();
			int randPos = rand.nextInt(5);
			
			if (randPos == 0) {
				randPos = 75;
			} else if (randPos == 1) {
				randPos = 255;
			} else if (randPos == 2) {
				randPos = 435;
			} else if (randPos == 3) {
				randPos = 615;
			} else if (randPos == 4) {
				randPos = 795;
			}
			
			Enemy enemy = new Enemy(1440, randPos, Color.RED);
			gridModel.getEnemywave1().push(enemy);
		}
		
		System.out.println(gridModel.getEnemywave1().size());
	}
	
	public void startSpawn() {
		Timeline spawnTimer = new Timeline(new KeyFrame(Duration.millis(1000.0/0.2), event -> spawnEnemy()));
		spawnTimer.setCycleCount(Animation.INDEFINITE);
		spawnTimer.play();
	}
	
	public void spawnEnemy() {
		if (!gridModel.getEnemywave1().isEmpty()) {
			gridModel.getEnemywave1().peek().drawYourself(context);
			gridModel.getAliveEnemies().add(gridModel.getEnemywave1().peek());
			gridModel.getEnemywave1().pop();
		}
	}
	
	public void drawGrid() {
		
		int ymulti = 0;
		
		for (int row = 0; row < 5; row++) {
			
			int xmulti = 0;
			
			for (int i = 0; i < 8; i++) {
				
			    Shape shape = new Shape(xmulti, ymulti, new Color(0, 0, 0, 0));
				gridModel.addGridRect(shape, row);
				
				xmulti += 180;
				
			}
			
			ymulti += 180;
			
		}
		
		setOnMouseClicked(event -> {
			int x = (int) event.getX();
			int y = (int) event.getY();
			
			if (x < 181) {
				x = 0;
			} else if (x < 361){
				x = 1;
			} else if (x < 541){
				x = 2;
			} else if (x < 721){
				x = 3;
			} else if (x < 901){
				x = 4;
			} else if (x < 1081){
				x = 5;
			} else if (x < 1261){
				x = 6;
			} else if (x < 1441){
				x = 7;
			}
			
			
			if (y < 181) {
				y = 0;
			} else if (y < 361){
				y = 1;
			} else if (y < 541){
				y = 2;
			} else if (y < 721){
				y = 3;
			} else if (y < 901){
				y = 4;
			}
			
			if (gridModel.getTower().equals("base")) {
				gridModel.getGridRect(y, x).addTower(gridModel, context);
			} else if (gridModel.getTower().equals("slow")) {
				gridModel.getGridRect(y, x).addTower(gridModel, context);
			}
			if (!gameStart) {
				createEnemyWaves();
				startSpawn();
				gameStart = true;
			}
		});
		
	}
	
	public Model getIFmodel() {
		return gridModel;
	}
	
	public Boolean checkIfmodelEmpty() {
		return gridModel.checkGridEmpty();
	}
}
