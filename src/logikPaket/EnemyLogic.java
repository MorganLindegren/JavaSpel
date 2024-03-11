package logikPaket;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

/**
 * Håller koll på alla värden på fienderna såsom HP, hastighet och
 * ursprungliga hastigheten. Uppdateras när fienderna blir träffade och
 * ger sina värden till de motsvarande grafiska klasserna
 */

public class EnemyLogic {

	private int healthPoints;
	private double moveSpeed;
	private double startSpeed;
	
	public EnemyLogic(int healthPoints, double moveSpeed) {
		this.healthPoints = healthPoints;
		this.moveSpeed = moveSpeed;
		startSpeed = moveSpeed;
		
	}
	
	public void enemyHit(ProjectileLogic projectile) {
		healthPoints -= projectile.getDamage();
	}
	
	public void setEnemyHealth(int i) {
		healthPoints = i;
	}
	
	public boolean dead() {
		return healthPoints == 0;
	}
	
	public void setNormalSpeed() {
		moveSpeed = startSpeed;
	}
	
	public double getSpeed() {
		return moveSpeed;
	}
	
	public void isSlowed(ProjectileLogicSlow projectile) {
		moveSpeed = startSpeed * projectile.getSlow();

		Timeline slowed = new Timeline(new KeyFrame(Duration.millis(5000), event -> setNormalSpeed()));
		slowed.setCycleCount(1);
		slowed.play();
	}
}
