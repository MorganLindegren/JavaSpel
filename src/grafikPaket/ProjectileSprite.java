package grafikPaket;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class ProjectileSprite extends Shape {
	
	public ProjectileSprite(int x, int y, Color myColor) {
		super(x, y, myColor);
	}
	
	public void drawYourself(GraphicsContext context) {
		
		context.setFill(getColor());
		context.fillOval(getX() + 75, getX() + 75, 30, 30);
		
	}
	
	public void setX(int x) {
		
		
	}

}
