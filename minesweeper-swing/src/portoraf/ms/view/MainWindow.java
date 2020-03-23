package portoraf.ms.view;

import javax.swing.JFrame;

import portoraf.ms.model.Field;

@SuppressWarnings("serial")
public class MainWindow extends JFrame {

	public MainWindow() {
		
		Field field = new Field(16, 30, 50);
		
		add(new FieldPanel(field));		
		
		setTitle("Mine Sweeper");
		setSize(690, 438);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new MainWindow();
	}
}
