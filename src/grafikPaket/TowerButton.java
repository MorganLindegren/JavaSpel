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
		this.shop = shop;

	}
	
	public void ChangeTower() {
		setOnMouseClicked(event -> {
			myModel.setTower(tower);
		});
	}
	
	public void AddTower() {
		
		if (tower.equals("base")) {
			BasicTower basic = new BasicTower(30, 30, context);
			basic.drawTower(context);
		} else if (tower.equals("slow")) {
			SlowTower slow = new SlowTower(30, 30, context);
			slow.drawTower(context);
		}
	}
	
	public Shop getShop() {
		return shop;
	}
}
