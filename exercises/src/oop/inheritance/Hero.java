package oop.inheritance;

public class Hero extends Player {

	Hero(int x, int y) {
		super(x, y);
	}
	
	boolean attack(Player opponent) {
		boolean attack1 = super.attack(opponent);
		boolean attack2 = super.attack(opponent);
		return attack1 || attack2;
	}
	
//	boolean attack(Player opponent) {
//		int deltaX = Math.abs(x - opponent.x);
//		int deltaY = Math.abs(y - opponent.y);
//		
//		if (deltaX == 0 && deltaY == 1) {
//			opponent.hitPoints -= 20;
//		} else if (deltaX == 1 && deltaY == 0) {
//			opponent.hitPoints -= 20;
//		} else {
//			return false;
//		}
//		return true;
//	}
}
