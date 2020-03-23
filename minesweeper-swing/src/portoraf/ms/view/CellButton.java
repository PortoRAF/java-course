package portoraf.ms.view;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import portoraf.ms.model.Cell;
import portoraf.ms.model.CellEvent;
import portoraf.ms.model.CellObserver;

@SuppressWarnings("serial")
public class CellButton extends JButton implements CellObserver, MouseListener {
	
	private final Color BG_STD = new Color(184, 184, 184);
	private final Color BG_FLAGGED = new Color(8, 179, 247);
	private final Color BG_EXPLODED = new Color(189, 66, 68);
	private final Color GREEN_TEXT = new Color(0, 100, 0);
	
	private Cell cell;

	public CellButton(Cell cell) {
		this.cell = cell;

		setBackground(BG_STD);
		setBorder(BorderFactory.createBevelBorder(0));
		
		addMouseListener(this);
		cell.registerObserver(this);
	}

	@Override
	public void eventOcurred(Cell cell, CellEvent event) {
		switch (event) {
		case OPEN:
			applyStyleOpen();
			break;
		case FLAG:
			applyStyleFlag();
			break;
		case EXPLODE:
			applyStyleExplode();
			break;
		default:
			applyStyleStandard();
		}
	}

	private void applyStyleStandard() {
		setBorder(BorderFactory.createBevelBorder(0));
		setBackground(BG_STD);
		setText("");
	}

	private void applyStyleExplode() {
		setBackground(BG_EXPLODED);
		setForeground(Color.WHITE);
		setText("X");
	}

	private void applyStyleFlag() {
		setBackground(BG_FLAGGED);
		setForeground(Color.BLACK);
		setText("F");
	}

	private void applyStyleOpen() {
		
		setBorder(BorderFactory.createLineBorder(Color.GRAY));
		
		if (cell.isMined()) {
			setBackground(BG_EXPLODED);
			return;
		}
		
		setBackground(BG_STD);
		
		switch((int) cell.minesInVicinity()) {
		case 1:
			setForeground(GREEN_TEXT);
			break;
		case 2:
			setForeground(Color.BLUE);
			break;
		case 3:
			setForeground(Color.YELLOW);
			break;
		case 4:			
		case 5:			
		case 6:
			setForeground(Color.YELLOW);
			break;
		default:
			setForeground(Color.PINK);
		}
		
		setText(!cell.safeNeighbor() ? cell.minesInVicinity() + "" : "");
	}

	public void mousePressed(MouseEvent e) {
		if (e.getButton() == 1) {
			cell.open();
		}
		else {
			cell.toggleFlagged();
		}
	}
	
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e ) {}	
	public void mouseReleased(MouseEvent e) {}

}
