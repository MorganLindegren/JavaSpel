package grafikPaket;

import java.util.ArrayList;

import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.geometry.Bounds;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class TowerSprite extends Shape {
	
	private Boolean occupiedSpace = false;
	private double x, y;
	private ArrayList<ProjectileSprite> bullets = new ArrayList<>();

	public TowerSprite(int x, int y, Color myColor) {
		super(x, y, myColor);
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
	
	public void addTowerPos(GraphicsContext context) {
		
		context.setFill(getColor());
		context.fillRect(getX() + 60, getY() + 60, 60, 60);
		
		
	}
	
	public void addTowerModel(GraphicsContext context) {
		
		if (!occupiedSpace) {
			context.setFill(new Color(0, 0, 0, 0.5));
			context.clearRect(getX() + 60, getY() + 60, 60, 60);
			context.fillRect(getX()+ 60, getY() + 60, 60, 60);
			occupiedSpace = true;
			
		} else {
			return;
		}	
	}
	
	public void setUnOccupied() {
		occupiedSpace = false;
	}
	
	public void shoot(double x, double y) {
		double angle = 90;
		ProjectileSprite bullet = new ProjectileSprite(angle, 30, 30, Color.WHITE);
		this.bullets.add(bullet);
		
//		Rectangle rect = new Rectangle(1300,0);
//		rect.setLayoutX(-660);
//		rect.setLayoutY(-360);
//		Circle circ = new Circle(30, Color.WHITE);
//		PathTransition pt = new PathTransition();
//		Bounds projCoords = circ.localToScreen(circ.getBoundsInLocal());
//	
//		pt.setNode(circ);
//		pt.setPath(rect);
//		pt.setDuration(Duration.seconds(3));
//		pt.setAutoReverse(false);
//		pt.setCycleCount(Animation.INDEFINITE);
//		pt.play();
//		
	}

}
