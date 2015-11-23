package org.example.java8.interfaces;

public interface PersonInterface {
	
	String getName();
	void setName(String name);
	int getAge();
	void setAge(int age);
	static String getPersonInfo(PersonInterface p){
		return p.getName() + " (" + p.getAge() + ")";
	}
}
