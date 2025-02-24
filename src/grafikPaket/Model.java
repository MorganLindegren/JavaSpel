package grafikPaket;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Håller ordning på alla listor med objekten som används i spelet
 * samt det torn som just nu är valt, spelarens poäng och våg av fiender
 */

public class Model {
	
	private ArrayList<ArrayList<Shape>> gridPos = new ArrayList<ArrayList<Shape>>();
	private ArrayList<Tower> towers = new ArrayList<Tower>();
	private Stack<Enemy> enemyWave1, enemyWave2, enemyWave3, enemyWave4 = new Stack<Enemy>();
	private ArrayList<Enemy> aliveEnemy = new ArrayList<Enemy>();
	private String currentTower = "base";
	private Integer score = 0;
	private Integer wave = 1;
	private static Integer level = 1;
	
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
	
	public void setEnemywave1(Stack<Enemy> wave) {
		enemyWave1 = wave;
	}
	
	public Stack<Enemy> getEnemywave2() {
		return enemyWave2;
	}
	
	public void setEnemywave2(Stack<Enemy> wave) {
		enemyWave2 = wave;
	}
	
	public Stack<Enemy> getEnemywave3() {
		return enemyWave3;
	}
	
	public void setEnemywave3(Stack<Enemy> wave) {
		enemyWave3 = wave;
	}
	
	public Stack<Enemy> getEnemywave4() {
		return enemyWave4;
	}
	
	public void setEnemywave4(Stack<Enemy> wave) {
		enemyWave4 = wave;
	}
	
	public ArrayList<Enemy> getAliveEnemies() {
		return aliveEnemy;
	}
	
	public Integer getScore() {
		return score;
	}
	
	public void increaseScore() {
		score += 1;
	}
	
	public Integer getWave() {
		return wave;
	}
	
	public void setWave(int wave) {
		this.wave = wave;
	}
	
	public Integer getLevel() {
		return level;
	}
	
	public void setLevel() {
		level = 2;
	}
}
