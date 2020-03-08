package arrays;

import java.util.Arrays;

public class ForEach {
	
	public static void main(String[] args) {
		
		double[] scores = new double[3];
		
		System.out.println(Arrays.toString(scores));
		
		scores[0] = 7.9;
		scores[1] = 5;
		scores[2] = 10;
	
		System.out.println(Arrays.toString(scores));
		
		for(double score : scores) {
			System.out.println(score);
		}
	}
}
