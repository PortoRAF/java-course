package portoraf.ms.view;

import java.awt.GridLayout;

import javax.swing.JPanel;

import portoraf.ms.model.Field;

@SuppressWarnings("serial")
public class FieldPanel extends JPanel {

	public FieldPanel(Field field) {
		
		setLayout(new GridLayout(field.getNumOfRows(), field.getNumOfCols()));
		
		field.forEachCell(c -> add(new CellButton(c)));
		
		field.registerObserver(e -> {
			// TODO Show result to user
		});
	}
}
