package collections;

import java.util.LinkedList;
import java.util.Queue;

public class Queues {

	public static void main(String[] args) {
		
		Queue<String> queue = new LinkedList<>();
		
		// 'offer' and 'add' insert values in queue
		// 'add' returns false when queue is full
		// 'offer' returns throws exception
		queue.add("Anna");
		queue.offer("Charles");
		queue.add("Daniel");
		queue.offer("Peter");
		
		System.out.println(queue.peek());	// returns false
		System.out.println(queue.peek());
		System.out.println(queue.element()); 	// throws exception
		System.out.println(queue.element());
		
		System.out.println(queue.poll());	// returns null if queue is empty	
		System.out.println(queue.remove());	// throws exception
	}
}
