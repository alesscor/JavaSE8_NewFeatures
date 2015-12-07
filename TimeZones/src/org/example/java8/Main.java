package org.example.java8;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Collection;
import java.util.Set;
import java.util.function.Predicate;

import com.sun.net.httpserver.Filter;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

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
		
		Set<String> zones=ZoneId.getAvailableZoneIds();
		zones.stream()
		.filter(
				(z)->z.toString().contains("Costa_Rica")
					||z.toString().contains("Managua")
					||z.toString().contains("Panama")
					||z.toString().contains("Mexico"))
		.forEach(zone -> System.out.println(zone));
	}

}
