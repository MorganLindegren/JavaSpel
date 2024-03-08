package grafikPaket;

import java.util.ArrayList;
import java.util.Iterator;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.geometry.Bounds;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class TowerSprite extends Shape {
	
	private ArrayList<ProjectileSprite> bullets = new ArrayList<>();
	private Boolean occupiedSpace = false;
	private GraphicsContext context;
	Timeline loop = new Timeline();

	public TowerSprite(int x, int y, Color myColor, GraphicsContext context) {
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
	
	public void addTowerModel(GraphicsContext context) {
		
		if (!occupiedSpace) {
			shootLoop();
			occupiedSpace = true;
		}
		context.setFill(new Color(0, 0, 0, 0.5));
		context.fillRect(getX() + 60, getY() + 60, 60, 60);
			
	}
	
	public void shoot() {
		int x = getX() + 75;
		int y = getY() + 75;
		
		ProjectileSprite newProjectile = new ProjectileSprite(30, 30, Color.WHITE, this);
		this.bullets.add(newProjectile);
		newProjectile.setPos(x, y);
		newProjectile.drawYourself(context);
	}
	
	public ArrayList<ProjectileSprite> getBullets(){
		return bullets;
	}
	
    public void collision() {
		bullets.remove(0);
	}
	
	public void shootLoop() {
		
		loop = new Timeline(new KeyFrame(Duration.millis(1000.0/5), event -> shootLoop()));
		loop.play();
		
		shoot();
		System.out.println(bullets.size());
	}	
	
	public void update() {
		
		for (ProjectileSprite projectile : bullets) {
			projectile.drawYourself(context);
		}
		
		Iterator<ProjectileSprite> iterator = bullets.iterator();
		
		while (iterator.hasNext()) {
			
			ProjectileSprite projectile = iterator.next();
			
			if (projectile.getHitbox() > 1280) {
				iterator.remove();
			}
		}
	}
}
