package fundamentals;

public class Wrappers {
	
	public static void main(String[] args) {
		
		// Wrappers are objects from primitive types
		Byte b = 100;
		Short s = 1000;
		
		Integer i = 10000;
		Long l = 100000L;
		
		Float f = 123.10F;
		Double d = 123.56;
		
		Character c = '#';
		
		Boolean bo = Boolean.parseBoolean("true");
		
		System.out.println(b.byteValue());
		System.out.println(s.toString());
		System.out.println(i * 3);
		System.out.println(l / 3);
		System.out.println(bo);
		System.out.println(bo.toString().toUpperCase());
	}
}
