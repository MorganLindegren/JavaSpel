package grafikPaket;

import java.awt.geom.Rectangle2D;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Enemy extends Shape {
	
	private Rectangle2D.Float hitbox;
	private Boolean hit = false;
	private Timeline alreadyHit = new Timeline();

	public Enemy(int x, int y, Color myColor) {
		super(x, y, myColor);
		
		hitbox = new Rectangle2D.Float(x, y, 30, 30);
	}
	
	public void drawYourself(GraphicsContext context) {
		context.setFill(Color.RED);
		context.fillRect(hitbox.x, hitbox.y, 60, 100);
	}
	
	public Rectangle2D.Float getHitbox() {
		return hitbox;
	}
	
	public void updateYourself(GraphicsContext context) {

		this.hitbox.x -= 1*getSpeed();
		
		context.setFill(Color.RED);
		context.fillRect(hitbox.x, hitbox.y-30, 60, 100);
		
	}
	
	public void setHit() {
		hit = false;
	}
	
	public Boolean getHit() {
		return hit;
	}
	
	public void Hit() {
		hit = true;
		
		alreadyHit = new Timeline(new KeyFrame(Duration.millis(1000.0/5), event -> setHit()));
		alreadyHit.setCycleCount(1);
		alreadyHit.play();
	}

}
