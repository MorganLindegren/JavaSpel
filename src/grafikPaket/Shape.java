package grafikPaket;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Shape {

	private int x, y;
	private Color myColor;
	
	public Shape(int x, int y, Color myColor){
		this.x = x;
		this.y = y;
		this.myColor = myColor;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public Color getColor() {
		return myColor;
	}
	
	public void drawYourself(GraphicsContext context) {
		
	}
	
}
