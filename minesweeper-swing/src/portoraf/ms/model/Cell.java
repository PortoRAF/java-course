package portoraf.ms.model;

import java.util.ArrayList;
import java.util.List;

public class Cell {

	private final int row;
	private final int col;
	
	private boolean mined = false;
	private boolean opened = false;
	private boolean flagged = false;
	
	private List<Cell> neighbors = new ArrayList<>();
	private List<CellObserver> observers = new ArrayList<>();
	
	Cell(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	public void registerObserver(CellObserver observer) {
		observers.add(observer);
	}
	
	private void notifyObservers(CellEvent event) {
		observers.stream().forEach(o -> o.eventOcurred(this, event));
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
	
	public void toggleFlagged() {
		if (!opened) {
			flagged = !flagged;
			
			if (flagged) {
				notifyObservers(CellEvent.FLAG);
			}
			else {
				notifyObservers(CellEvent.UNFLAG);
			}
		}
	}
	
	public boolean open() {
		if (!opened && !flagged) {
			if (mined) {
				notifyObservers(CellEvent.EXPLODE);
				return true;
			}
			
			setOpen(true);
			
			if (safeNeighbor()) {
				neighbors.forEach(n -> n.open());
			}			
			return true;
		}
		else {		
			return false;
		}
	}
	
	public boolean safeNeighbor() {
		return neighbors.stream().noneMatch(n -> n.mined);
	}
	
	void setMined() {
		if (!mined) {
			mined = true;
		}
	}
	
	public boolean isMined() {
		return mined;
	}
	
	public boolean isFlagged() {
		return flagged;
	}
	
	void setOpen(boolean open) {
		this.opened = open;
		
		if (open) {
			notifyObservers(CellEvent.OPEN);
		}
	}
	
	public boolean isOpen() {
		return opened;
	}
	
	public boolean isClosed() {
		return !isOpen();
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
	
	public long minesInVicinity() {
		return neighbors.stream().filter(n -> n.mined).count();
	}
	
	void restart() {
       mined = false;     
       opened = false;    
       flagged = false;
       notifyObservers(CellEvent.RESTART);
	}
}
