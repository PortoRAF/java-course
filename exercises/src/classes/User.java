package classes;

public class User {

	String name;
	String email;
	
	public boolean equals(Object obj) {
		
		if(obj instanceof User) {
			
			User other = (User) obj;
			
			boolean equalsName = other.name.contentEquals(this.name);
			boolean equalsEmail = other.email.equals(this.email);
			
			return equalsName && equalsEmail;
		} else {
			return false;
		}
	}
}
