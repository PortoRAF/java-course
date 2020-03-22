package standards.observer;

public class Observer implements IArriveObserver {

	@Override
	public void arrived(EventArrive event) {
		System.out.println("Event detected");
		System.out.println("Take actions related to event");
	}	
}
