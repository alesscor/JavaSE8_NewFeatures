package org.example.java8;

public class UseRunnable {

	public static void main(String[] args) {
		
		Runnable r1= () -> System.out.println("Running Thread 1");		
		Runnable r2= () -> System.out.println("Running Thread 2");

		new Thread(r1).start();
		new Thread(r2).start();
		
	}

}
