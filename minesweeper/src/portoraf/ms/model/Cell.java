package portoraf.ms.model;

import java.util.ArrayList;
import java.util.List;

public class Cell {

	private final int row;
	private final int col;
	
	private boolean hasMine = false;
	private boolean opened = false;
	private boolean flagged = false;
	
	private List<Cell> neighbors = new ArrayList<>();
	
	Cell(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	boolean addNeighbor(Cell neighbor) {
		boolean rowIsDiff = row != neighbor.row;
		boolean colIsDiff = col != neighbor.col;
		boolean diagonal = rowIsDiff && colIsDiff;
		
		int deltaRow = Math.abs(row - neighbor.row);
		int deltaCol = Math.abs(col - neighbor.col);
		int deltaAbsolute = deltaRow + deltaCol;
		
		if (deltaAbsolute == 1 && !diagonal) {
			neighbors.add(neighbor);
			return true;
		}
		else if (deltaAbsolute == 2 && diagonal) {
			neighbors.add(neighbor);
			return true;			
		}
		else {
			return false;
		}
	}
}
