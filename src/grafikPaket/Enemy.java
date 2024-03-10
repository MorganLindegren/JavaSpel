package grafikPaket;

import java.awt.geom.Rectangle2D;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import logikPaket.EnemyLogic;

public abstract class Enemy {
	
	private Rectangle2D.Float hitbox;
	private EnemyLogic enemyLogic = new EnemyLogic(3, 3);
	
	public Enemy(int x, int y, Color myColor) {

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

		this.hitbox.x -= enemyLogic.getSpeed();
		
		context.setFill(Color.RED);
		context.fillRect(hitbox.x, hitbox.y-30, 60, 100);
		
	}
	
	public void checkHit(EnemyBasic enemyBasic) {
		enemyBasic.checkHit(enemyBasic);
	}
	
	public EnemyLogic getEnemyLogic() {
		return enemyLogic;
	}

}
