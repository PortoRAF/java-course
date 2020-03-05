package fundamentals;

import java.util.Scanner;

public class Console {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Type in your name: ");
		String name = input.nextLine();
		
		System.out.print("Type in your surname: ");
		String surname = input.nextLine();
		
		System.out.print("Type in your age: ");
		int age = input.nextInt();
		
		System.out.printf("%s %s is %d years old.\n", name, surname, age);
		
		input.close();
	}
}
