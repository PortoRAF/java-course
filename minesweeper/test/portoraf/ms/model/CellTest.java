package portoraf.ms.model;

import static org.junit.jupiter.api.Assertions.*;
//import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CellTest {

	private Cell cell;
	
	@BeforeEach
	void initCell() {
		cell = new Cell(3, 3);
	}
	
	@Test
	void testNeighborDistance1Left() {
		Cell neighbor = new Cell(3, 2);		
		boolean result = cell.addNeighbor(neighbor);		
		assertTrue(result);
	}
	
	@Test
	void testNeighborDistance1Right() {
		Cell neighbor = new Cell(3, 4);		
		boolean result = cell.addNeighbor(neighbor);		
		assertTrue(result);
	}
	
	@Test
	void testNeighborDistance1Up() {
		Cell neighbor = new Cell(2, 3);		
		boolean result = cell.addNeighbor(neighbor);		
		assertTrue(result);
	}
	
	@Test
	void testNeighborDistance1Down() {
		Cell neighbor = new Cell(4, 3);		
		boolean result = cell.addNeighbor(neighbor);		
		assertTrue(result);
	}
	
	@Test
	void testNeighborDistance2() {
		Cell neighbor = new Cell(2, 2);		
		boolean result = cell.addNeighbor(neighbor);		
		assertTrue(result);

		neighbor = new Cell(2, 4);		
		result = cell.addNeighbor(neighbor);		
		assertTrue(result);
		
		neighbor = new Cell(4, 2);		
		result = cell.addNeighbor(neighbor);		
		assertTrue(result);
		
		neighbor = new Cell(4, 4);		
		result = cell.addNeighbor(neighbor);		
		assertTrue(result);
	}
	
	@Test
	void testNotANeighbor() {
		Cell neighbor = new Cell(4, 5);		
		boolean result = cell.addNeighbor(neighbor);		
		assertFalse(result);
	}
}
