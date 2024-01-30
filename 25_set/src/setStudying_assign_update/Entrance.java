package setStudying_assign_update;
import java.util.HashSet;
import java.util.TreeSet;

public class Entrance {

	public static void main(String[] args) {
		TreeSet<People> tSet = new TreeSet<>();

		People p1People = new People(10);
		People p2People = new People(20);
		People p3People = new People(30);
		People p4People = new People(40);
		People p5People = new People(50);
		People p6People = new People(20);
		
		tSet.add(p1People);
		tSet.add(p2People);
		tSet.add(p3People);
		tSet.add(p4People);
		tSet.add(p5People);
		
		System.out.println(tSet.add(p6People)); //添加失败，虽然p6People是一个新对象，
												//但是建树比较的是age的值，age值相同，添加失败
		System.out.println(tSet.size());
		
		for(People unit:tSet) {
			System.out.println(unit.age);
		}
	}
}

class People implements Comparable{
	int age;

	public People(int age) {
		this.age = age;	
	}
	public int compareTo(Object o) {
		People people = (People)o;
		return people.age - this.age;	
	}
}