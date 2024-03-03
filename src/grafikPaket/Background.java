package grafikPaket;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Background extends Canvas{
	
	private Model gridModel = new Model();
	
	private GraphicsContext context = getGraphicsContext2D();

	public Background() {
		setWidth(1440);
		setHeight(900);
		setStyle("-fx-background-color: #a31239;"); 
		
	}
	
	public void drawGrid() {
		
		int ymulti = 0;
		int xmulti = 0;
		int elements = 0;
		
		for (int row = 0; row < 5; row++) {
			
			for (int i = 0; i < 8; i++) {
				
				if (row == 2) {
					ymulti += 360;
				}
				
				Rect rect = new Rect(xmulti, ymulti, new Color(0, 0, 0, 0.75));
				rect.addTowerPos(context);
				gridModel.addGridRect(rect, row);
				
				elements++;
				
				xmulti += 180;
				
			}
			
		}
		
		System.out.println(gridModel.getGridRect().size());
		System.out.println(gridModel.getGridRect().get(0).size());
		System.out.println(elements);
		
	}
}
