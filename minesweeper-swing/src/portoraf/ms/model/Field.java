package portoraf.ms.model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Field implements CellObserver {

	private final int numOfRows;
	private final int numOfCols;
	private final int numOfMines;
	
	private final List<Cell> cells = new ArrayList<>();
	private final List<Consumer<EventResult>> observers = new ArrayList<>();

	public Field(int numOfRows, int numOfCols, int numOfMines) {		
		this.numOfRows = numOfRows;
		this.numOfCols = numOfCols;
		this.numOfMines = numOfMines;
		
		generateCells();
		bindNeighbors();
		sortMines();
	}
	
	public void forEachCell(Consumer<Cell> function) {
		cells.forEach(function);
	}
	
	public void registerObserver(Consumer<EventResult> observer) {
		observers.add(observer);
	}
	
	private void notifyObservers(boolean result) {
		observers.stream().forEach(o -> o.accept(new EventResult(result)));
	}
	
	public void open(int row, int col) {
		cells.parallelStream()
			.filter(c -> c.getRow() == row && c.getCol() == col)
			.findFirst()
			.ifPresent(c -> c.open());
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
				Cell cell = new Cell(row, col);
				cell.registerObserver(this);
				cells.add(cell);
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
	
	public int getNumOfRows() {
		return numOfRows;
	}

	public int getNumOfCols() {
		return numOfCols;
	}

	public void eventOcurred(Cell cell, CellEvent event) {
		if (event == CellEvent.EXPLODE) {
			displayMines();
			notifyObservers(false);
		}		
		else if (goalMet()) {
			notifyObservers(true);
		}
	}

	private void displayMines() {
		cells.stream()
			.filter(c -> c.isMined())
			.forEach(c -> c.setOpen(true));		
	}
}
