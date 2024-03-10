package logikPaket;

public class TowerLogic {
	
	private double attackSpeed;
	private int healthPoints = 1;
	private Boolean dmgUpgrade, slowUpgrade;

	public TowerLogic(double attackSpeed) {
		this.attackSpeed = attackSpeed;
		
		dmgUpgrade = false;
		slowUpgrade = false;
	}
	
	public int getHealthPoints() {
		return healthPoints;
	}
	
	public void towerHit() {
		healthPoints -= 1;
		
		System.out.println("Hej");
	}
	
	public void setAttackSpeed(double AS) {
		attackSpeed = AS;
	}
	
	public double getAttackSpeed() {
		return attackSpeed;
	}
	
	public Boolean towerDead() {
		
		return healthPoints == 0;
	}
	
	public Boolean checkDmgUpgrade() {
		return dmgUpgrade;
	}
	
	public void dmgUpgraded() {
		dmgUpgrade = true;
	}
	
	public Boolean checkSlowUpgrade() {
		return slowUpgrade;
	}
	
	public void slowUpgraded() {
		slowUpgrade = true;
	}
}
