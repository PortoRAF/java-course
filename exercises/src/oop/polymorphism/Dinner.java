package oop.polymorphism;

public class Dinner {

	public static void main(String[] args) {
		
		Person guest = new Person(99.65);
		
		Rice ingredient1 = new Rice(0.2);
		Beans ingredient2 = new Beans(0.1);
//		Food ingredient3 = new Food(0.3);
		
		System.out.println(guest.getWeight());
		
		guest.eat(ingredient1);
		guest.eat(ingredient2);
		
		System.out.println(guest.getWeight());
		
		IceCream dessert = new IceCream(0.4);
		
		guest.eat(dessert);
		
		System.out.println(guest.getWeight());
	}
}
