package reflect_assign_q4;

import java.lang.reflect.Method;

public class Entrance {

	public static void main(String[] args) throws Exception {
	B b = new B();
//	父类方法的调用，getSuperclass()方法在.class对象上的使用
	Method method = b.getClass().getSuperclass().getDeclaredMethod("test");
	method.setAccessible(true);
	method.invoke(b);
	}

}

class A{
	private void test() {
		System.out.println("I am A");
	}
}

class B extends A{
	
}
