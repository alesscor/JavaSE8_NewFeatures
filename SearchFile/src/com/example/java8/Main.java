package com.example.java8;

import java.nio.file.FileSystems;
import java.nio.file.Path;

public class Main {

	public static void main(String[] args) {
		
		@SuppressWarnings("unused")
		Path path = FileSystems.getDefault().getPath("files", "hamlet.txt");
		
	}		

}
