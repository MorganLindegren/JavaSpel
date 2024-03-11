package grafikPaket;

import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;
import logikPaket.ShopLogic;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Button;

public class Shop extends VBox {
	
	private ShopLogic shopLogic = new ShopLogic();
	private TowerButton previousTower;
	private Model myModel;
	private Text moneyText, currentScoreText;

	public Shop(double Height, Model myModel) {
		
		setStyle("-fx-background-color: #D3D3D3;"); 
		setHeight(Height);
		setWidth(300);
		this.myModel = myModel;
		
		Text text = new Text("Money:");
		text.setFont(new Font(14));
		moneyText = new Text(shopLogic.getMoney().toString());
		moneyText.setFont(new Font(20));
		
		Text scoreText = new Text("Score:");
		scoreText.setFont(new Font(20));
		currentScoreText = new Text(myModel.getScore().toString());
		currentScoreText.setFont(new Font(30));
		
		TowerButton setBase = new TowerButton(myModel, this, "base");
		TowerButton setSlow = new TowerButton(myModel, this, "slow");
		Button upgradeEffect = new Button("2x DMG, 5s");
		upgradeEffect.setOnAction(event -> {
			upgradeTowerDMG();
			shopLogic.buy();
			updateMoney();
		});
		upgradeEffect.setMinSize(100, 40);
		Button upgradeAS = new Button("2x AS, 5s");
		
		upgradeAS.setOnAction(event -> {
			upgradeTowerAS();
			shopLogic.buy();
			updateMoney();
		});
		upgradeAS.setMinSize(100, 40);
		
		previousTower = setBase;
		previousTower.ChangeTower();
		setBase.setBorder();
		
		setBase.ChangeTower();
		setSlow.ChangeTower();
		
		setBase.AddTower();
		setSlow.AddTower();
		
		getChildren().add(scoreText);
		getChildren().add(currentScoreText);
		
		getChildren().add(text);
		getChildren().add(moneyText);
		getChildren().add(setBase);
		getChildren().add(setSlow);
		getChildren().add(upgradeEffect);
		getChildren().add(upgradeAS);
		
	}
	
	public void updatePrevious(TowerButton towerbutton) {
		previousTower = towerbutton;
	}
	
	public void updateBorder() {
		previousTower.removeBorder();
	}
	
	public ShopLogic getShopLogic() {
		
		return shopLogic;
	}
	
	public void upgradeTowerDMG() {
		
		for (Tower tower : myModel.getTowers()) {
			tower.upgradeTower();
			
			Timeline normal = new Timeline(new KeyFrame(Duration.millis(10000), event -> tower.getTowerLogic().revertUpgraded()));
			normal.setCycleCount(1);
			normal.play();
		}
	}
	
	public void upgradeTowerAS() {
		for (Tower tower : myModel.getTowers()) {
			tower.upgradeTowerAS();
			
			Timeline normal = new Timeline(new KeyFrame(Duration.millis(10000), event -> tower.getTowerLogic().setAttackSpeed(1)));
			normal.setCycleCount(1);
			normal.play();
		}
	}
	
	public void updateMoney() {
		moneyText.setText((shopLogic.getMoney()).toString());
	}
	
	public void updateScore() {
		currentScoreText.setText(myModel.getScore().toString());
	}
}
