package oop.composition;

import java.util.ArrayList;
import java.util.List;

public class Student {
	
	String name;
	List<Course> courses;

	Student (String name) {
		this.name = name;
		courses = new ArrayList<>();
	}
	
	void addCourse (Course course) {
		this.courses.add(course);
		course.students.add(this);
	}
	
	List<String> getCourses () {
		List<String> coursesEnrolled = new ArrayList<>();
		for (Course course : courses) {
			coursesEnrolled.add(course.name);
		}
		return coursesEnrolled;
	}
}
