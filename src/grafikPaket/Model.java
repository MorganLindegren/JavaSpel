package grafikPaket;

import java.util.ArrayList;
import java.util.Stack;

public class Model {
	
	private ArrayList<ArrayList<Shape>> gridPos = new ArrayList<ArrayList<Shape>>();
	private ArrayList<Tower> towers = new ArrayList<Tower>();
	private Stack<Enemy> enemyWave1 = new Stack<Enemy>();
	private ArrayList<Enemy> aliveEnemy = new ArrayList<Enemy>();
	private String currentTower = "base";
	
	public Model() {
		
		for (int i = 0; i < 5; i++) {
			ArrayList<Shape> temp = new ArrayList<Shape>(8);
			gridPos.add(temp);
		}
	}
	
	public ArrayList<ArrayList<Shape>> getPos() {
		return gridPos;
	}
	
	public ArrayList<Tower> getTowers(){
		return towers;
	}
	
	public void setTower(String tower) {
		currentTower = tower;
	}
	
	public String getTower() {
		return currentTower;
	}

	public void addGridRect(Shape shape, int row) {
		
		gridPos.get(row).add(shape);
	}
	
	public Shape getGridRect(int row, int column) {
		
		return gridPos.get(row).get(column);
	}
	
	public Boolean checkGridEmpty() {
		return gridPos.isEmpty();
	}
	
	public Stack<Enemy> getEnemywave1(){
		return enemyWave1;
	}
	
	public ArrayList<Enemy> getAliveEnemies() {
		return aliveEnemy;
	}
}
