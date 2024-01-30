package reflect_assign_q5_innerClass;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Entrance {
//  给一个内部类对象，如何通过反射，去获取所依靠的外部类对象的某个成员变量并打印出来。
	public static void main(String[] args) throws Exception {
		OuterClass otClass = new OuterClass();
		OuterClass.InnerClass innerClass = otClass.new InnerClass();
		Method outMethod = innerClass.getClass().getEnclosingClass().getDeclaredMethod("testOutter");
		outMethod.invoke(otClass);
		
		Field outField = innerClass.getClass().getEnclosingClass().getDeclaredField("age");
		outField.set(otClass, 20);
		System.out.println(outField.get(otClass));
		

	}

}

class OuterClass{
	
	int age;
	String nameString;
	
	void testOutter() {
		System.out.println("I am an outerClass method testOutter");
	}
	
	class InnerClass{
		void testInner() {
			System.out.println("I am innerClass method testInner");
		}
	}
}