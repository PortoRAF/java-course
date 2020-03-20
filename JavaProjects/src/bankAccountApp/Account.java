package bankAccountApp;

public abstract class Account implements IBaseRate {
	// List common properties for savings and checking accounts
	String name;
	String ssn;
	String accountNumber;
	double balance;
	double interestRate;
	
	static int index = 10000;
	
	// Constructor to set base properties and initialize the account
	public Account(String name, String ssn, double initialDeposit) {
		this.name = name;
		this.ssn = ssn;
		this.balance = initialDeposit;
	
		index++;
		this.accountNumber = setAccountNumber();
		setRate();
	}

	private String setAccountNumber() {
		String lastTwoDigitsOfSSN = ssn.substring(ssn.length()-2, ssn.length());
		int uniqueID = index;
		int randomNumber = (int) (Math.random() * Math.pow(10, 3));
		return lastTwoDigitsOfSSN + uniqueID + randomNumber;
	}
	
	// List common methods
	public abstract void setRate();
	
	public void showInfo() {
		System.out.println(
				"NAME: " + name +
				"\nACCOUNT NUMBER: " + accountNumber +
				"\nBALANCE: $" + balance +
				"\n INTEREST RATE: " + interestRate + "%"
				);
	}
}
