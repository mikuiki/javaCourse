package setStudying;

import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeSet;

// case1 HashSet and HashCode
//public class A{
//	
//	public static void main(String[] args) {
//		HashSet<People> p = new HashSet<>();
//		People p1 = new People("xiaoming");
//		People p2 = new People("xiaoming");
//				
//		boolean b1 = p.add(p1);
//		boolean b2 = p.add(p2);
//		
//		System.out.println(b1);
//		System.out.println(b2);
//	}
//}

//class People{
//	String name;
////	构造函数
//	public People(String name) {
//		this.name = name; // TODO Auto-generated constructor stub
//	}
//
////	@Override hashCode函数，返回值不同，一定是不同对象
////  即使是不同对象，我还想做更多的比较，这个时候需要屏蔽掉hashCode
//// 	不然直接跳出true, add 成功， 给他赋值相同的值，跳进name参数查看是否相同
//	public int hashCode() {
//		// TODO Auto-generated method stub
//		return 1;
//	}
//	
//	@Override
//	public boolean equals(Object obj) {
//		People pe = (People)obj; // TODO Auto-generated method stub
//		return this.name.equals(pe.name);
//	}
//}





// TreeSet demo
public class A{
	public static void main(String[] args) {
//		TreeSet<Person> aPersons = new TreeSet<>(); // 方法一建树过程，不需要构造函数中传对象
		TreeSet<Person> aPersons = new TreeSet<>(new B());
		boolean b1 = aPersons.add(new Person(100));
		boolean b2 = aPersons.add(new Person(96));
		boolean b3 = aPersons.add(new Person(80));
		boolean b4 = aPersons.add(new Person(70));
		System.out.println(b4);
		for(Person unit: aPersons) {
			System.out.println(unit.age);
		}
	}
}

//TreeSet建树方法一, 在类当中构造Tree
//class Person implements Comparable{
//	int age;
//	
//	Person(int age){
//		this.age = age;
//	}
//	public int compareTo(Object o) {
//		Person p = (Person)o;
//		return -(this.age - p.age);
//	}
//	
//}

//建树方法二, 单独一个类，用来构造Tree
class Person{
	int age;
	Person(int age){
		this.age = age;
	}
}

class B implements Comparator{
	public int compare(Object o1, Object o2) {
		Person p1Person = (Person)o1;
		Person p2Person = (Person)o2;
		return p1Person.age - p2Person.age;
	}
	
}


