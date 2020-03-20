package bankAccountApp;

public class Savings extends Account {
	// List properties specific to savings accounts
	int safetyDepositBoxID;
	int safetyDepositBoxKey;
	
	// Constructor to initialize settings for the savings properties
	public Savings(String name, String ssn, double initialDeposit) {
		super(name, ssn, initialDeposit);
		accountNumber = "1" + accountNumber;
		setSafetyDepositBox();
	}	
	
	// List methods specific to savings accounts
	public void setRate() {
		interestRate = getBaseRate() - 0.25;
	}

	private void setSafetyDepositBox() {
		safetyDepositBoxID = (int) (Math.random() * Math.pow(10, 3));
		safetyDepositBoxKey = (int) (Math.random() * Math.pow(10, 4));
	}
	
	public void showInfo() {
		System.out.println("ACCOUNT TYPE: Savings\n****************");
		super.showInfo();
		System.out.println("Your savings account features:" +
				"\n Safety Deposit Box ID: " + safetyDepositBoxID +
				"\n Safety Deposit Box Key: " + safetyDepositBoxKey
				);
	}
}
