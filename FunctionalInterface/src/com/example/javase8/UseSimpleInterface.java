package com.example.javase8;

import com.example.javase8.interfaces.SimpleInterface;

public class UseSimpleInterface {

	public static void main(String[] args) {
		SimpleInterface i=() -> System.out.println("Carajada");
		i.doSomething();
	}

}
