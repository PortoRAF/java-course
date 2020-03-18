package oop.inheritance.challenge;

public class CarTest {

	public static void main(String[] args) {
		
		Ferrari ferrari = new Ferrari(300);
		Car toyota = new Toyota();
		
		ferrari.speed = 50;
		toyota.speed = 50;
		
		System.out.println("Ferrari speed: " + ferrari.speed);
		ferrari.accelerate();
		System.out.println("Ferrari speed: " + ferrari.speed);
		ferrari.engageTurbo();
		ferrari.accelerate();
		System.out.println("Ferrari speed: " + ferrari.speed);
		ferrari.turnAirConditioningOn();
		ferrari.accelerate();
		System.out.println("Ferrari speed: " + ferrari.speed);
		ferrari.disengageTurbo();
		ferrari.accelerate();
		System.out.println("Ferrari speed: " + ferrari.speed);

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
