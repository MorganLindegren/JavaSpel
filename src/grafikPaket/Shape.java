package grafikPaket;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * En egen rektangulär form som används för att rita ut det osynliga rutnätet som torn kan placeras på,
 * innehåller även en metod som lägger till tornen på platsen av Shape
 */

public class Shape {

	private int x, y;
	private Color myColor;
	private Tower tower;
	private Boolean occupiedSpace = false;
	
	public Shape(int x, int y, Color myColor){
		this.x = x;
		this.y = y;
		this.myColor = myColor;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int setX(int x) {
		
		return this.x = x;
	}
	
	public int setY(int y) {
		
		return this.x = y;
	}
	
	public Color getColor() {
		return myColor;
	}
	
	public void drawYourself(GraphicsContext context) {
		
	}
	
	public Boolean getOccupiedSpace() {
		return occupiedSpace;
	}
	
	public void setOccupiedSpace(Boolean bool) {
		occupiedSpace = bool;
	}
	
	public void addTower(Model model, GraphicsContext context) {
		int x,y;
		x = this.x;
		y = this.y;
		
		if (model.getTower().equals("base")) {
			BasicTower basic = new BasicTower(x, y, context);
			basic.addTowerModel(context, model);
			tower = basic;
		} else if (model.getTower().equals("slow")) {
			SlowTower slow = new SlowTower(x, y, context);
			slow.addTowerModel(context, model);
			tower = slow;
		}
		
		occupiedSpace = true;
	}
	
	public Tower getShapeTower() {
		return tower;
	}
	
	public void setShapeTowerNull() {
		tower = null;
	}
	
	public boolean checkSpace() {
		return tower != null;
	}
	
}
