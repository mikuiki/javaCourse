package hahMap_assign_q2;

import java.util.HashMap;

public class Entrance {

	public static void main(String[] args) {
		HashMap<Person, Integer> hsMap = new HashMap<>();
		
		hsMap.put(new Person(10), 10);
		hsMap.put(new Person(10), 20);
		
		System.out.println(hsMap.get(new Person(10))); // 复写hashCode, 判断预计变更，
                                                       // 如果age相同则认为是同一对象，可以找到get可以找到匿名键对应的值
		System.out.println(hsMap.size());
		
	}

}

class Person{
	int age;
	
	public Person(int age) {
		this.age = age;
	}
	
	public int hashCode() {
		return 1;
	}
	
	public boolean equals(Object o) {
		Person psPerson = (Person)o;
		return psPerson.age == this.age;
	}
}