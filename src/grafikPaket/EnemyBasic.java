package grafikPaket;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class EnemyBasic extends Enemy {
	
	private Color myColor;
	
	public EnemyBasic(int x, int y, Color myColor) {
		super(x, y, myColor);
		this.myColor = myColor;
	}
	
	public void drawYourself(GraphicsContext context) {
		context.setFill(myColor);
		context.fillRect(getHitbox().x, getHitbox().y, 60, 100);
	}
	
	public void updateYourself(GraphicsContext context) {

		getHitbox().x -= getEnemyLogic().getSpeed();
		
		context.setFill(myColor);
		context.fillRect(getHitbox().x, getHitbox().y - 30, 60, 100);
		
	}
}
