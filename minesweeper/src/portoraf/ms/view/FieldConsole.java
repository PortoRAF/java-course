package portoraf.ms.view;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

import portoraf.ms.exception.ExplosionException;
import portoraf.ms.exception.LeaveException;
import portoraf.ms.model.Field;

public class FieldConsole {
	
	private Field field;
	private Scanner input = new Scanner(System.in);

	public FieldConsole(Field field) {
		this.field = field;
		
		executeGame();
	}
	
	private void executeGame() {
		try {
			boolean playAgain = true;
			
			while(playAgain) {
				gameLoop();
				System.out.println("Another match? (Y/n) ");
				String answer = input.nextLine();
				
				if ("n".equalsIgnoreCase(answer)) {
					playAgain = false;
				}
				else {
					field.restart();
				}
			}			
		}
		catch (LeaveException e) {
			System.out.println("Bye!!");
		}
		finally {
			input.close();
		}
	}

	private void gameLoop() {
		try {
			
			while (!field.goalMet()) {
				System.out.println(field);				
				
				String inserted = getInsertedValue("Type [x, y] or (Q)uit: ");								
				
				Iterator<Integer> xy = Arrays.stream(inserted.split(","))
						.map(e -> Integer.parseInt(e.trim()))
						.iterator();
				
				inserted = getInsertedValue("1 - Open | 2 - Flag: ");
				
				if ("1".equals(inserted)) {
					field.open(xy.next(), xy.next());
				}
				else if ("2".equals(inserted)) {
					field.flag(xy.next(), xy.next());
				}
			}
			System.out.println(field);
			System.out.println("You won!!!");
		}
		catch (ExplosionException e) {
			System.out.println(field);
			System.out.println("You lose!");
		}
	}

	private String getInsertedValue(String text) {
		System.out.print(text);
		String inserted = input.nextLine();
		
		if ("q".equalsIgnoreCase(inserted)) {
			throw new LeaveException();
		}		
		return inserted;
	}
}
