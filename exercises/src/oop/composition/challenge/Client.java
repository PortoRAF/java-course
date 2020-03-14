package oop.composition.challenge;

import java.util.ArrayList;
import java.util.List;

public class Client {

	String name;
	List<Order> orders;
	
	Client (String name) {
		this.name = name;
		this.orders = new ArrayList<>();
	}
	
	void addOrder (Order order) {
		orders.add(order);
	}
	
	double getTotalSpent () {
		double sum = 0;
		for (Order clientOrder : this.orders) {
			sum += clientOrder.getOrderTotalPrice();
		}
		return sum;
	}
}
