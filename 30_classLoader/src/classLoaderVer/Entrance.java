package classLoaderVer;

import java.util.ArrayList;

import javax.swing.text.html.HTMLDocument.HTMLReader.SpecialAction;

public class Entrance {

	public static void main(String[] args) {

		ClassLoader classLoader = Entrance.class.getClassLoader();
//		
//		StringBuilder stringBuilder = new StringBuilder("|--");
//		boolean flag = true;
//		
//		while(flag) {
//			System.out.println(stringBuilder.toString() + classLoader);
//			if(classLoader == null) {
//				flag = false;
//			}else {
//				classLoader = classLoader.getParent();
//				stringBuilder.insert(0, "\t");
//			}
//		}
		
		
		System.out.println(Person.class.getClassLoader());
		System.out.println(B.class.getClassLoader());
	}
}

class Person{
	int age;
	String nameString;
	
	void test() {
		
	}
}

class B extends Thread{
	
}