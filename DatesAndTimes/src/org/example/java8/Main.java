package org.example.java8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Main {

	public static void main(String[] args) {
		LocalDate currentDate=LocalDate.now();
		System.out.println("the current date: "+currentDate);
		
		LocalDate specificDate=LocalDate.of(1994,7,4);
		System.out.println("a specific date: "+specificDate);
		
		LocalTime currentTime=LocalTime.now();
		System.out.println("the current time: "+currentTime);
		
		LocalTime specificTime=LocalTime.of(13, 13, 45, 1);
		System.out.println("the specific time: "+specificTime);
		
		LocalDateTime currentDateTime=LocalDateTime.now();
		System.out.println("the current date and time: "+currentDateTime);

		
		LocalDateTime specificDateTime=LocalDateTime.of(specificDate,specificTime);
		System.out.println("the specific date and time: "+specificDateTime);
	}

}
