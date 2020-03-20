package bankAccountApp;

public class BankAccountApp {

	public static void main(String[] args) {
		
		// Read CSV file the create new accounts
		
		
		Checking checking = new Checking("John Smith", "123456789", 1500);
		Savings savings = new Savings("Eric Johnson", "987654321", 2500);
		
		checking.showInfo();
		savings.showInfo();

		savings.compound();

	}
}
