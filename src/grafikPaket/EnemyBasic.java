package grafikPaket;

import javafx.scene.canvas.GraphicsContext;
import logikPaket.EnemyBasicLogic;
import javafx.scene.paint.Color;

public class EnemyBasic extends Enemy {
	
	private Color myColor;
	private EnemyBasicLogic ebl;
	private Boolean hit = false;
	
	public EnemyBasic(int x, int y, Color myColor) {
		super(x, y, myColor);
		this.myColor = myColor;
		this.ebl = ebl;
	}
	
	public void drawYourself(GraphicsContext context) {
		context.setFill(myColor);
		context.fillRect(getHitbox().x, getHitbox().y, 60, 100);
	}
	
	public void updateYourself(GraphicsContext context) {

		this.getHitbox().x -= 1*getEnemySpeed();
		
		context.setFill(getColor());
		context.fillRect(getHitbox().x, getHitbox().y - 30, 60, 100);
		
	}
	
	public void checkHit(Enemy enemy) {	
		hit = true;		
	}
	
}
