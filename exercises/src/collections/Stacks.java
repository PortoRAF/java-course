package collections;

import java.util.ArrayDeque;
import java.util.Deque;

public class Stacks {

	public static void main(String[] args) {
		
		Deque<String> books = new ArrayDeque<String>();
		
		books.add("The Little Prince");		
		books.push("Don Quixote");
		books.push("The Hobbit");
		
		System.out.println(books.peek());
		System.out.println(books.element());
		
		System.out.println(books.poll());
		System.out.println(books.poll());
		System.out.println(books.poll());
		System.out.println(books.poll());
		System.out.println(books.pop());
	}
}
