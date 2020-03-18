package oop.scope.HouseB;

import oop.scope.HouseA.Anna;

public class Julia {

	Anna inLaw = new Anna();
	
	void AccessTest() {
		//System.out.println(inLaw.secret);
		//System.out.println(inLaw.doInsideHouse);
		//System.out.println(inLaw.speakingManner);
		System.out.println(inLaw.everybodyKnows);		
	}	
}
