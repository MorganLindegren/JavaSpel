package grafikPaket;

import javafx.scene.paint.Color;
import logikPaket.ProjectileLogic;

public class BasicProjectile extends Projectile {
	
	private ProjectileLogic projectileLogic = new ProjectileLogic(1);
	
	public BasicProjectile(int x, int y, Color myColor ) {
		super(x, y, myColor);
	}
	
	@Override
	public void checkCollision(Enemy enemy) {
		if (getHitbox().intersects(enemy.getHitbox())) {
			
			setHit(true);
			enemy.getEnemyLogic().enemyHit(projectileLogic);
		}
	}
	
	public ProjectileLogic getProjectileLogic() {
		return projectileLogic;
	}
}
