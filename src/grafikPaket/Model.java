package grafikPaket;

import java.util.ArrayList;

public class Model {
	
	private ArrayList<ArrayList<Rect>> gridPos = new ArrayList<ArrayList<Rect>>();
	
	public Model() {
		for (int i = 0; i < 5; i++) {
			ArrayList<Rect> temp = new ArrayList<Rect>();
			gridPos.add(temp);
		}
	}
	

	public void addGridRect(Rect rect, int row) {
		
			gridPos.get(row).add(rect);
	}
	
	public Rect getGridRect(int row, int column) {
		
		return gridPos.get(row).get(column);
	}
}
