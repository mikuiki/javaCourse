package setStudying_assign_q1;

import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeSet;

//public class Entrance {
//	public static void main(String[] args) {
//		// p1Person and p2Person are not the same object, even though the content is the same
//		Person p1Person = new Person(25, "wo");
//		Person p2Person = new Person(25, "wo");
//		// p1Person and p3Person are oriented to the same object
//		Person p3Person = p1Person;
//		
//		System.out.println(p1Person == p2Person); // false
//		System.out.println(p1Person == p3Person); // true
//		
//		HashSet<Person> hSet = new HashSet<>();
//		boolean b1 = hSet.add(p1Person);	// true; add successfully
//		System.out.println(b1);
//		
//		boolean b2 = hSet.add(p2Person);
//		System.out.println(b2);				// false; 
//		
//		boolean b3 = hSet.add(p3Person);
//		System.out.println(b3);				// false;
//	}	
//
//}
//
//class Person{
//	int age;
//	String nameString;
//	
//	public Person(int age, String namString) {
//		this.age = age;
//		this.nameString = namString;		
//	}
//	
//	public int hashCode() {
//		return 1;
//	}
//	
//	public boolean equals(Object o) {
//		Person pObjPerson = (Person)o;
//		return this.nameString.equals(pObjPerson.nameString);
//	}
//}


// Question 3
public class Entrance {
	public static void main(String[] args) {
		Person p1Person = new Person(1, "wo1");
		Person p2Person = new Person(2, "wo2");
		Person p3Person = new Person(3, "shi3");
		Person p4Person = new Person(4, "hao4");
		Person p5Person = new Person(5, "ren5");
		Person p6Person = p1Person;
		
		TreeSet<Person> tSet = new TreeSet<>();
		boolean a1 = tSet.add(p1Person);
		boolean a2 = tSet.add(p2Person);
		boolean a3 = tSet.add(p3Person);
		boolean a4 = tSet.add(p4Person);
		boolean a5 = tSet.add(p5Person);
		
		for(Person unit:tSet) {
			System.out.println(unit.age);
		}		
	}	
}

class Person implements Comparable{
	int age;
	String nameString;
	
	public Person(int age, String namString) {
		this.age = age;
		this.nameString = namString;		
	}
	
	public int compareTo(Object o) {
		Person pl = (Person)o;
		if(this.age % 2 == 0) {
			return -1;
		}else {
			return 1;
		}
	}
	
}
//
//class B implements Comparator{
//	public int compare(Object o1, Object o2) {
//		Person p = (Person)o1;
//		if(p.age % 2 == 0) {
//			return -1;
//		}else {
//			return 1;
//		}
//	}
//}
