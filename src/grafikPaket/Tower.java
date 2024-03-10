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
import logikPaket.TowerLogic;

abstract class Tower {
	
	private ArrayList<Projectile> bullets = new ArrayList<>();
	private Boolean occupiedSpace = false;
	private GraphicsContext context;
	private Color myColor;
	private Rectangle2D.Float hitbox = new Rectangle2D.Float();
	private TowerLogic towerLogic = new TowerLogic(1);
	Timeline loop = new Timeline();

	public Tower(int x, int y, GraphicsContext context) {
		this.context = context;
		
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
	
	public TowerLogic getTowerLogic() {
		
		return towerLogic;
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
	}
	
	public void shootLoop() {
	}	
	
	public void checkCollision(Enemy enemy) {
		
	}
	
	public void update() {
		
	}
}
