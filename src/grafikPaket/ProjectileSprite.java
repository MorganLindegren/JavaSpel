package grafikPaket;

import java.awt.geom.Rectangle2D;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class ProjectileSprite extends Shape {
	
	private Rectangle2D.Float hitbox;
	private boolean active = true;
	private static final double speed = 3;
	private double angle, x,y;
	
	public ProjectileSprite(double angle, int x, int y, Color myColor, TowerSprite Tower) {
		super(x, y, myColor);
		hitbox = new Rectangle2D.Float(x, y, 30, 30);
		this.x = Tower.getX();
		this.y = Tower.getY();
		this.angle = angle;
	}
	
	public void updatePos() {
		hitbox.x += 15;
	}
	
	public void setPos(double x, double y) {
		hitbox.x = (float) (x + 75);
		hitbox.y = (float) (y + 75);
	}
	
	public Rectangle2D.Float getHitbox(){
		return hitbox;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}
	
	public void drawYourself(GraphicsContext context) {
		this.hitbox.x += 5*speed;
		
		context.setFill(Color.WHITE);
		context.fillOval(hitbox.x, hitbox.y, 30, 30);
	
	}

	
	public boolean isActive() {
		return active;
	}
}
