package portoraf.ms.model;

public class EventResult {

	private final boolean won;
	
	public EventResult(boolean won) {
		this.won = won;
	}
	
	public boolean hasWon() {
		return won;
	}
}
