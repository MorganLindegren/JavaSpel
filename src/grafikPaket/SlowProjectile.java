package grafikPaket;

import javafx.scene.paint.Color;
import logikPaket.ProjectileLogicSlow;

/**
 * En variant av Projectile som saktar ner fienden när de blir träffade
 */

public class SlowProjectile extends Projectile {
	
	private ProjectileLogicSlow projectileLogic = new ProjectileLogicSlow(0.3);
	
	public SlowProjectile( int x, int y, Color myColor) {
		super(x, y, myColor);
	}
	
	@Override
	public void checkCollision(Enemy enemy) {
		if (getHitbox().intersects(enemy.getHitbox())) {
			
			setHit(true);
			enemy.getEnemyLogic().isSlowed(projectileLogic);
		}
	}
	
	public ProjectileLogicSlow getProjectileLogic() {
		return projectileLogic;
	}
}
