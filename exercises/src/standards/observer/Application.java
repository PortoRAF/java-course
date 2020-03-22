package standards.observer;

public class Application {

	public static void main(String[] args) {
		
		Observer observer = new Observer();
		Subject subject = new Subject();
		
		subject.registerObserver(observer);
		subject.registerObserver(e -> {		
			System.out.println("Event by lambda");
			System.out.println("Occured at " + e.getMoment());
		});			
				
		subject.monitor();
	}
}
