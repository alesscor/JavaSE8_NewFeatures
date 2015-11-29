package org.example.java8;

import java.util.Arrays;
import java.util.stream.Stream;

import org.example.java8.model.Person;

public class ArrayToStream {
	public static void main(String args[]){

		Person[] people = {
				new Person("Joe", 48), 
				new Person("Mary", 30),
				new Person("Mike", 73)};
//	original version
//		for (int i = 0; i < people.length; i++) {
//			System.out.println(people[i].getInfo());
//		}
//	version using Stream interface		
//		Stream<Person> stream=Stream.of(people);
//		stream.forEach(p -> System.out.println(p.getInfo()));
//	version using Arrays interface
//		Stream<Person> stream=Arrays.stream(people);
//		stream.forEach(p -> System.out.println(p.getInfo()));
//	another version using Arrays interface
		Arrays.stream(people).forEach(p -> System.out.println(p.getInfo()));
	}
}