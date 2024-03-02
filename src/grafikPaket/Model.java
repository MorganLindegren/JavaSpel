package grafikPaket;

import java.util.ArrayList;

public class Model {
	
	private ArrayList<Rect> gridPos;
	
	public Model() {
		gridPos = new ArrayList<Rect>();
	}

	
	public void addGridRect(Rect rect) {
		gridPos.add(rect);
	}
	
	public Rect getGridRect(int pos, int row) {
		
		return gridPos.get(pos * (row + 1));
	}
}
