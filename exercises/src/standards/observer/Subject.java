package standards.observer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Subject {

	private List<IArriveObserver> observers = new ArrayList<>();
	
	public void registerObserver(IArriveObserver observer) {
		observers.add(observer);
	}
	
	public void monitor() {
		Scanner input = new Scanner(System.in);
		
		String value = "";
		
		while (!"exit".equalsIgnoreCase(value)) {
			
			System.out.print("Event happened? ");
			
			value = input.nextLine();
			
			if ("yes".equalsIgnoreCase(value)) {
				System.out.println("Report to observer");

				// Create event
				EventArrive event = new EventArrive(new Date());
				
				// Notify observers
				observers.stream()
					.forEach(o -> o.arrived(event));
				
				value = "exit";
			}
			else {
				System.out.println("Nothing to report");
			}
		}
		
		input.close();
	}
	
}
