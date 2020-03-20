package emailApp;

import java.util.Scanner;

public class Email {

	final int DEFAULT_PASSWORD_LENGTH = 8;
	final int DEFAULT_MAILBOX_CAPACITY = 500;
	
	private String firstName;
	private String lastName;
	private String password;	
	private String department;
	private String email;
	private int mailboxCapacity;
	private String alternateEmail;
	private String companySuffix = "company.com";
	
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = setDepartment();
		this.mailboxCapacity = DEFAULT_MAILBOX_CAPACITY;
		this.password = randomPassword(DEFAULT_PASSWORD_LENGTH);
		this.email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + this.department + "." + companySuffix;
		
		System.out.println(showInfo());
		System.out.println("Your password is: " + this.password);
	}	

	private String setDepartment() {
		System.out.print("DEPARTMENTS:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department: ");
		Scanner input = new Scanner(System.in);
		int depChoice = input.nextInt();
		input.close();
		
		switch (depChoice) {
		case 0: return "";
		case 1: return "sales";
		case 2: return "dev";
		case 3: return "acct";
		default: return "";
		}
	}
	
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%";
		char[] password = new char[length];
		for (int i = 0; i < length; i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
	}
	
	public String showInfo() {
		return "DISPLAY NAME: " + this.firstName + "." + this.lastName +
				"\nCOMPANY EMAIL: " + this.email +
				"\nMAILBOX CAPACITY: " + this.mailboxCapacity;
	}
	
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getMailboxCapacity() {
		return mailboxCapacity;
	}
	
	public String getAlternateEmail() {
		return alternateEmail;
	}
	
	public String getPassword() {
		return password;
	}
}
