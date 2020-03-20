package bankAccountApp;

public abstract class Account implements IBaseRate {
	// List common properties for savings and checking accounts
	private String name;
	private String ssn;
	private double balance;
	
	protected String accountNumber;
	protected double interestRate;
	
	private static int index = 10000;
	
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
	
	public void compound() {
		double accruedInterest = balance * (interestRate/100);
		balance += accruedInterest;
		System.out.println("Accrued Interest: $" + accruedInterest);
		printBalance();
	}
	
	public void deposit(double amount) {
		balance += amount;
		System.out.println("Depositing $" + amount);
		printBalance();
	}
	
	public void withdraw(double amount) {
		balance -= amount;
		System.out.println("Withdrawing $" + amount);
		printBalance();
	}
	
	public void transfer(Account toAccount, double amount) {
		balance -= amount;
		toAccount.balance += amount;
		System.out.println("Transfering $" + amount + " to " + toAccount.name);
		printBalance();
	}
	
	public void printBalance() {
		System.out.println("Your balance is now: $" + balance);
	}
	
	public void showInfo() {
		System.out.println(
				"NAME: " + name +
				"\nACCOUNT NUMBER: " + accountNumber +
				"\nBALANCE: $" + balance +
				"\n INTEREST RATE: " + interestRate + "%"
				);
	}
}
