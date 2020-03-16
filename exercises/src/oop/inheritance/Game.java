package oop.inheritance;

public class Game {

	public static void main(String[] args) {
		
		Villain villain = new Villain();
		villain.x = 10;
		villain.y = 10;

		Hero hero = new Hero(10, 11);
//		hero.x = 10;
//		hero.y = 11;
		
		System.out.println("Villain: " + villain.hitPoints);
		System.out.println("Hero: " + hero.hitPoints);
		
		villain.attack(hero);
		hero.attack(villain);
		
		villain.attack(hero);
		hero.attack(villain);
		
		villain.attack(hero);
		hero.attack(villain);

		villain.move(Direction.NORTH);
		
		villain.attack(hero);
		hero.attack(villain);
		
		System.out.println("Villain: " + villain.hitPoints);
		System.out.println("Hero: " + hero.hitPoints);		
		
//		p1.move(Direction.NORTH);
//		p1.move(Direction.EAST);
//		p1.move(Direction.NORTH);
//		p1.move(Direction.EAST);				
//		System.out.println("Player position: [" + p1.x + ", " + p1.y + "]");
	}
}
