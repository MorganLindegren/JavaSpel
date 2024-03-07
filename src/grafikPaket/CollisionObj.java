package grafikPaket;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class CollisionObj extends Shape {

	public CollisionObj(int x, int y, Color myColor) {
		super(x, y, myColor);
		
		}
	
	public void drawYourself(GraphicsContext context) {
		
		context.setFill(new Color(0,0,0,1));
		context.fillRect(1260, 100, 180, 900);
	
	}

}
