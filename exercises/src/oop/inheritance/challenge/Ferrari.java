package oop.inheritance.challenge;

public class Ferrari extends Car {

	Ferrari(int maxSpeed) {
		super(maxSpeed);		
	}

	void accelerate() {
		super.accelerate();
		super.accelerate();
		super.accelerate();
	}
	
	void brake() {
		super.brake();
		super.brake();
		super.brake();
	}
}
