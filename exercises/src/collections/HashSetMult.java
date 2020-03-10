package collections;

import java.util.HashSet;
import java.util.Set;

public class HashSetMult {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		
		HashSet set = new HashSet();
		
		set.add(1.2);
		set.add(true);
		set.add("Test");
		set.add(1);
		set.add('x');
		
		System.out.println(set);
		System.out.println("Size of set: " + set.size());
		
		set.add("Test");
		set.add('x');
		
		System.out.println("Size of set: " + set.size());
		
		set.remove("test");
		set.remove("Test");
		set.remove('x');
		
		System.out.println("Size of set: " + set.size());
		
		System.out.println(set.contains('x'));
		System.out.println(set.contains(1));
		System.out.println(set.contains(true));
		
		Set nums = new HashSet();
		
		nums.add(1);
		nums.add(2);
		nums.add(3);
		
		System.out.println(nums);
		System.out.println(set);
		
		//set.addAll(nums);
		set.retainAll(nums);
		System.out.println(set);
		
		set.clear();
		System.out.println(set);
	}
}
