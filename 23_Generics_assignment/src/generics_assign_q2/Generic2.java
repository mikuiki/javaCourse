package generics_assign_q2;

class Generic2{
//	1.写一个成员方法参数列表可以接受一个Person泛型类，并且泛型类参数的上界是Person
	void atest(Person<? super Person> o) {
		Person<Student> pssPerson = new Person<>();
		Person<Person> ppPerson = new Person<>();
		Student student = new Student();
		
		o.setT(pssPerson);
		o.setT(ppPerson);
		o.setT(student);
		
	}
	
	public static void main(String[] args) {
		Person<Person> psPerson = new Person<>();
		Person<Student> psstPerson = new Person<>();
	}
}

class Human{
	void humanTest() {
		
	}
}

class Person<T> extends Human{
	T t;
	void setT(T t) {
		this.t = t;
	}
	
	void getT() {
		System.out.println(this.t);
	}
	
}

class Student extends Person{
	void testStudent() {
		System.out.println("student对象的test方法");
	}
}
