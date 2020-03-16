package oop.inheritance.challenge;

public class Car {

	final int MAX_SPEED;
	int speed;
	
	Car(int maxSpeed) {
		MAX_SPEED = maxSpeed;
	}
	
	void accelerate() {
		if (speed <= MAX_SPEED - 5) {
			speed += 5;
		} else {
			speed = MAX_SPEED;
		}
	}
	
	void brake() {
		if (speed >= 5) {
			speed -= 5;
		} else {
			speed = 0;
		}
	}
}
