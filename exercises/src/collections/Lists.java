package collections;

import java.util.ArrayList;

public class Lists {

	public static void main(String[] args) {
		
		ArrayList<Users> list = new ArrayList<Users>();
		
		Users u1 = new Users("Anna");		
		list.add(u1);
		
		list.add(new Users("Charles"));
		list.add(new Users("Lya"));
		list.add(new Users("Bia"));
		list.add(new Users("Manu"));
		
		// Method toString() is called implicitly
		System.out.println(list.get(3));
		
		// remove(id) method returns the stored value
		System.out.println("Removed: " + list.remove(1));
		// remove(obj) returns true or false
		System.out.println("Removed? " + list.remove(new Users("Manu")));
		
		// method contains uses hashcode to find elements
		System.out.println("contains? " + list.contains(new Users("Bia")));
		
		for(Users u : list) {
			System.out.println(u.name);
		}
	}
}
