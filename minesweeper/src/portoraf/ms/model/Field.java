package portoraf.ms.model;

import java.util.ArrayList;
import java.util.List;

import portoraf.ms.exception.ExplosionException;

public class Field {

	private int numOfRows;
	private int numOfCols;
	private int numOfMines;
	
	private final List<Cell> cells = new ArrayList<>();

	public Field(int numOfRows, int numOfCols, int numOfMines) {		
		this.numOfRows = numOfRows;
		this.numOfCols = numOfCols;
		this.numOfMines = numOfMines;
		
		generateCells();
		bindNeighbors();
		sortMines();
	}
	
	public void open(int row, int col) {
		try {
			cells.parallelStream()
				.filter(c -> c.getRow() == row && c.getCol() == col)
				.findFirst()
				.ifPresent(c -> c.open());
		}
		catch (ExplosionException e) {
			cells.forEach(c -> c.setOpen());
			throw e;
		}
	}
	
	public void flag(int row, int col) {
		cells.parallelStream()
		.filter(c -> c.getRow() == row && c.getCol() == col)
		.findFirst()
		.ifPresent(c -> c.toggleFlagged());
	}

	private void generateCells() {
		for (int row = 0; row < numOfRows; row++) {
			for (int col = 0; col < numOfCols; col++) {
				cells.add(new Cell(row, col));
			}
		}		
	}
	
	private void bindNeighbors() {
		for (Cell c1: cells) {
			for (Cell c2: cells) {
				c1.addNeighbor(c2);
			}
		}		
	}
	
	private void sortMines() {	
		int index;
		int mineCounter = 0;
		do {
			index = (int) (Math.random() * cells.size());
			if (!cells.get(index).isMined()) {
				cells.get(index).setMined();
				mineCounter++;
			}
		}
		while (mineCounter < numOfMines);
	}	
	
	public boolean goalMet() {
		return cells.stream().allMatch(c -> c.goalMet());
	}
	
	public void restart() {
		cells.stream().forEach(c -> c.restart());
		sortMines();
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();		
		int index = 0;
		
		sb.append("  ");
		for (int col = 0; col < numOfCols; col++) {
			sb.append(" ");
			sb.append(col);
			sb.append(" ");
		}
		sb.append("\n");
		for (int row = 0; row < numOfRows; row++) {
			sb.append(row + " ");
			for (int col = 0; col < numOfCols; col++) {
				sb.append(" ");
				sb.append(cells.get(index));
				sb.append(" ");
				index++;
			}
			sb.append("\n");
		}		
		return sb.toString();
	}
}
