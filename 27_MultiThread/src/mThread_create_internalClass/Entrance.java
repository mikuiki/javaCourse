package mThread_create_internalClass;

import java.security.PublicKey;

public class Entrance {

	int age;
//	写法一：静态匿名内部类，涉及到向上转型，多态和内部类，
//	如果匿名类没有出现在static修饰的方法里面，那么是可以访问到成员变量的
	public static void main(String[] args) {
		Thread thread = new Thread() {
			public void run() {
				System.out.println("子线程" + 0);
				System.out.println("子线程" + 1);
				System.out.println("子线程" + 2);
				System.out.println("子线程" + 3);
			}
		}; // 静态匿名内部类, 静态属性，不能访问到成员变量
		
		thread.start();
  }
	
	
//	写法二：等效写法
//	public static void main(String[] args) {
//		Thread thread = new ThreadIn();
//		thread.start(); // 由于多态，执行ThreadIn 当中的run方法，run方法复习了父类Thread的run方法
//	}
//	
//	static class ThreadIn extends Thread{
//		public void run() {
//			System.out.println("子线程" + 0);
//			System.out.println("子线程" + 1);
//			System.out.println("子线程" + 2);
//			System.out.println("子线程" + 3);
//		}
//	}

}