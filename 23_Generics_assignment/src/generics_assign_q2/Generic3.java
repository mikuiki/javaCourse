package generics_assign_q2;

class Generic3{
	public static void main(String[] args) {
		A a = new A();
		B b1 = new B();
		C c = new C();
		B b2 = a.test(b1, c);
		D d = new D();
		// 用D的对象访问D中的两个成员方法，一个参数是最上界，另一个参数是泛型参数
		// 打印结果一致，看不出什么区别，都可以访问到最上限的类以及子类中的方法和变量
		System.out.println(d.testD(b1));
		System.out.println(d.testGen(b1));		
	}
}


class B extends C{
	void testB() {		
	}
}

class C{
	void testC() {
	}
}

class D{
	C testD(C k) {
		return k;
	}
	
	<E extends C> E testGen(E e){
		return e;
	}
}

class A{
	<E extends B, T extends C> E test(E e1,T e2){
		e1.testB();
		e1.testC();
		e2.testC();
		return e1;
	}
}

