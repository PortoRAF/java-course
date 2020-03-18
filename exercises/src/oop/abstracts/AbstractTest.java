package oop.abstracts;

public class AbstractTest {

	public static void main(String[] args) {
		Mamal a = new Dog();
		System.out.println(a.breath());
		System.out.println(a.suckle());
		System.out.println(a.move());
	}
}
