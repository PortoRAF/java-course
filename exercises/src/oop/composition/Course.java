package oop.composition;

import java.util.ArrayList;
import java.util.List;

public class Course {

	String name;
	List<Student> students;
	
	Course (String name) {
		this.name = name;
		this.students = new ArrayList<>();
	}
	
	void addStudent (Student student) {
		this.students.add(student);
		student.courses.add(this);
	}
	
	List<String> getStudents () {
		List<String> studentsInCourse = new ArrayList<>();		
		for (Student student : students) {
			studentsInCourse.add(student.name);
		}
		return studentsInCourse;
	}
}
