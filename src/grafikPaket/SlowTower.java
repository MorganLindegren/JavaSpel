package grafikPaket;

import java.util.ArrayList;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class SlowTower extends Tower {
	
	private ArrayList<Projectile> bullets = new ArrayList<>();
	private GraphicsContext context;
	private Boolean occupiedSpace = false;
	double[] xp = new double[]{getX(), (getX() + 20), (getX() - 20)};
	double[] yp = new double[]{(getY() - 20), (getY() + 15), (getY() + 15)};

	public SlowTower(int x, int y, Color myColor, GraphicsContext context) {
		super(x, y, myColor, context);
		this.context = context;
	}
	
	public void drawYourself(GraphicsContext context) {
		
		context.setFill(getColor());
		context.fillPolygon(xp, yp, 3);

	}
	
	public void addTowerModel(GraphicsContext context, Model model) {
		
		if (!occupiedSpace) {
			shootLoop();
			occupiedSpace = true;
		}
		context.setFill(getColor());
		context.fillPolygon(xp, yp, 3);
		model.getTowers().add(this);
			
	}
	
	public void drawTower(GraphicsContext context) {
		
		if (occupiedSpace) {
			context.setFill(getColor());
			context.fillPolygon(xp, yp, 3);
		}
		
	}
	
	public void shoot() {
		int x = getX() + 75;
		int y = getY() + 75;
		
		Projectile newProjectile = new Projectile(30, 30, Color.LIGHTBLUE);
		this.bullets.add(newProjectile);
		newProjectile.setPos(x, y);
		newProjectile.drawYourself(context);
	}
	
	public void shootLoop() {
		
		loop = new Timeline(new KeyFrame(Duration.millis(1000.0/1), event -> shootLoop()));
		loop.play();
		
		shoot();
	}	
	

}
