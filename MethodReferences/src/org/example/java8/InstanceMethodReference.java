package org.example.java8;

import java.util.ArrayList;
import java.util.List;

import org.example.java8.model.Person;

public class InstanceMethodReference {

	public static void main(String args[]){
		InstanceMethodReference mainClass = new InstanceMethodReference();
		mainClass.sortData();
	}

	public void sortData() {

		List<Person> people = new ArrayList<>();

		people.add(new Person("Joe", 48));
		people.add(new Person("Mary", 30));
		people.add(new Person("Mike", 73));
		
		people.sort(this::compareAges);
		people.forEach((p)->System.out.println(p));

	}
	public int compareAges(Person p1, Person p2){
		Integer age1=p1.getAge();
		return age1.compareTo(p2.getAge());
	}
}
