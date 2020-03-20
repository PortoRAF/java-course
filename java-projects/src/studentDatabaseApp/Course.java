package studentDatabaseApp;

import java.util.List;
import java.util.ArrayList;

public class Course {
	
	public String name;
	public int tuition;
	public List<Student> students = new ArrayList<>();
	
	public Course(String name, int tuition, Student student) {
		this.name = name;
		this.tuition = tuition;
		this.students.add(student);
	}
	
	public void setTuition(int newTuition) {
		this.tuition = newTuition;
	}

	public String getName() {
		return name;
	}

	public int getTuition() {
		return tuition;
	}	
}
