package swing;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Observer {

	public static void main(String[] args) {
		
		JFrame window = new JFrame("Observer");
		
		window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		window.setSize(640, 480);
		window.setLayout(new FlowLayout());
		window.setLocationRelativeTo(null);
		
		JButton button = new JButton("Click");
		window.add(button);
		
		button.addActionListener(e -> {
			System.out.println("Event happened");
		});
		
		window.setVisible(true);
	}
}
