package org.example.java8;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Main {

	public static void main(String[] args) {

		DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
		LocalDateTime dt = LocalDateTime.now();
		System.out.println(dtf.format(dt));
		
		ZonedDateTime gmt=ZonedDateTime.now(ZoneId.of("GMT+0"));
		System.out.println("The GMT date time: "+gmt);

		ZonedDateTime crct=ZonedDateTime.now(ZoneId.of("America/Costa_Rica"));
		System.out.println("The Costa Rica date time: "+crct);

		ZonedDateTime nyt=ZonedDateTime.now(ZoneId.of("America/New_York"));
		System.out.println("The New York date time: "+nyt);
	}

}
