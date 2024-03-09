package grafikPaket;

import javafx.scene.layout.VBox;

public class Shop extends VBox {
	
	private TowerButton previousTower;

	public Shop(double Height, Model myModel) {
		
		setStyle("-fx-background-color: #D3D3D3;"); 
		setHeight(Height);
		setWidth(300);
		
		TowerButton setBase = new TowerButton(myModel, this, "base");
		TowerButton setSlow = new TowerButton(myModel, this, "slow");
		
		previousTower = setBase;
		previousTower.ChangeTower();
		
		setBase.ChangeTower();
		setSlow.ChangeTower();
		
		setBase.AddTower();
		setSlow.AddTower();
		
		getChildren().add(setBase);
		getChildren().add(setSlow);
	}
	
	
}
