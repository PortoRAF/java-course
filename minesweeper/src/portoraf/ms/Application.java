package portoraf.ms;

import portoraf.ms.model.Field;
import portoraf.ms.view.FieldConsole;

public class Application {

	public static void main(String[] args) {
		
		Field field = new Field(6, 6, 6);		
		new FieldConsole(field);
		
	}
}
