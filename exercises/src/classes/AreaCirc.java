package classes;

public class AreaCirc {
	
	double radius;
	final static double PI = 3.14159;
	
	AreaCirc(double radiusInit) {
//		pi = 3.14;
		radius = radiusInit;		
	}
	
	double area() {
		return PI * Math.pow(radius, 2);
	}
	
	static double area(double radius) {
		return PI * Math.pow(radius, 2);
	}
}
