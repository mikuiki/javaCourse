package List_assign_update;

import java.util.ArrayList;

public class Entrance {

	public static void main(String[] args) {
		ArrayList<People> p1ArrayList = new ArrayList<>();
		People p1People = new People(10, "qq");
		People p2People = new People(20, "qq");
		People p3People = new People(30, "qq");
		
		p1ArrayList.add(p1People);
		p1ArrayList.add(p2People);
		p1ArrayList.add(p3People);
		
		p1ArrayList.contains(p2People);
		
		

	}

}

class People{
	
	int age;
	String nameString;
	
	People(int age, String nameString){
		this.age = age;
		this.nameString = nameString;
	}
	
}