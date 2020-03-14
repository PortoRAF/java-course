package oop.composition.challenge;

import java.util.ArrayList;
import java.util.List;

public class Order {
	
	List<Item> items;
	
	Order () {
		this.items = new ArrayList<>();
	}
	
	void addItemToOrder (int quantity, Product product) {
		this.items.add(new Item(quantity, product));
	}
	
	double getOrderTotalPrice () {
		double sum = 0;
		
		for (Item orderItem : items) {
			sum += orderItem.quantity * orderItem.product.price;
		}
		
		return sum;
	}
}
