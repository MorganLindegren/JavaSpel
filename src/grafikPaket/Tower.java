package grafikPaket;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Iterator;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.util.Duration;

abstract class Tower {
	
	private ArrayList<Projectile> bullets = new ArrayList<>();
	private Boolean occupiedSpace = false;
	private GraphicsContext context;
	private Color myColor;
	private Rectangle2D.Float hitbox = new Rectangle2D.Float();
	private int x, y;
	Timeline loop = new Timeline();

	public Tower(int x, int y, GraphicsContext context) {
		this.context = context;
		this.x = x;
		this.y = y;
		
		hitbox.x = x + 60;
		hitbox.y = y + 60;
	
		loop.setCycleCount(Animation.INDEFINITE);
	}
	
	public GraphicsContext getContext() {
		return context;
	}
	
	public Rectangle2D.Float getHitbox() {
		return hitbox;
	}
	
	public Color getColor() {
		return myColor;
	}
	
	public ArrayList<Projectile> getProjectiles(){
		return bullets;
	}
	
	public Boolean getOccupiedSpace() {
		return occupiedSpace;
	}
	
	public void setOccupiedSpace(Boolean bool) {
		occupiedSpace = bool;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void drawRect(GraphicsContext context) {
		context.setFill(myColor);
		context.fillRect(hitbox.x, hitbox.y, 180, 180);
		context.setFill(Color.BLACK);
		context.fillRect(hitbox.x, hitbox.y, 180, 3);
		context.setStroke(Color.GREY);
		context.stroke();
	}
	
	public void updateTower(GraphicsContext context) {
		
		if (occupiedSpace) {
			context.setFill(new Color(0, 0, 0, 0.5));
			context.fillRect(hitbox.x + 60, hitbox.y + 60, 60, 60);
		}
		
	}
	
	public void addTowerModel(GraphicsContext context, Model model) {
		
		if (!occupiedSpace) {
			shootLoop();
			occupiedSpace = true;
		}
		context.setFill(new Color(0, 0, 0, 0.5));
		context.fillRect(hitbox.x + 60, hitbox.y + 60, 60, 60);
		model.getTowers().add(this);
			
	}
	
	public void shoot() {
		Float x = hitbox.x + 75;
		Float y = hitbox.y + 75;
		
		Projectile newProjectile = new Projectile(30, 30, Color.WHITE);
		this.bullets.add(newProjectile);
		newProjectile.setPos(x, y);
		newProjectile.drawYourself(context);
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
			
			if (projectile.getHitboxPos() > 1440 || projectile.checkHit()) {
				iterator.remove();
			}
		}
	}
}
