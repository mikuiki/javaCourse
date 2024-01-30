package mThread_create_runnable;

import java.security.PublicKey;

//显明声明线程的方式
//public class Entrance {
//
//	public static void main(String[] args) {
//		MyRunnable runnable = new MyRunnable();
//		
//		Thread thread1Thread = new Thread(runnable);
//		Thread thread2Thread = new Thread(runnable);
//		thread1Thread.start();	
//		thread2Thread.start();
//	}
//
//}
//
//class MyRunnable implements Runnable{
//	public void run() {
//		for(int i = 0; i<50; i++) {
//			System.out.println("子线程--->" + i);
//		}
//	}
//}

//匿名静态内部类的方式，声明线程
public class Entrance{
	public static void main(String[] args) {
		Runnable runnable = new Runnable(){
			public void run() {
				for(int i=0; i<50; i++) {
					System.out.println("子线程--->" + i);
				}
			}
		};
		Thread t1Thread = new Thread(runnable);
		t1Thread.start();
	}
}