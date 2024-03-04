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
			Rect towerModel = new Rect(x, y, Color.BLACK);
			towerModel.addTowerModel(context);
			
		});
		
		gridModel.getGridRect(1, 1).addTowerModel(context);
		
		ProjectileSprite projectile = new ProjectileSprite(180, 180, Color.WHITE);
		projectile.drawYourself(context);
		
	}
}
