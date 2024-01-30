package Generic_assign_q3_update;

public class Gene {

	public static void main(String[] args) {
		A a = new A();
		B b1 = new B();
		C c = new C();
//		使用泛型方法的好处是返回类型就是传入参数的类型，不需要向下转型，如果普通方法，会返回C类型的票指向B类型的对象，需要向下转型
		B b2B = a.test(b1);
		B b3B = (B) a.testOdC(b1);
	}

}

class A{
//  C为上界的泛型方法
	<E extends C> E test(E e1){
		e1.testC();
		return e1;
	}
	
//	C为返回值的普通方法
	C testOdC(C c) {
		c.testC();	
		return c;
	}
}


class B extends C{
	
}

class C{
	void testC() {
		
	}
}