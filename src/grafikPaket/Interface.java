package grafikPaket;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Interface extends Canvas{
	
	private Model gridModel = new Model();
	
	
	private GraphicsContext context = getGraphicsContext2D();

	public Interface() {
		setWidth(1440);
		setHeight(900);
		setStyle("-fx-background-color: #a31239;"); 
		
	}
	
	public void drawGrid() {
		
		int ymulti = 0;
		
		for (int row = 0; row < 5; row++) {
			
			int xmulti = 0;
			
			for (int i = 0; i < 8; i++) {
				
				Rect rect = new Rect(xmulti, ymulti, new Color(0, 0, 0, 0.0));
				rect.addTowerPos(context);
				gridModel.addGridRect(rect, row);
				
				xmulti += 180;
				
			}
			
			ymulti += 180;
			
		}
		
		setOnMouseClicked(event -> {
			int x = (int) event.getX();
			int y = (int) event.getY();
			
			if (x < 181) {
				x = 0;
			} else if (x < 361){
				x = 1;
			} else if (x < 541){
				x = 2;
			} else if (x < 721){
				x = 3;
			} else if (x < 901){
				x = 4;
			} else if (x < 1081){
				x = 5;
			} else if (x < 1261){
				x = 6;
			} else if (x < 1441){
				x = 7;
			}
			
			
			if (y < 181) {
				y = 0;
			} else if (y < 361){
				y = 1;
			} else if (y < 541){
				y = 2;
			} else if (y < 721){
				y = 3;
			} else if (y < 901){
				y = 4;
			}
			
			gridModel.getGridRect(y, x).addTowerModel(context);
			
		});
		
//		gridModel.getGridRect(eventX(, eventY()))
		
		gridModel.getGridRect(1, 4).addTowerModel(context);
		
	}
}
