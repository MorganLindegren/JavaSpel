package grafikPaket;

import java.awt.geom.Rectangle2D;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class ProjectileSprite extends Shape {
	
	private Rectangle2D.Float hitbox;
	private boolean active = true;
	private static final double speed = 5;
	private double angle, x,y;
	
	public ProjectileSprite(double angle, int x, int y, Color myColor) {
		super(x, y, myColor);
		hitbox = new Rectangle2D.Float(x, y, 30, 30);
		this.x = x;
		this.y = y;
		this.angle = angle;
	}
	
	public void updatePos() {
		hitbox.x += 15;
	}
	
	public void setPos(int x, int y) {
		hitbox.x = x;
		hitbox.y = y;
	}
	
	public Rectangle2D.Float getHitbox(){
		return hitbox;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}
	
	public void drawYourself(GraphicsContext context) {
		context.setFill(Color.WHITE);
		context.fillOval(hitbox.x, hitbox.y, 30, 30);
		
		this.hitbox.x += 5*speed;
		this.hitbox.y += 5*speed;
	}

	
	public boolean isActive() {
		return active;
	}
}
