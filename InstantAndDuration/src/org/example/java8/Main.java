package org.example.java8;

import java.time.Instant;

public class Main {

	public static void main(String[] args) {
		Instant start=Instant.now();
		System.out.println("Starting at "+start);
		Instant end=Instant.now();
		System.out.println("  Ending at "+end);
		System.out.println("The nanoseconds of duration: "+ (end.getNano()-start.getNano()));
	}

}
