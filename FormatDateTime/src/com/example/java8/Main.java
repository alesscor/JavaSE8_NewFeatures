package com.example.java8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;
import java.util.Locale;

public class Main {

	public static void main(String[] args) {
		LocalDate currentDate=LocalDate.now();
		// the formatter object
		DateTimeFormatter df=DateTimeFormatter.ISO_DATE;
		System.out.println("the current date: "+df.format(currentDate));

		LocalTime currentTime=LocalTime.now();
		// the formatter object
		DateTimeFormatter tf=DateTimeFormatter.ISO_TIME;
		System.out.println("the current time: "+tf.format(currentTime));
		
		LocalDateTime currentDateTime=LocalDateTime.now();
		// the formatter object
		DateTimeFormatter dtf=DateTimeFormatter.ISO_DATE_TIME;
		System.out.println("the current time: "+dtf.format(currentDateTime));
		
		// custom formatters
		DateTimeFormatter f_long=DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
		System.out.println("the date time in long format: "+f_long.format(currentDateTime));

		DateTimeFormatter f_short=DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
		System.out.println("the date time in short format: "+f_short.format(currentDateTime));
		
		String fr_short=f_short.withLocale(Locale.FRANCE).format(currentDateTime);
		System.out.println("short version in French "+fr_short);
		String fr_long=f_long.withLocale(Locale.FRANCE).format(currentDateTime);
		System.out.println("long version in French "+fr_long);
		
		// Using a completely custom format, it uses the «Builder Design Pattern»
		// the formatter is made from the scratch		
		DateTimeFormatterBuilder builder=new DateTimeFormatterBuilder()
			.appendValue(ChronoField.MONTH_OF_YEAR)
			.appendLiteral("|")
			.appendValue(ChronoField.DAY_OF_MONTH)
			.appendLiteral("|")
			.appendValue(ChronoField.YEAR);
		DateTimeFormatter formatter=builder.toFormatter();
		
		System.out.println("the new formatter results: «"+formatter.format(currentDateTime)+"»");
	}

}
