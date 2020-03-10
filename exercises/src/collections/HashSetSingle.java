package collections;

import java.util.HashSet;
import java.util.Set;

public class HashSetSingle {

	public static void main(String[] args) {
		
		Set<String> approvedList = new HashSet<String>();
//		Set<String> approvedList = new TreeSet<String>();
		
		approvedList.add("John");
		approvedList.add("Anna");
		approvedList.add("Peter");
		approvedList.add("Luca");
		
		for(String name : approvedList) {
			System.out.println(name);
		}
		
		Set<Integer> nums = new HashSet<>();
		
		nums.add(1);
		nums.add(2);
		nums.add(120);
		nums.add(6);
		
		System.out.println(nums);
		for (Integer num : nums) {
			System.out.println(num);
		}
	}
}
