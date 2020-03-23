package portoraf.ms.view;

import portoraf.ms.model.Field;

public class Temp {

	public static void main(String[] args) {
		
		Field field = new Field(3, 3, 9);

		field.registerObserver(e -> {
			if (e.hasWon()) {
				System.out.println("You won!!!");
			}
			else {
				System.out.println("You lose");
			}
		});
		
		field.flag(0, 0);
		field.flag(0, 1);
		field.flag(0, 2);
		field.flag(1, 0);
		field.flag(1, 1);
		field.flag(1, 2);
		field.flag(2, 0);
		field.flag(2, 1);
		field.open(2, 2);
//		field.flag(2, 2);
	}
}
