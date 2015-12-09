package com.example.java8;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		
		Path path = FileSystems.getDefault().getPath("files", "hamlet.txt");
		String searchTerm="To be, or not to be";
		try (Stream<String> lines=Files.lines(path)) {
			Optional<String> line=lines.filter(l -> l.contains(searchTerm)).findFirst();
			if(line.isPresent()){
				System.out.println("Found: "+line.get());
			}else{
				System.out.println("Not found");				
			}
		} catch (Exception e) {
			System.out.println("There was an error "+e.getMessage());				
		}
	}		

}
