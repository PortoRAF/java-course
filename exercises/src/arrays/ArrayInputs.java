package arrays;

import java.util.Scanner;

public class ArrayInputs {

	public static void main(String[] args) {
		
		int numOfStudents;
		int numOfScores;
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Number of students: ");
		numOfStudents = input.nextInt();
		
		System.out.print("Number of scores: ");
		numOfScores = input.nextInt();

		double[][] scores = new double[numOfStudents][numOfScores];

		for(int i = 0; i < scores.length; i++) {
			for(int j = 0; j < scores[i].length; j++) {
				System.out.printf("Student %d Score %d: ", i+1, j+1);
				scores[i][j] = input.nextDouble();
			}
		}

		double totalScores = 0;
		
		for(double[] students : scores) {
			for(double score : students) {
				totalScores += score;				
			}
		}
		
		double averageScore = totalScores / (numOfStudents * numOfScores);
		
		System.out.println("Average score: " + averageScore);
		
		input.close();
	}
}
