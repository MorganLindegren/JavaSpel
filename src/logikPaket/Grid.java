package logikPaket;

import java.util.ArrayList;

public class Grid {
	
	private ArrayList<ArrayList<int[]>> positions = new ArrayList<ArrayList<int[]>>();
	
	public void createGrid() {
		int elements = 0;
		for (int row = 0; row < 5; row++ ) {
			positions.add(new ArrayList<int[]>());
			
			for (int i = 0; i < 8; i ++) {
				int[] temp = {row, i};
				
				positions.get(row).add(temp);
				
				elements++;
			}
		}
		
		System.out.println(elements);
	}

}
