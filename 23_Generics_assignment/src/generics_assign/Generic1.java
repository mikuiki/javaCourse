package generics_assign;

class Generic1{
	public static void main(String[] args) {
		// 泛型类声明对象，参数上级定义为person
		Human<Student, Person> stuGeneric = new Human<>();
		Student stu1 = new Student();
		Person ps1 = new Person();
		// 泛型类实例化对象形参传入，参数为上界及继承的票
		// 泛型类中三个成员方法调用，1. getFirstT()方法使用后返回Student类，可以调Student和父类Person的test方法，
		//		                2. getSecondV()方法返回Person类对象，可以调Person类的test1方法
		stuGeneric.setT(stu1, ps1);
		stuGeneric.getFirstT().test2();
		stuGeneric.getSecontV().test1();
	}
}

class Person{
	void test1() {	
		System.out.println("Person.test1()");
	}
}

class Student extends Person{
	void test2() {	
		System.out.println("Studnet.test2()");
	}
}

// 新建泛型类，参数界限设置为Person
class Human<T extends Person, V>{
	// 两个成员变量
	T firstT;
	V secondV;
	
	// 三个成员方法,1. 赋值，2-3.返回值
	void setT(T t1, V v1) {
		this.firstT = t1;
		this.secondV = v1;
	}
	
	T getFirstT() {
		return this.firstT;
	}
	
	V getSecontV() {
		return this.secondV;
	}
}