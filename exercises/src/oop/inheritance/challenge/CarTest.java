package oop.inheritance.challenge;

public class CarTest {

	public static void main(String[] args) {
		
		Car ferrari = new Ferrari(300);
		Car toyota = new Toyota();
		
		ferrari.speed = 260;
		toyota.speed = 50;
		
		ferrari.accelerate();
		ferrari.accelerate();
		ferrari.accelerate();

		toyota.accelerate();
		toyota.accelerate();
		toyota.accelerate();
		
		System.out.println("Ferrari speed: " + ferrari.speed);
		System.out.println("Toyota speed: " + toyota.speed);
		
		ferrari.brake();
		ferrari.brake();
		ferrari.brake();

		toyota.brake();
		toyota.brake();
		toyota.brake();

		System.out.println("Ferrari speed: " + ferrari.speed);
		System.out.println("Toyota speed: " + toyota.speed);
	}
}
