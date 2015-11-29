package org.example.java8;

import java.time.Duration;
import java.time.Instant;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Instant start=Instant.now();
		System.out.println("Starting at "+start);
		
		Thread.sleep(1000);
		
		Instant end=Instant.now();
		System.out.println("  Ending at "+end);
		
		// beware of the strict get nano, not including milliseconds, look at #theoutput
		System.out.println("The elapsed nanoseconds: "+ (end.getNano()-start.getNano()));
		
		Duration elapsed=Duration.between(start, end);
		System.out.println("Elapsed: "+elapsed.toMillis()+" ms");
//#theoutput:
//Starting at 2015-11-29T23:43:16.871Z
//Ending at 2015-11-29T23:43:17.938Z
//The elapsed nanoseconds: 67000000
//Elapsed: PT1.067S

		
	}

}
