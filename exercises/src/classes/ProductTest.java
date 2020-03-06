package classes;

public class ProductTest {

	public static void main(String[] args) {
		
		Product p1 = new Product("Notebook", 4356.89);
//		p1.name = "Notebook";
//		p1.price = 4356.89;
//		p1.discount = 0.25;
		
		var p2 = new Product();
		p2.name = "Black Pen";
		p2.price = 12.56;

		Product.discount = 0.50;
		
		System.out.println(p1.name);
		System.out.println(p2.name);
		
		double finalPrice1 = p1.priceWithDiscount();
		double finalPrice2 = p2.priceWithDiscount(0.1);
		double cartAverage = (finalPrice1 + finalPrice2) / 2;
		
		System.out.printf("Cart average: $%.2f\n", cartAverage);
	}
}
