package classes;

public class Product {

	String name;
	double price;
	double discount;
	
	double priceWithDiscount() {		
		return price * (1 - discount);
	}
}
