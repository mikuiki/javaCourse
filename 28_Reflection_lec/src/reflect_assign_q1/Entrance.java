package reflect_assign_q1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Entrance {

	public static void main(String[] args) throws Exception {
		Class myClass = People.class;
		
//	    问题3： 通过反射两个不同的构造函数声成两个对象，np1People and np2People
		Constructor constructor1 = myClass.getDeclaredConstructor(null);
		System.out.println(constructor1);
		constructor1.setAccessible(true);
		People np1People = (People)constructor1.newInstance(null);
		np1People.test();
		
		Class[] classes = {int.class, String.class};
 		Constructor constructor2 = myClass.getDeclaredConstructor(classes);
		System.out.println(constructor2);
		People np2People = (People)constructor2.newInstance(10, "mike");
		System.out.println(np2People.age + " " + np1People.age + " " + np2People.genderString);
		
//		问题4：反射-成员变量访问
		Field myField1 = myClass.getDeclaredField("age");
		Field myField2 = myClass.getDeclaredField("nameString");
		Field myField3 = myClass.getDeclaredField("genderString");
		System.out.println(myField1.get(np2People));
		myField2.setAccessible(true);
		System.out.println(myField2.get(np2People));
		System.out.println(myField3.get(np2People));
		
//		问题6：反射-成员变量赋值
		myField1.set(np2People, 20);
		System.out.println(myField1.get(np2People));
		myField2.set(np2People, "Red");
		System.out.println(myField2.get(np2People));
		myField3.set(np2People, "female");
		System.out.println(myField3.get(np2People));
		
		
//		问题5：通过反射调用成员变量的方法
		Method mtestMethod = myClass.getDeclaredMethod("test", null);
		mtestMethod.invoke(np1People);
		
		Method mytest1Method = myClass.getDeclaredMethod("test1", int.class);
		mytest1Method.setAccessible(true);
		mytest1Method.invoke(np1People, 20);
		
		Method mytest2Method = myClass.getDeclaredMethod("test2", classes);
		mytest2Method.invoke(np1People, 30, "lily");
		
//		第二大题：静态方法的调用，不需要对象
		Method mytest3Method = myClass.getDeclaredMethod("test3", int.class);
		mytest3Method.invoke(np1People, 50);
	}

}


class People{
	// 问题1：三个成员方法
	int age=30;
	private String nameString;
	public String genderString;
	
	// 问题2： 两个构造函数
	private People(){
		
	}
	
	public People(int age, String nameString) {
		this.age = age;
		this.nameString = nameString;
	}
	
	// 问题1：三个成员方法
	void test() {
		System.out.println("无参，默认权限，成员方法test");
	}
	
	private void test1(int age) {
		System.out.println("有一个int 类型参数，private权限 成员方法 " + age);
	}
	
	public void test2(int age, String name) {
		System.out.println("两个参数public成员方法 " + name + " " + age );
		
	}
	
//	二大题：添加一个静态public类，通过不新建对象的方式进行反射调用，验证
	public static void test3(int age) {
		System.out.println("有一个int 类型参数，public权限 静态 成员方法 " + age);
	}
}