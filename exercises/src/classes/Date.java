package classes;

public class Date {
	
	int day;
	int month;
	int year;
	
	Date() {
		day = 1;
		month = 1;
		year = 1970;
	}
	
	Date(int dayInit, int monthInit, int yearInit) {
		day = dayInit;
		month = monthInit;
		year = yearInit;
	}
	
	String getFormattedDate() {
		return String.format("%02d/%02d/%02d", day, month, year);
	}
}
