package org.example.java8;

public class UseRunnable {

	public static void main(String[] args) {
		// the amount of code can be much less than the first version's 
		new Thread(
			() -> {
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("Running Thread 1");			
			}				
		).start();
		new Thread(() -> System.out.println("Running Thread 2")).start();
	}

}
