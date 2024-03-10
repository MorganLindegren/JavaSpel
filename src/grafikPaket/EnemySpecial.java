package grafikPaket;

import java.util.Random;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class EnemySpecial extends Enemy {
	
	Timeline switchTimer = new Timeline();
	Color myColor;
	
	public EnemySpecial(int x, int y, Color myColor) {
		super(x, y, myColor);
		
		this.myColor = myColor;
	}
	
	public void drawYourself(GraphicsContext context) {
		context.setFill(myColor);
		context.fillRect(getHitbox().x, getHitbox().y, 60, 100);
		
		switchTimer = new Timeline(new KeyFrame(Duration.millis(2500), event -> laneSwitchSet()));
		switchTimer.setCycleCount(Animation.INDEFINITE);
		switchTimer.play();
	}
	
	public void updateYourself(GraphicsContext context) {

		getHitbox().x -= getEnemyLogic().getSpeed();
		
		context.setFill(myColor);
		context.fillRect(getHitbox().x, getHitbox().y - 30, 60, 100);
		
	}
	
	public void laneSwitchSet() {
		System.out.println("Byte");
		
		Timeline switching = new Timeline();
		
		if (getHitbox().y - 45 < 0) {
			
			switching = new Timeline(new KeyFrame(Duration.millis(1000/10), event -> laneSwitchDown()));
		} else if (getHitbox().y + 45 > 900) {
			
			switching = new Timeline(new KeyFrame(Duration.millis(1000/10), event -> laneSwitchUp()));
		} else {
			
			Random rand = new Random();
			int randPos = rand.nextInt(2);
			
			System.out.println(randPos);
			
			if (randPos == 0) {
				
				switching = new Timeline(new KeyFrame(Duration.millis(1000/10), event -> laneSwitchDown()));
			} else {
				
				switching = new Timeline(new KeyFrame(Duration.millis(1000/10), event -> laneSwitchUp()));
			}
		}
		
		switching.setCycleCount(4);
		switching.play();
	}
	
	public void laneSwitchUp() {
		
		getHitbox().y -= 45;
	}
	
	public void laneSwitchDown() {
		
		getHitbox().y += 45;
	}

}
