package grafikPaket;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rect extends Shape {

	public Rect(int x, int y, Color myColor) {
		super(x, y, myColor);
	}
	
	public void drawYourself(GraphicsContext context, double xsize, double ysize) {
		
		context.setFill(getColor());
		context.fillRect(getX(), getY(), xsize, ysize);
		
	}
	
	public void drawRect(GraphicsContext context) {
		context.setFill(getColor());
		context.fillRect(getX(), getY(), 180, 180);
		context.setFill(Color.BLACK);
//		context.fillRect(getX(), getY(), 3, 180);
		context.fillRect(getX(), getX(), 180, 3);
//		context.fillRect(getX() + 180, getY(), 180, 3);
		context.setStroke(Color.GREY);
		context.stroke();
	}
	
	public void addTowerPos(GraphicsContext context) {
		
		context.setFill(getColor());
		context.fillRect(getX()+ 60, getY() + 60, 60, 60);
		
		
	}
}
