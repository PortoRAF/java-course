package bankAccountApp;

import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {

	public static void main(String[] args) {
		List<Account> accounts = new LinkedList<>();
		
		// Read CSV file then create new accounts
		String file = "/home/renato/java-projects/JavaProjects/src/bankAccountApp/NewBankAccounts.csv";
		List<String[]> newAccountHolders = utilities.CSV.read(file);
		
		for (String[] accountHolder : newAccountHolders) {
			String name = accountHolder[0];
			String ssn = accountHolder[1];
			String accountType = accountHolder[2];
			double initialDeposit = Double.parseDouble(accountHolder[3]);
			if (accountType.equalsIgnoreCase("Savings")) {
				accounts.add(new Savings(name, ssn, initialDeposit));				
			}
			else if (accountType.equalsIgnoreCase("Checking")) {
				accounts.add(new Checking(name, ssn, initialDeposit));
			}
			else {
				System.out.println("ERROR READING ACCOUNT TYPE");
			}
		}
		
		for (Account acc : accounts) {
			acc.showInfo();
		}
		
//		Checking checking = new Checking("John Smith", "123456789", 1500);
//		Savings savings = new Savings("Eric Johnson", "987654321", 2500);
//		
//		checking.showInfo();
//		savings.showInfo();
//
//		savings.compound();

	}
}
