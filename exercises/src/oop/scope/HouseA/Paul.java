package oop.scope.HouseA;

public class Paul {

	Anna wife = new Anna();
	
	void AccessTest() {
		//System.out.println(wife.secret);
		System.out.println(wife.doInsideHouse);
		System.out.println(wife.speakingManner);
		System.out.println(wife.everybodyKnows);
	}
}
