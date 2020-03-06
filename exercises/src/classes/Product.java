package classes;

public class Product {

	String name;
	double price;
	static double discount = 0.25;
	
	Product() {
		
	}
	
//	Product(String nameInit, double priceInit, double discountInit) {
//		name = nameInit;
//		price = priceInit;
//		discount = discountInit;
//	}

	Product(String nameInit, double priceInit) {
		name = nameInit;
		price = priceInit;
	}
	
	double priceWithDiscount() {		
		return price * (1 - discount);
	}

	double priceWithDiscount(double managerDiscount) {		
		return price * (1 - discount + managerDiscount);
	}
}
