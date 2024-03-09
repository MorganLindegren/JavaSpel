package grafikPaket;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class TowerButton extends MyButton {

	private Model myModel;
	private GraphicsContext context = getGraphicsContext2D();
	private String tower;
	private Shop shop;
	
	public TowerButton(Model myModel, Shop shop, String tower) {
		this.myModel = myModel;
		this.tower = tower;

	}
	
	public void ChangeTower() {
		setOnMouseClicked(event -> {
			myModel.setTower(tower);
		});
	}
	
	public void AddTower() {
		
		if (tower.equals("base")) {
			Tower baseTower = new Tower(11, 12, Color.BLACK, context);
			baseTower.drawYourself(context, 30, 30);
		} else if (tower.equals("slow")) {
			SlowTower slow = new SlowTower(25, 25, Color.BLACK, context);
			slow.drawYourself(context);
		}
	}	
}
