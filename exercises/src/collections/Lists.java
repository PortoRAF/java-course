package collections;

import java.util.ArrayList;

public class Lists {

	public static void main(String[] args) {
		
		ArrayList<User> list = new ArrayList<User>();
		
		User u1 = new User("Anna");		
		list.add(u1);
		
		list.add(new User("Charles"));
		list.add(new User("Lya"));
		list.add(new User("Bia"));
		list.add(new User("Manu"));
		
		// Method toString() is called implicitly
		System.out.println(list.get(3));
		
		// remove(id) method returns the stored value
		System.out.println("Removed: " + list.remove(1));
		// remove(obj) returns true or false
		System.out.println("Removed? " + list.remove(new User("Manu")));
		
		// method contains uses hashcode to find elements
		System.out.println("contains? " + list.contains(new User("Bia")));
		
		for(User u : list) {
			System.out.println(u.name);
		}
	}
}
