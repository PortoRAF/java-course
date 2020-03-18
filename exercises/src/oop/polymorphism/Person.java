package oop.polymorphism;

public class Person {

	private double weight;
	
	public Person(double weight) {
		setWeight(weight);
	}

	public void eat(Food food) {
		setWeight(this.weight + food.getWeight());
	}
	
	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}	
}
