package bankAccountApp;

public interface IBaseRate {

	// Write method that returns the base rate
	default double getBaseRate() {
		return 2.5;
	}
}
