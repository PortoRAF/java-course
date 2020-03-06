package classes;

public class Date {
	
	int day;
	int month;
	int year;
	
	String getFormattedDate() {
		return String.format("%02d/%02d/%02d", day, month, year);
	}
}
