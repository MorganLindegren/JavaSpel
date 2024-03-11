package logikPaket;

public class ProjectileLogic {

	/**
	 * Håller koll på hur mycket skada BasicProjectiles ska göra
	 */
	private int damage;
	public ProjectileLogic(int damage) {
		this.damage = damage;
	}
	
	public int getDamage() {
		return damage;
	}
	
	public void setDamage(int dmg) {
		damage = dmg;
	}
}
