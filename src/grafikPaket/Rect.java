package grafikPaket;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rect extends Shape {
	
	private Boolean occupiedSpace = false;
	private ProjectileSprite projectile = new ProjectileSprite(0, 0, Color.WHITE);

	public Rect(int x, int y, Color myColor) {
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
//		context.fillRect(getX(), getY(), 3, 180);
		context.fillRect(getX(), getX(), 180, 3);
//		context.fillRect(getX() + 180, getY(), 180, 3);
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
			projectile.setPos(getX()+60,getY()+75);
			shoot(context);
			
			occupiedSpace = true;
			
		} else {
			return;
		}	
	}
	
	public void shoot(GraphicsContext context) {
		
		projectile.setPos((int)projectile.getHitbox().x,(int)projectile.getHitbox().y);
		projectile.updatePos();
		projectile.drawYourself(context);
	}

}
