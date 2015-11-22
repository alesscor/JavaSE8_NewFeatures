package com.example.javase8.interfaces;
/**
 * Modifications from the course "Java SE 8 New Features" by David Gassner, 
 * only to make it more interesting
 * @author Alessandro
 *
 */
@FunctionalInterface
public interface InterfaceWithArgs {
	
	public int calculate(int value1, int value2);	
	public default int hundred(int value1, int value2){
		return calculate(value1,value2*100);
	}
}
