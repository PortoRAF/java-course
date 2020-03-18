package oop.encapsulation;

public class PersonTest {

	public static void main(String[] args) {
		Person p1 = new Person("John", "Smith", 130);
		
		p1.setAge(30);
		
		System.out.println(p1.getAge());
		System.out.println(p1.toString());
		System.out.println(p1.getFullName());
	}
}
