package bankAccountApp;

public class Checking extends Account {
	// List properties specific to checking accounts
	long debitCardNumber;
	int debitCardPin;
	
	// Constructor to initialize settings for checking account properties
	public Checking(String name, String ssn, double initialDeposit) {
		super(name, ssn, initialDeposit);
		accountNumber = "2" + accountNumber;
		setDebitCard();
	}	
	
	// List methods specific to checking accounts	
	public void setRate() {
		interestRate = getBaseRate() * 0.15;		
	}
	
	private void setDebitCard() {
		debitCardNumber = (long) (Math.random() * Math.pow(10, 12));
		debitCardPin = (int) (Math.random() * Math.pow(10, 4));
	}
	
	public void showInfo() {
		System.out.println("ACCOUNT TYPE: Checking\n****************");
		super.showInfo();
		System.out.println("Your checking account features:" +
				"\n Debit card number: " + debitCardNumber +
				"\n Debit card PIN: " + debitCardPin
				);
	}
}
