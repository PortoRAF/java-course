package oop.inheritance.challenge;

public class Car {

	final int MAX_SPEED;
	int speed;
	private int delta = 5;
	
	Car(int maxSpeed) {
		MAX_SPEED = maxSpeed;
	}
	
	void accelerate() {
		if (speed <= MAX_SPEED - getDelta()) {
			speed += getDelta();
		} else {
			speed = MAX_SPEED;
		}
	}
	
	void brake() {
		if (speed >= getDelta()) {
			speed -= getDelta();
		} else {
			speed = 0;
		}
	}

	public int getDelta() {
		return delta;
	}

	public void setDelta(int delta) {
		this.delta = delta;
	}
	
	
}
