package oop.composition.challenge;

public class ClientTest {

	public static void main(String[] args) {
		Product p1 = new Product("chocolate", 5.90);
		Product p2 = new Product("coffee", 8.70);
		Product p3 = new Product("milk", 3.20);
	
		Order order1 = new Order();		
		order1.addItemToOrder(1, p1);
		order1.addItemToOrder(2, p3);		
		System.out.println(order1.getOrderTotalPrice());
		
		Order order2 = new Order();
		order2.addItemToOrder(2, p2);
		System.out.println(order2.getOrderTotalPrice());
		
		Client client = new Client("John Smith");
		client.addOrder(order1);
		client.addOrder(order2);
		System.out.println(client.getTotalSpent());
	}
}
