package grafikPaket;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Ansvarar för den grafiska modellen till vår egen knapp
 * TowerButton
 */

public abstract class MyButton extends Canvas {

	private GraphicsContext context = getGraphicsContext2D();
	
	public MyButton() {
		setWidth(50);
		setHeight(55);
		drawRect(context);
	}
	
	public void drawRect(GraphicsContext context) {
		context.setFill(new Color(0,0,0,0));
		context.fillRect(0, 0, 50, 50);
	}
	
	public GraphicsContext getContext() {
		return context;
	}
}
