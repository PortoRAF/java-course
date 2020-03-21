package portoraf.ms;

import portoraf.ms.model.Field;

public class Application {

	public static void main(String[] args) {
		
		Field field = new Field(6, 6, 6);
		
		field.flag(1, 1);
		field.flag(1, 2);
		field.open(3, 3);
		
		System.out.print(field);
	}
}
