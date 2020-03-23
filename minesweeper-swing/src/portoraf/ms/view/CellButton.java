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
		
	}

	private void applyStyleExplode() {
		
	}

	private void applyStyleFlag() {
		
	}

	private void applyStyleOpen() {
		
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
