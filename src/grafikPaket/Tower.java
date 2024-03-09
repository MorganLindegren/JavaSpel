package grafikPaket;

import java.util.ArrayList;
import java.util.Iterator;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Tower extends Shape {
	
	private ArrayList<Projectile> bullets = new ArrayList<>();
	private Boolean occupiedSpace = false;
	private GraphicsContext context;
	private SlowTower slowtower;
	Timeline loop = new Timeline();

	public Tower(int x, int y, Color myColor, GraphicsContext context) {
		super(x, y, myColor);
		this.context = context;
	
		loop.setCycleCount(Animation.INDEFINITE);
	}
	
	public void drawYourself(GraphicsContext context, double xsize, double ysize) {
		
		context.setFill(getColor());
		context.fillRect(getX(), getY(), xsize, ysize);
		
	}
	
	public void drawRect(GraphicsContext context) {
		context.setFill(getColor());
		context.fillRect(getX(), getY(), 180, 180);
		context.setFill(Color.BLACK);
		context.fillRect(getX(), getX(), 180, 3);
		context.setStroke(Color.GREY);
		context.stroke();
	}
	
	public void drawTower(GraphicsContext context) {
		
		if (occupiedSpace) {
			context.setFill(new Color(0, 0, 0, 0.5));
			context.fillRect(getX() + 60, getY() + 60, 60, 60);
		}
		
	}
	
	public void addTowerModel(GraphicsContext context, Model model) {
		
		if (!occupiedSpace) {
			shootLoop();
			occupiedSpace = true;
		}
		context.setFill(new Color(0, 0, 0, 0.5));
		context.fillRect(getX() + 60, getY() + 60, 60, 60);
		model.getTowers().add(this);
			
	}
	
	public void addSlowTowerModel(GraphicsContext context, Model model) {
		slowtower.addTowerModel(context, model);
	}
	
	public void shoot() {
		int x = getX() + 75;
		int y = getY() + 75;
		
		Projectile newProjectile = new Projectile(30, 30, Color.WHITE);
		this.bullets.add(newProjectile);
		newProjectile.setPos(x, y);
		newProjectile.drawYourself(context);
	}
	
	public ArrayList<Projectile> getBullets(){
		return bullets;
	}
	
    public void collision() {
		bullets.remove(0);
	}
	
	public void shootLoop() {
		
		loop = new Timeline(new KeyFrame(Duration.millis(1000.0/1), event -> shootLoop()));
		loop.play();
		
		shoot();
	}	
	
	public void update() {
		
		for (Projectile projectile : bullets) {
			projectile.updateYourself(context);
		}
		
		Iterator<Projectile> iterator = bullets.iterator();
		
		while (iterator.hasNext()) {
			
			Projectile projectile = iterator.next();
			
			if (projectile.getHitboxPos() > 1280) {
				iterator.remove();
			}
			if (projectile.checkHit()) {
				iterator.remove();
			}
		}
	}
}
