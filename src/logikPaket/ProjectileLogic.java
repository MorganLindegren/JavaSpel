package logikPaket;

public class ProjectileLogic {

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
