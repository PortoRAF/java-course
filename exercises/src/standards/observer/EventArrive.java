package standards.observer;

import java.util.Date;

public class EventArrive {

	private final Date moment;
	
	public EventArrive(Date moment) {
		this.moment = moment;
	}
	
	public Date getMoment() {
		return moment;
	}
}
