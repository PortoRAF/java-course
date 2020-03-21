package portoraf.ms.model;

import java.util.ArrayList;
import java.util.List;

import portoraf.ms.exception.ExplosionException;

public class Cell {

	private final int row;
	private final int col;
	
	private boolean mined = false;
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
	
	void toggleFlagged() {
		if (!opened) {
			flagged = !flagged;
		}
	}
	
	boolean open() {
		if (!opened && !flagged) {
			opened = true;			
			if (mined) {
				throw new ExplosionException();
			}			
			if (safeNeighbor()) {
				neighbors.forEach(n -> n.open());
			}			
			return true;
		}
		else {		
			return false;
		}
	}
	
	boolean safeNeighbor() {
		return neighbors.stream().noneMatch(n -> n.mined);
	}
	
	void setMined() {
		if (!mined) {
			mined = true;
		}
	}
	
	public boolean isFlagged() {
		return flagged;
	}
	
	public boolean isOpen() {
		return opened;
	}
	
	public boolean isClosed() {
		return !isOpen();
	}
	
	public boolean isMined() {
		return mined;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}
	
	boolean goalMet() {
		boolean disclosed = !mined && opened;
		boolean secured = mined && flagged;
		return disclosed || secured;
	}
	
	long minesInVicinity() {
		return neighbors.stream().filter(n -> n.mined).count();
	}
	
	void restart() {
       mined = false;     
       opened = false;    
       flagged = false;
	}
	
	public String toString() {
		if (flagged) {
			return "x";
		}
		else if (opened && mined) {
			return "*";
		}
		else if (opened && minesInVicinity() > 0) {
			return Long.toString(minesInVicinity());
		}
		else if (opened) {
			return " ";
		}
		else {
			return "?";
		}
	}
}
