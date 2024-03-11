package grafikPaket;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;
import java.util.Random;

/**
 * Är det grafiska gränssnittet i spelet och uppdateras 60x i sekunden av MainScene. Ritar ut
 * beroende på vad som existerar i listorna i Model (myModel i detta fall)
 */

public class Interface extends Canvas{
	
	private Model myModel = new Model();
	Timeline spawnTimer = new Timeline();
	private GraphicsContext context = getGraphicsContext2D();
	private Boolean gameStart = false;
	private Shop shop;

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
				 
				randPos = 70;
			} else if (randPos == 1) {
		
				randPos = 250;
			} else if (randPos == 2) {
		
				randPos = 430;
			} else if (randPos == 3) {
		
				randPos = 610;
			} else if (randPos == 4) {			
		 	
				randPos = 790;
			}
			
			if (!(i % 5 == 0)) {		
					
				Enemy enemy = new EnemyBasic(1440, randPos, Color.RED);	
				myModel.getEnemywave1().push(enemy);
		
			} else {
				
				Enemy enemy = new EnemySpecial(1440, randPos, Color.PURPLE);
				myModel.getEnemywave1().push(enemy);
			}
		}
		
		for (int i = 0; i < 40; i++) {
			
			Random rand = new Random();
			int randPos = rand.nextInt(5);
			
			if (randPos == 0) {
				 
				randPos = 70;
			} else if (randPos == 1) {
		
				randPos = 250;
			} else if (randPos == 2) {
		
				randPos = 430;
			} else if (randPos == 3) {
		
				randPos = 610;
			} else if (randPos == 4) {			
		 	
				randPos = 790;
			}
			
			if (!(i % 5 == 0)) {
				
				Enemy enemy = new EnemyBasic(1440, randPos, Color.RED);
				myModel.getEnemywave2().push(enemy);
			} else {
				
				Enemy enemy = new EnemySpecial(1440, randPos, Color.PURPLE);
				myModel.getEnemywave2().push(enemy);
			}
		}
	}
	
	public void startSpawn() {
		Timeline spawnTimer = new Timeline(new KeyFrame(Duration.millis(1000.0/0.5), event -> spawnEnemy()));
		spawnTimer.setCycleCount(Animation.INDEFINITE);
		spawnTimer.play();
	}
	
	public void spawnEnemy() {
		if ((myModel.getWave() != 1) && (myModel.getEnemywave1().isEmpty())) {
			myModel.newWave();
			shop.updateWave();
		}
		if (!myModel.getEnemywave1().isEmpty()) {
			myModel.getEnemywave1().peek().drawYourself(context);
			myModel.getAliveEnemies().add(myModel.getEnemywave1().peek());
			myModel.getEnemywave1().pop();
		} else {
			
			for (int i = 0; i < 3; i++) {
				System.out.println("Våg 2");
				myModel.getEnemywave2().peek().drawYourself(context);
				myModel.getAliveEnemies().add(myModel.getEnemywave2().peek());
				myModel.getEnemywave2().pop();
			}
		}
	}
	
	public void drawGrid() {
		
		int ymulti = 0;
		
		for (int row = 0; row < 5; row++) {
			
			int xmulti = 0;
			
			for (int i = 0; i < 8; i++) {
				
			    Shape shape = new Shape(xmulti, ymulti, new Color(0, 0, 0, 0));
				myModel.addGridRect(shape, row);
				
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
			
			if (shop.getShopLogic().getMoney() > 0) {
				
				if (myModel.getTower().equals("base")) {
					
					myModel.getGridRect(y, x).addTower(myModel, context);
					shop.getShopLogic().buy();
					shop.updateMoney();
			
				} else if (myModel.getTower().equals("slow")) {
				
					myModel.getGridRect(y, x).addTower(myModel, context);
					shop.getShopLogic().buy();
					shop.updateMoney();
			
				}
			}
			
			if (!gameStart) {
				createEnemyWaves();
				startSpawn();
				gameStart = true;
				myModel.newWave();
				shop.updateWave();
			}
		});
		
	}
	
	public Model getIFmodel() {
		return myModel;
	}
	
	public Boolean checkIfmodelEmpty() {
		return myModel.checkGridEmpty();
	}
	
	public void gameOver() {
		
		context.setFill(Color.RED);
		context.setTextAlign(TextAlignment.CENTER);
		context.setFont(new Font("Comicsans", 50));
		context.fillText("GAME OVER", getWidth() / 2 - 50, getHeight() / 2);
	}
	
	public Shop getShop() {
		return shop;
	}
	
	public void setShop(Shop shop) {
		this.shop = shop;
	}
}
