package studentDatabaseApp;

import java.util.Scanner;

public class StudentDatabaseApp {

	public static void main(String[] args) {

		// ask how many students will be added to database
		System.out.print("Enter number of new students to enroll: ");
		Scanner scanner = new Scanner(System.in);
		int numOfStudents = Integer.parseInt(scanner.nextLine());
		Student[] students = new Student[numOfStudents];
		
		// create n number of students
		for (int n = 0; n < numOfStudents; n++) {
			students[n] = new Student(scanner);		
			students[n].enroll(scanner);
			students[n].payTuition(scanner);
		}		

		System.out.println();
		
		for (int n = 0; n < numOfStudents; n++) {
			students[n].showInfo();			
			System.out.println();
		}
		scanner.close();
	}	
}
