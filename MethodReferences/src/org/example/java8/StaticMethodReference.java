package org.example.java8;

import java.util.ArrayList;
import java.util.List;

import org.example.java8.model.Person;

public class StaticMethodReference {
	public static void main(String args[]){
		 
		List<Person> people = new ArrayList<>();
		 
		people.add(new Person("Joe", 48));
		people.add(new Person("Mary", 30));
		people.add(new Person("Lucky", 7));
		people.add(new Person("Mike", 73));
 
		people.sort(Person::compareAges);
		people.forEach(p -> System.out.println(p));
	}
	
}
