package com.example.javase8;

import com.example.javase8.interfaces.InterfaceWithArgs;
/**
 * Modifications from the course "Java SE 8 New Features" by David Gassner, 
 * only to make it more interesting
 * @author Alessandro
 *
 */
public class UseInterfaceWithArgs {

	public static void main(String[] args) {
		InterfaceWithArgs obj=(v1,v2) -> {
			// How to call hundred from here??, 
			// example result=v1+v2*this.hundred() ¿???
			int result=v1+v2;
			// System.out.println("The result is: "+result);
			return result;
		};
		System.out.println("The result is: "+obj.calculate(10, 5));
		System.out.println("The result is: "+obj.hundred(10, 5));
	}


}
