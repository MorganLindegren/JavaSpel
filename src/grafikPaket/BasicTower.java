package grafikPaket;

import java.util.ArrayList;
import java.util.Iterator;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.util.Duration;

/**
 * En version av Tower som skjuter BasicProjectiles på en loop som skadar fienderna.
 * Håller koll på sina egna projektiler
 */

public class BasicTower extends Tower {
	
	private static Color myColor = Color.GREENYELLOW;
	private ArrayList<Projectile> projectiles = new ArrayList<>();
	
	public BasicTower(int x, int y, GraphicsContext context) {
		
		super(x, y, context);
	}
	
	public void drawTower(GraphicsContext context) {
		
		context.setFill(myColor);
		context.fillRect(5, 5 , 40, 40);

	}
	
	public void updateTower(GraphicsContext context) {
		
		if (getOccupiedSpace()) {
			context.setFill(myColor);
			context.fillRect(getHitbox().x, getHitbox().y, 60, 60);
		}
		
	}
	
	@Override
	public void shoot() {
		float x = getHitbox().x + 25;
		float y = getHitbox().y + 15;
		
		BasicProjectile newProjectile = new BasicProjectile(30, 30, Color.LIGHTGREEN);
		
		if (getTowerLogic().checkUpgraded()) {
			newProjectile.getProjectileLogic().setDamage(2);
		}
		
		this.getProjectiles().add(newProjectile);
		newProjectile.setPos(x, y);
		newProjectile.drawYourself(getContext());
	}
	
	public void shootLoop() {
		
		loop = new Timeline(new KeyFrame(Duration.millis(1000.0/getTowerLogic().getAttackSpeed()), event -> shootLoop()));
		loop.play();
		
		shoot();
	}
	
	public void update() {
		
		for (Projectile projectile : projectiles) {
			projectile.updateYourself(getContext());
		}
		
		Iterator<Projectile> iterator = projectiles.iterator();
		
		while (iterator.hasNext()) {
			
			Projectile projectile = iterator.next();
			
			if (projectile.getHitboxPos() > 1440 || projectile.getHit()) {
				iterator.remove();
			}
		}
	}
	
	public ArrayList<Projectile> getProjectiles() {
		return projectiles;
	}
	
	public void upgradeTower() {
		
		getTowerLogic().doUpgraded();
	}

}
