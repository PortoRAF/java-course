package studentDatabaseApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student {

	private String firstName;
	private String lastName;
	private int year;
	private String studentID;
	private List<Course> courses = new ArrayList<>();
	private int tuitionBalance;
	
	private static int id = 1000;
	private static int costOfCourse = 600;
	
	public Student() {
		// ask for student name and year
		Scanner input = new Scanner(System.in);

		System.out.print("Enter student's first name: ");
		this.firstName = input.nextLine();
		
		System.out.print("Enter student's last name: ");
		this.lastName = input.nextLine();
		
		System.out.print("1 - Freshman\n2 - Sophmore\n3 - Junior\n4 - Senior\nEnter student class level: ");
		this.year = input.nextInt();
		
		setStudentID();		
	}

	private void setStudentID() {
		// grade level + ID
		id++;
		this.studentID = year + "" + id;
	}
	
	public void enroll() {
		Scanner input = new Scanner(System.in);
		do {
			System.out.print("Enter course to enroll (Q to quit): ");
			String course = input.nextLine();
			if (!("Q".equalsIgnoreCase(course))) {
				courses.add(new Course(course, costOfCourse, this));
				System.out.println("Course added: " + course);
			} else {
				break;
			}
		} while (1 != 0);
		
		tuitionBalance = courses.size() * costOfCourse;
		System.out.println("ENROLLED IN: ");
		for (Course enrolledCourse : courses) {
			System.out.println(enrolledCourse.name);
		}
		System.out.println("TUITION BALANCE: " + tuitionBalance);
	}
	
	public void viewBalance() {
		System.out.println("Your balance is: $" + tuitionBalance);
	}
	
	public void payTuition() {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter your payment: $");
		int payment = input.nextInt();
		tuitionBalance -= payment;
		System.out.println("Thank you for your payment of $" + payment);
		viewBalance();
	}
	
	public void showInfo() {
		System.out.println("Name: " + firstName + " " + lastName);
		System.out.println("Grade level: " + year);
		System.out.println("Student's ID: " + studentID);
		System.out.println("Courses Enrolled:");
		for (Course course : courses) {
			System.out.println("    " + course.name);
		}
		System.out.println("Balance: $" + tuitionBalance);
	}
}
