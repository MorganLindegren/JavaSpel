package grafikPaket;

import java.awt.geom.Rectangle2D;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Projectile extends Shape {
	
	private Rectangle2D.Float hitbox;
	private Boolean hit = false;
	
	public Projectile( int x, int y, Color myColor) {
		super(x, y, myColor);
		hitbox = new Rectangle2D.Float(x, y, 30, 30);
	}
	
	public void updatePos() {
		hitbox.x += 15;
	}
	
	public void setPos(double x, double y) {
		hitbox.x = (float) (x + 25);
		hitbox.y = (float) (y);
	}
	
	public float getHitboxPos(){
		return hitbox.x;
	}
	
	public Rectangle2D.Float getHitbox(){
		return hitbox;
	}
	
	public void drawYourself(GraphicsContext context) {
		context.setFill(getColor());
		context.fillOval(hitbox.x, hitbox.y, 30, 30);
	}
	
	public void updateYourself(GraphicsContext context) {
		this.hitbox.x += 5*getSpeed();
		
		context.setFill(getColor());
		context.fillOval(hitbox.x, hitbox.y, 30, 30);
	
	}
	
	public void removeYourself(GraphicsContext context) {
		context.clearRect(hitbox.x, hitbox.y, 30, 30);
	}
	
	public Boolean checkHit() {
		return hit;
	}
	
	public void checkCollision(Enemy enemy) {
		if (hitbox.intersects(enemy.getHitbox())) {
			
			hit = true;
			System.out.println("Träff");
		}
	}
}
