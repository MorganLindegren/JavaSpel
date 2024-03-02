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
		int elements = 0;
		
		for (int row = 0; row < 5; row++) {
			int xmulti = 0;
			
			for (int i = 0; i < 8; i++) {
				
				Rect rect = new Rect(xmulti, ymulti, new Color(0, 0, 0, 0.5));
				rect.drawRect(context);
				gridModel.addGridRect(rect, row);
				
				xmulti += 180;
				
				elements++;
				
			}
			ymulti += 180;
		}
		
		System.out.println(gridModel.getGridRect().size());
		System.out.println(gridModel.getGridRect().get(0).size());
		System.out.println(elements);
		
		
		gridModel.getGridRect().get(0).get(1).addTowerTest(context);
	}
}
