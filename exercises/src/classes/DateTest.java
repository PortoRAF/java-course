package classes;

public class DateTest {
	
	public static void main(String[] args) {

		Date d1 = new Date(1, 1, 2000);
//		d1.day 	 = 1;
//		d1.month = 1;
//		d1.year  = 2000;
		
		Date d2 = new Date();
		d2.day   = 10;
		d2.month = 10;
		d2.year  = 2010;
		Date d3 = new Date();
		d3.day   = 31;
		d3.month = 07;
		d3.year  = 2020;
		
		Date d4 = new Date();

		String d1Formatted = d1.getFormattedDate();
		
		System.out.println(d1Formatted);
		System.out.printf("%02d/%02d/%02d\n", d2.day, d2.month, d2.year);
		System.out.println(d3.getFormattedDate());
		System.out.println(d4.getFormattedDate());
	}
}