package org.example.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.example.java8.model.Person;

public class PredicateLambda {
	
	public static void main(String args[]){

		List<Person> people = new ArrayList<>();

		people.add(new Person("John Doe", 300));
		people.add(new Person("Matusalem", 10000));
		people.add(new Person("Joe", 48));
		people.add(new Person("Mary", 30));
		people.add(new Person("Mike", 73));
		people.add(new Person("Aless", 40));

		// interesting: no return needed :-)
		Predicate<Person> predMoreThan40=(person) -> person.getAge()>40;
		Predicate<Person> predNoMoreThan40=(person) -> !(person.getAge()>40);
		System.out.println("People older than 40:");
		displayPeople(people, predMoreThan40);
		System.out.println("People not older than 40:");
		displayPeople(people, predNoMoreThan40);
		System.out.println("World-wide gold citizens (65 years old or more) who are not «John Doe»:");
		displayPeople(people, (person) -> {
			if(person.getName().compareToIgnoreCase("John Doe")!=0){
				return person.getAge()>=65;								
			}else{
				return false;
			}
		});
	}

	/**
	 * Display people whose attributes follow the given predicate
	 * @param people the list of people
	 * @param pred the predicate to filter them
	 */
	static void displayPeople(List<Person> people, Predicate<Person> pred) {
		people.sort((p1,p2)->p1.getName().compareToIgnoreCase(p2.getName()));
		people.forEach(person -> {
			if(pred.test(person)){
				System.out.println(person.toString());
			}
		});
	}

}