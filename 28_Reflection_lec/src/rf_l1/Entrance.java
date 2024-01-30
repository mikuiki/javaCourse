
package rf_l1;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;


class Person{
	String nameString;
	int age;
	
	Person(){
		
	}
	
	public Person(String name) {
		this.nameString = name;
	}
	
	private Person(String name, int age) {
		this.nameString = name;
		this.age = age;
	}
	
	void test(String a, int b) {
		System.out.println(a + b);
	}
}
public class Entrance {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, Exception, Exception {
		
		Class p1Class = Person.class;
		
		Person p3 = new Person();
		Class p3Class = p3.getClass();
		
		System.out.println(p1Class);
		System.out.println(p3Class);
		
//		1、获取构造函数数组，constructors[], 有构造函数（方法）其包含的方法有getName, getModifiers, getParametterTypes
//		Constructor[] constructors = p3Class.getDeclaredConstructors();
//		System.out.println(constructors.length);
//		
//		for(int i = 0; i< constructors.length; i++) {
//			System.out.println(constructors[i]);
//			System.out.println(constructors[i].getName());
//			System.out.println(constructors[i].getModifiers());
//			System.out.println(java.lang.reflect.Modifier.toString(constructors[i].getModifiers()));
//			
//			
//			Class[] paraClasses = constructors[i].getParameterTypes();
//			for(int j = 0; j< paraClasses.length; j++) {
//				System.out.println(paraClasses[j]);
//			}
		
		
		
//		2. 获取指定构造方法，需要在getDeclaredConstructor()当中传一个类型为Class的数组，此处为String和int
//		之下的部分for循环是对这个方法的验证
//		Class[] classes = {String.class, int.class};
//		Constructor<Person> defConstructor = p1Class.getDeclaredConstructor(classes);
//		
//		
//		Class[] para = defConstructor.getParameterTypes();
//		for(int j = 0; j< para.length; j ++) {
//			System.out.println(para[j]);
//		}
		
//		3. 通过反射找到对应类后的实例化对象的过程
		Person insPerson = (Person)p3Class.newInstance();	// 为什么这里要有一个向下转型,1. 默认构造函数
		System.out.println(insPerson.nameString);			// 这里调取的是默认的构造函数
		
		Class[] classes = {String.class, int.class};       // 带参数的构造函数，有初始化过程的
		Constructor constructor = p3Class.getDeclaredConstructor(classes);
		constructor.setAccessible(true);
		Person insPerson2 = (Person)constructor.newInstance("gpp",20); // 带参数的构造函数的实例化
		System.out.println(insPerson2.age);
		
//		4. 所有方法method，属性field
		Method[] methods = p3Class.getDeclaredMethods();
		for(int i=0; i< methods.length; i++) {
			System.out.println(methods[i]);
		}
//		属性
		System.out.println(p3Class.getDeclaredField("age"));
//		指定的生命的方法的获取以及使用
		Method methods2 = p3Class.getDeclaredMethod("test", classes);
		methods2.setAccessible(true);
		methods2.invoke(insPerson2, "thh",30);
		
		
		

	}
 
}

