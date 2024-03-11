package logikPaket;

public class TowerLogic {
	
	/**
	 * Håller koll på ett torns eldhastighet och om dess effekt har uppgraderats
	 * samt uppdaterar eldhastigheten om attack speed buffen köps
	 */
	
	private double attackSpeed;
	private Boolean upgraded;

	public TowerLogic(double attackSpeed) {
		this.attackSpeed = attackSpeed;
		
		upgraded = false;
	}
	
	public void setAttackSpeed(double AS) {
		attackSpeed = AS;
	}
	
	public double getAttackSpeed() {
		return attackSpeed;
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
