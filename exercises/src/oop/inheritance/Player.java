package oop.inheritance;

public class Player {

	int hitPoints = 100;
	int x;
	int y;
	
	Player (int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	boolean attack(Player opponent) {
		int deltaX = Math.abs(x - opponent.x);
		int deltaY = Math.abs(y - opponent.y);
		
		if (deltaX == 0 && deltaY == 1) {
			opponent.hitPoints -= 10;
		} else if (deltaX == 1 && deltaY == 0) {
			opponent.hitPoints -= 10;
		} else {
			return false;
		}
		return true;
	}
	
	boolean move(Direction direction) {
		switch(direction) {
		case NORTH:
			y--;
			break;
		case EAST:
			x++;
			break;
		case SOUTH:
			y++;
			break;
		case WEST:
			x--;
			break;			
		}
				
		return true;
	}
}
