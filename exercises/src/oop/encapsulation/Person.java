package oop.encapsulation;

public class Person {
	
	private String name;
	private String surname;
	private int age;
	
	Person (String name, String surname, int age) {
		setName(name);
		setSurname(surname);
		setAge(age);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
		
	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getFullName() {
		return getName() + " " + getSurname();
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int newAge) {
		newAge =Math.abs(newAge);
		if (newAge >= 0 && newAge <= 120) {
			this.age = newAge;			
		}
	}
	
	public String toString() {
		return "Hi. My name is " + getName() + " and I'm " + getAge() + " years old."; 
	}
}
