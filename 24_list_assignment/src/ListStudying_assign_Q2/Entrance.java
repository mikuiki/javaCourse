package ListStudying_assign_Q2;

import java.util.ArrayList;

public class Entrance {
	public static void main(String[] args) {
		ArrayList<Person> colList = new ArrayList<Person>();
		colList.add(new Person(15, "wo"));
		colList.add(new Person(16, "ai"));
		colList.add(new Person(17, "wo"));
		colList.add(new Person(18, "ai"));
		
		Person refPerson = new Person(15, "wo");
		
		System.out.println(colList.contains(refPerson));
		
		
	}
}

class Person{
	int age;
	String name;
	
	Person(int age, String name){
		this.age = age;
		this.name = name;
	}
	
	public boolean equals(Object obj) {
		Person psPerson = (Person)obj;
		if((psPerson.age == this.age) && (psPerson.name.equals(this.name))) {
			return true;
		}else {
			return false;
		}
		
	}
}