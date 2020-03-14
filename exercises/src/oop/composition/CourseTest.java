package oop.composition;

public class CourseTest {

	public static void main(String[] args) {
		
		Course c1 = new Course("Java");
		Course c2 = new Course("Data Structures");
		Course c3 = new Course("Algorithms");
		
		Student s1 = new Student("John");
		Student s2 = new Student("Mary");
		Student s3 = new Student("Paul");
		
		c1.addStudent(s1);
		c1.addStudent(s2);
		
		c2.addStudent(s2);
//		c2.addStudent(s3);
		
		s1.addCourse(c3);
		s1.addCourse(c2);
		
		for (Course course : s3.courses) {
			System.out.println(course.name);
		}
		System.out.println();
		
		for (Student student : c2.students) {
			System.out.println(student.name);
		}
		System.out.println();
		
		System.out.println(c2.getStudents());
		System.out.println(s3.getCourses());
	}
}
