package oop.inheritance.challenge;

public class Ferrari extends Car implements Sports, Luxury {

	private boolean engageTurbo = false;
	private boolean turnAirConditioningOn = false;
	
	Ferrari(int maxSpeed) {
		super(maxSpeed);
		setDelta(15);
	}

	void accelerate() {
		super.accelerate();
	}
	
	void brake() {
		super.brake();
	}

	@Override
	public void engageTurbo() {
		engageTurbo = true;		
	}

	@Override
	public void disengageTurbo() {
		engageTurbo = false;
	}

	@Override
	public void turnAirConditioningOn() {
		turnAirConditioningOn = true;		
	}

	@Override
	public void turnAirConditioningOff() {
		turnAirConditioningOn = false;		
	}
	
	public int getDelta() {
		if (engageTurbo && !turnAirConditioningOn) {
			return 35;			
		} else if (engageTurbo && turnAirConditioningOn) {
			return 30;
		} else if (!engageTurbo && !turnAirConditioningOn) {
			return 20;
		} else {
			return 15;
		}
	}
}
