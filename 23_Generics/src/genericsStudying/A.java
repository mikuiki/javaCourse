package genericsStudying;


// case 1
// 1. 写一个类+一个成员方法，2. 方法在调用时可以传入任何类型的对象，3.成员方法的返回值是他本身
//public class A {
//	Object test(Object obj) {
//		return obj;
//	}
//	
//	
//	public static void main(String[] args) {
//		A a = new A();
//		// 涉及到强转向下转型，不然的话返回的是Object类，不能用B类的票b 接受，会编译报错
//		B b = (B)a.test(new B());
//		b.testB();
//	}
//}
//
//
//class B{
//	void testB() {
//		System.out.println("I am test");
//	}
//}



//// case 2
//public class A<T>{
//	T t;
//	
//	void setT(T t) {
//		this.t = t;
//	}
//	
//	T getT() {
//		return t;
//	}
//	
//	T test(T t) {
//		return t;
//	}
//	
//	public static void main(String[] args) {
////		A<String> a = new A<String>();
////		The build function type of object can be omit in <> 泛型的参数在构造函数new当中<>中的参数可以省略
//		A<String> a = new A<>();
//		a.test("feafe");
////		a was assigned to be String type when created, the only object can be used in a.test() was limited to String
////		a.test(new B());
//	}
//}
//
//class B{
//	void testB() {
//		
//	}
//}




//
////case 3, 泛型有上界 extends，只可以用extends限定上界，不能用super，B本身或者B的子类，
//public class A<T extends B>{
//	T t;
//	T test(T t) {
//		return t;
//	}
//	
//	public static void main(String[] args) {
////		泛型的选择只能用B或者B 的子类 C或者D
//		A<C> a = new A<C>();
//		a.test(new C());
//	}
//}
//
//class B{
//	void testB() {
//		
//	}
//}
//class C extends B{
//	
//}


//case 4
public class A{
//  通配符用在方法的参数列表中
	void testA(B<? super C> a) {
		D d = new D();
		a.test(d);
	}
	
	public static void main(String[] args) {
		B<C> b1 = new B<>();
		B<E> b2 = new B<>();
		A a = new A();
//		b1 是泛型类B<C> 生成的票，b2 是泛型类B<D> 生成得票，泛型类的参数 类C和D是有继承关系，但是泛型类本身没有继承关系
		a.testA(b1);
//		a.testA(b2);  //此处编译不通过
		a.testA(b2);  //编译通过，因为在类A中，参数类型添加了通配符 <? extends C>
	}
}

class B<T> {
	void test(T t) {
		
	}
}

class E{
	
}

class C extends E{
	
}

class D extends C{
	
}

class F extends C{
	
}

//case5
//public class A<T>{
//	void testA(T t) {
//		
//	}
////	T的类型是在实例化过程中确定的，static方法不适用
////	static void testA1(T t) {
////	}
////	方法调用过程中，进行泛型类的选择和确定
////	泛型的意义，不需要向下转型
//	static <E> E testA1(E e) {
//		
//		return e;
//	}
//	
//	public static void main(String[] args) {
//		// 静态static方法在泛型类中，不需要生成新对象就可以调用的泛型类的方法
//		String a = A.testA1("STRING");
//	}
//}
//
//class B{
//	void testB() {
//		
//	}
//}











