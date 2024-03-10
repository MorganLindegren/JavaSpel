package grafikPaket;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Shape {

	private int x, y;
	private Color myColor;
	private static final double speed = 3;
	
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
	
	public int setX(int x) {
		
		return this.x = x;
	}
	
	public int setY(int y) {
		
		return this.x = y;
	}
	
	public Color getColor() {
		return myColor;
	}
	
	public void drawYourself(GraphicsContext context) {
		
	}
	
	public double getSpeed() {
		return speed;
	}
	
}
