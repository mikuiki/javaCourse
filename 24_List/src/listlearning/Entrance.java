package listlearning;
import java.util.ArrayList;

public class Entrance{
	public static void main(String[] args) {
		ArrayList<Person> list = new ArrayList<>();
		// 生成两个对象，地址不同，但是成员变量的值相同
		// 测试：1、如果按照默认的 equals 方法，能否找到并且删除
		// 测试：2、重写对象-类中的 equals 方法，返回值变更，看能否删除
		// 注意点： 注意向下转型， Object 和 Person, Person是子类
		Person p1 = new Person(20);
		Person p2 = new Person(20);
		list.add(p1);
		list.add(p2);
		list.add(p1);
		
		Object[] arr = list.toArray();
		for(int i =0; i <arr.length; i++) {
			System.out.println(arr[i]);
		}
//		
//		System.out.println(list.size());
//		
//		System.out.println(p1.equals(p2));
//		System.out.println(list.remove(p2));
//		
//		System.out.println(list.size());
		
		
		
	}
}

class Person{
	int age = 18; 
	
	Person(int age) {
		this.age = age; 
	}
	
	public boolean equals(Object obj) {
		Person p = (Person) obj;
		return(this.age == p.age);
	}
	
}

