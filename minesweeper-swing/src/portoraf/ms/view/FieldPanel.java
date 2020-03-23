package portoraf.ms.view;

import java.awt.GridLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import portoraf.ms.model.Field;

@SuppressWarnings("serial")
public class FieldPanel extends JPanel {

	public FieldPanel(Field field) {
		
		setLayout(new GridLayout(field.getNumOfRows(), field.getNumOfCols()));
		
		field.forEachCell(c -> add(new CellButton(c)));
		
		field.registerObserver(e -> {			
			SwingUtilities.invokeLater(() -> {
				if (e.hasWon()) {
					JOptionPane.showMessageDialog(this, "You won! :)");
				}
				else {
					JOptionPane.showMessageDialog(this, "You lose. :(");
				}
				
				field.restart();
			});
		});
	}
}
