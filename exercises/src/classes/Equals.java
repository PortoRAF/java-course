package classes;

public class Equals {
	
	public static void main(String[] args) {

		User u1 = new User();
		u1.name = "John Smith";
		u1.email = "johnsmith@email.com";
		
		User u2 = new User();
		u2.name = "John Smith";
		u2.email = "johnsmith@email.com";
		
		System.out.println(u1 == u2);
		System.out.println(u1.equals(u2));
		System.out.println(u2.equals(u1));
		
		System.out.println(u2.equals(new Date()));
	}
}
