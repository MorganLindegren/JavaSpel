package grafikPaket;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Stack;

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
	private int enemyWave1amount, enemyWave2amount, enemyWave3amount, enemyWave4amount;
	private Boolean win = false;
	
	public Interface(int enemyWave1, int enemyWave2, int enemyWave3, int enemyWave4) {
		setWidth(1440);
		setHeight(900);
		setStyle("-fx-background-color: #a31239;"); 
		enemyWave1amount = enemyWave1;
		enemyWave2amount = enemyWave2;
		enemyWave3amount = enemyWave3;
		enemyWave4amount = enemyWave4;
		
		createEnemyWaves();
	}
	
	public void createEnemyWaves() {
		
		myModel.setEnemywave1(addEnemyToWave(enemyWave1amount));
		myModel.setEnemywave2(addEnemyToWave(enemyWave2amount));
		myModel.setEnemywave3(addEnemyToWave(enemyWave3amount));
		myModel.setEnemywave4(addEnemyToWave(enemyWave4amount));
	}
	
	public Stack<Enemy> addEnemyToWave(int enemys) {
		
		Stack<Enemy> wave = new Stack<Enemy>();
		for (int i = 0; i < enemys; i++) {
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
				wave.push(enemy);
		
			} else {
				
				Enemy enemy = new EnemySpecial(1440, randPos, Color.PURPLE);
				wave.push(enemy);
			}
		}
		
		return wave;
	}
	
	public void startSpawn(int cycles) {
		spawnTimer = new Timeline(new KeyFrame(Duration.millis(1000.0/0.3), event -> spawnEnemy()));
		spawnTimer.setCycleCount(cycles);
		spawnTimer.play();
	}
	
	public void spawnEnemy() {
		if ((myModel.getWave() != 1) && (myModel.getEnemywave1().isEmpty())) {
			shop.updateWave();
		}
		if (!myModel.getEnemywave1().isEmpty()) {
			myModel.getEnemywave1().peek().drawYourself(context);
			myModel.getAliveEnemies().add(myModel.getEnemywave1().peek());
			myModel.getEnemywave1().pop();
		} else if (!myModel.getEnemywave2().isEmpty() && myModel.getLevel() == 1){
			
			for (int i = 0; i < 3; i++) {
				myModel.getEnemywave2().peek().drawYourself(context);
				myModel.getAliveEnemies().add(myModel.getEnemywave2().peek());
				myModel.getEnemywave2().pop();
			}
		} else if(!myModel.getEnemywave3().isEmpty() && myModel.getLevel() == 2) {
			myModel.getEnemywave3().peek().drawYourself(context);
			myModel.getAliveEnemies().add(myModel.getEnemywave3().peek());
			myModel.getEnemywave3().pop();
		} else if (!myModel.getEnemywave4().isEmpty()) {
			
			for (int i = 0; i < 3; i++) {
				myModel.getEnemywave4().peek().drawYourself(context);
				myModel.getAliveEnemies().add(myModel.getEnemywave4().peek());
				myModel.getEnemywave4().pop();
			}
		} else {
			setWin();
		}
	}
	
	public void setSpawnCycles() {
		
		if (!gameStart) {
			spawnTimer.stop();
		}
		
		if (myModel.getEnemywave1().isEmpty() && myModel.getLevel() == 1 && myModel.getWave() == 1) {
			startSpawn(enemyWave2amount);
			myModel.setWave(2);
			shop.updateWave();
		} else if(myModel.getEnemywave2().isEmpty() && myModel.getLevel() == 2 && myModel.getWave() == 1) {
			startSpawn(enemyWave3amount);
			myModel.setWave(1);
			shop.updateWave();
		} else if (myModel.getEnemywave3().isEmpty() && myModel.getLevel() == 2 && myModel.getWave() == 2) {
			startSpawn(enemyWave4amount);
			myModel.setWave(2);
			shop.updateWave();
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
				
				if (!(myModel.getGridRect(y, x).getOccupiedSpace())) {
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
			}
			
			if (!gameStart && myModel.getLevel() == 1) {
				startSpawn(enemyWave1amount);
				gameStart = true;
				shop.updateWave();
			} else if (!gameStart && myModel.getLevel() == 2) {
				startSpawn(enemyWave3amount);
				gameStart = true;
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
	
	public Boolean getWin() {
		return win;
	}
	
	public Shop getShop() {
		return shop;
	}
	
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	
	public void newLevel() {
		gameStart = false;
			
		for (Tower tower : myModel.getTowers()) {
			tower.stopLoop();
			
			for (Projectile projectile : tower.getProjectiles()) {
				projectile.setHit(true);
			}

		}
		
		if (myModel.getTowers().size() > 0) {

				
			Iterator<Tower> iterator = myModel.getTowers().iterator();
			
			Tower tower = myModel.getTowers().get(0);
			
			while (iterator.hasNext()) {
					
				tower = iterator.next();
					
				if (tower != null) {
						
					iterator.remove();
				
					}
			}
			
		}
		
		for (int row = 0; row < 5; row ++) {
			
			for (ArrayList<Shape> list : myModel.getPos()) {
				
				for (int i = 0; i < list.size(); i++) {
					list.get(i).setOccupiedSpace(false);
				}
			}
		}
		
		shop.getShopLogic().setMoney(10);
		shop.updateMoney();
		}
	
	public void setWin() {
		win = true;
	}
	
	public void winText() {
		context.setFill(Color.WHITE);
		context.setTextAlign(TextAlignment.CENTER);
		context.setFont(new Font("Comicsans", 50));
		context.fillText("YOU WIN!", getWidth() / 2 - 50, getHeight() / 2);
	}
	
	public GraphicsContext getContext() {
		return context;
	}
}
