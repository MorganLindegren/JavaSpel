package grafikPaket;

import java.util.ArrayList;

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
	
	private double x, y;
	private ArrayList<ProjectileSprite> bullets = new ArrayList<>();
	private Boolean occupiedSpace = false;
	private Timeline loop;

	public TowerSprite(int x, int y, Color myColor) {
		super(x, y, myColor);
		
		loop = new Timeline();
		loop.setCycleCount(Animation.INDEFINITE);
		loop.play();
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
			update(context);
		}
		
	}
	
	public void addTowerModel(GraphicsContext context) {
		
		occupiedSpace = true;
		context.setFill(new Color(0, 0, 0, 0.5));
		context.fillRect(getX()+ 60, getY() + 60, 60, 60);
			
	}
	
	public void shoot(GraphicsContext context) {
		int x = getX() + 75;
		int y = getY() + 75;
		
		double angle = 90;
		ProjectileSprite bullet = new ProjectileSprite(angle, 30, 30, Color.WHITE, this);
		this.bullets.add(bullet);
		bullet.setPos(x, y);
		bullet.drawYourself(context);	
	}
	
	public ArrayList<ProjectileSprite> getBullets(){
		return bullets;
	}
	
	public void update(GraphicsContext context) {
		
		loop = new Timeline(new KeyFrame(Duration.millis(1000.0/30), event -> update(context)));
		shoot(context);
		
	}

}
