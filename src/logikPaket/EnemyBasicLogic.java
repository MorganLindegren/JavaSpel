package logikPaket;

import grafikPaket.EnemyBasic;
import grafikPaket.Projectile;
import javafx.scene.canvas.GraphicsContext;

public class EnemyBasicLogic extends Unit{

	private int healthPoints = 10;
	private int moveSpeed;
	private int hits;
	private EnemyBasic enemy;
	private Projectile projectile;
	
	public EnemyBasicLogic(int healthpoints, double moveSpeed, EnemyBasic enemy) {
		super(healthpoints, moveSpeed);
		
	}
	
	public void reduceHP(EnemyBasic enemy) {
			hits++;
			System.out.println("hej");
	}
	
	public void kill(GraphicsContext context) {
		if (hits == 5) {
			
		}
	}
	
}
