package grafikPaket;

import java.awt.geom.Rectangle2D;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class ProjectileSprite {
	
	private Rectangle2D.Float hitbox;
	private boolean active = true;
	
	public ProjectileSprite(int x, int y) {
		hitbox = new Rectangle2D.Float(x, y, 30, 30);
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
	
	public boolean isActive() {
		return active;
	}

}
