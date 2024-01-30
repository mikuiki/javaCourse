package genericsStudying;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		People people = new People();
		People spPeople = new Student();
		Student sxStudent =(Student)spPeople;
		sxStudent.test();
		
		ArrayList<String> arrayList = new ArrayList<>();
		
		
	}

}

class People{
	
}

class Student extends People{
	void test() {
		System.out.println("测试");
	}
}

class Dos{
	void testDog() {
		System.out.println("ceshiDog");
	}
}