package grafikPaket;

import java.util.ArrayList;

public class Model {
	
	private ArrayList<ArrayList<TowerSprite>> gridPos = new ArrayList<ArrayList<TowerSprite>>();
	
	public Model() {
		for (int i = 0; i < 5; i++) {
			ArrayList<TowerSprite> temp = new ArrayList<TowerSprite>(8);
			gridPos.add(temp);
		}
	}
	
	public ArrayList<ArrayList<TowerSprite>> getContents() {
		return gridPos;
	}
	

	public void addGridRect(TowerSprite rect, int row) {
		
			gridPos.get(row).add(rect);
	}
	
	public TowerSprite getGridRect(int row, int column) {
		
		return gridPos.get(row).get(column);
	}
}
