package ListStudying;

import java.util.ArrayList;
import java.util.Iterator;

class List_assign{
	public static void main(String[] args) {
		ArrayList<Student> coll = new ArrayList<Student>();
		// 生成两个对象，存储相同内容
		Student s1Student = new Student("赵六",26);
		Student s2Student = new Student("赵六",26);
		// 添加6个对象到ArrayList类变量coll中，其中s1Student相同对象，添加两次
		coll.add(new Student("张三",23));		
		coll.add(new Student("李四",24));
		coll.add(new Student("王五",25));
		coll.add(s2Student);
		coll.add(s1Student);
		coll.add(s1Student);
		// 输出元素 为6，list内的元素可以相同
		System.out.println(coll.size());
		// 匹配成功，执行完元素数目为5
		coll.remove(s2Student); 
		System.out.println(coll.size());
		// 即使元素内容相同，内存地址不同，未复写equal方法时，无法匹配remove，元素数目为5
		coll.remove(s2Student);
		System.out.println(coll.size());
		
		System.out.println(coll.contains(s2Student));
		System.out.println(coll.contains(s1Student));
		System.out.println(coll.indexOf(s2Student));
		System.out.println(coll.contains("hello"));
		
	}
}

class Student{
	String name;
	int age = 0;
	
	Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
}