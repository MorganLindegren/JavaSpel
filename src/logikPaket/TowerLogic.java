package logikPaket;

public class TowerLogic {
	
	private double attackSpeed;
	private int healthPoints = 1;
	private Boolean upgraded;

	public TowerLogic(double attackSpeed) {
		this.attackSpeed = attackSpeed;
		
		upgraded = false;
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
	
	public Boolean checkUpgraded() {
		return upgraded;
	}
	
	public void doUpgraded() {
		upgraded = true;
	}
	
	public void revertUpgraded() {
		upgraded = false;
	}
}
