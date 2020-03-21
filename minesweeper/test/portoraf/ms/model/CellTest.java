package portoraf.ms.model;

//import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import portoraf.ms.exception.ExplosionException;

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
	
	@Test
	void testStandardIsFlaggedValue() {
		assertFalse(cell.isFlagged());		
	}
	
	@Test
	void testToggleFlagged() {
		cell.toggleFlagged();
		assertTrue(cell.isFlagged());
	}

	@Test
	void testToggleFlaggedTwoTimes() {
		cell.toggleFlagged();
		cell.toggleFlagged();
		assertFalse(cell.isFlagged());
	}
	
	@Test
	void testOpenCellNotMinedNotFlagged() {
		assertTrue(cell.open());
	}

	@Test
	void testOpenCellNotMinedFlagged() {
		cell.toggleFlagged();
		assertFalse(cell.open());
	}	
	
	@Test
	void testOpenCellMinedFlagged() {
		cell.toggleFlagged();
		cell.setMined();
		assertFalse(cell.open());
	}
	
	@Test
	void testOpenCellMinedNotFlagged() {		
		cell.setMined();
		
		assertThrows(ExplosionException.class, () -> {
			cell.open();			
		});		
	}
	
	@Test
	void testOpenWithNeighbors() {
		Cell cell11 = new Cell(1, 1);
		Cell cell12 = new Cell(1, 2);
		cell12.setMined();
		
		Cell cell22 = new Cell(2, 2);		
		cell22.addNeighbor(cell11);		
		cell22.addNeighbor(cell12);
		
		cell.addNeighbor(cell22);		
		cell.open();
		
		assertTrue(cell22.isOpen() && !cell11.isOpen());
	}	
	
	@Test
	void testGoalMetMinedFlagged() {
		cell.setMined();
		cell.toggleFlagged();		
		assertTrue(cell.goalMet());
	}
	
	@Test
	void testGoalMetMinedNotFlagged() {
		cell.setMined();			
		assertFalse(cell.goalMet());
	}
	
	@Test
	void testGoalMetNotMinedOpened() {
		cell.open();		
		assertTrue(cell.goalMet());
	}
	
	@Test
	void testGoalMetNotMinedFlagged() {
		cell.toggleFlagged();;		
		assertFalse(cell.goalMet());
	}
	
	@Test
	void testMinesInVicinity0Mines() {
		Cell cell11 = new Cell(1,1);
		Cell cell12 = new Cell(1,2);
		Cell cell22 = new Cell(2,2);
		Cell cell44 = new Cell(4,4);
		
		cell.addNeighbor(cell11);
		cell.addNeighbor(cell12);
		cell.addNeighbor(cell22);
		cell.addNeighbor(cell44);
		
		long mines = cell.minesInVicinity();
		
		assertEquals(0, mines);		
	}
	
	@Test
	void testMinesInVicinity3Mines() {
		Cell cell12 = new Cell(1,2);
		Cell cell32 = new Cell(3,2);
		Cell cell34 = new Cell(3,4);
		Cell cell44 = new Cell(4,4);
		
		cell12.setMined();
		cell32.setMined();
		cell34.setMined();
		cell44.setMined();
		
		assertFalse(cell.addNeighbor(cell12));
		assertTrue(cell.addNeighbor(cell32));
		assertTrue(cell.addNeighbor(cell34));
		assertTrue(cell.addNeighbor(cell44));
		
		long mines = cell.minesInVicinity();
		
		assertEquals(3, mines);		
	}
	
	@Test
	void testToString() {
		assertEquals("?", cell.toString());
		
		cell.toggleFlagged();
		assertEquals("x", cell.toString());
		
		cell.toggleFlagged();
		cell.setMined();
		assertThrows(ExplosionException.class, () -> cell.open());
		assertEquals("*", cell.toString());		
	}
	
	@Test
	void testToStringMinesInVicinity() {
		Cell cell12 = new Cell(1,2);
		Cell cell32 = new Cell(3,2);
		Cell cell34 = new Cell(3,4);
		Cell cell44 = new Cell(4,4);
		
		cell12.setMined();
		cell32.setMined();
		cell34.setMined();
		cell44.setMined();
		
		cell.addNeighbor(cell12);
		cell.addNeighbor(cell32);
		cell.addNeighbor(cell34);
		cell.addNeighbor(cell44);
		
		cell.open();
		
		assertEquals("3", cell.toString());
	}
}
