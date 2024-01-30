package mThread_sync_class;


public class Entrance {

	public static void main(String[] args) {
		Thread1 thread1 = new Thread1();
		Thread2 thread2 = new Thread2();
		Thread3 thread3 = new Thread3();

		thread1.start();
		thread2.start();
		thread3.start();
		
	}

}


//类锁的第一种表示，静态synchronized修饰的方法体，等于上了一个类锁
class Thread1 extends Thread{
	A a = new A();
	public void run() {
		a.test();
	}
}

class Thread2 extends Thread{
	A b = new A();
	public void run() {
		b.test();
	}
}

class Thread3 extends Thread{
	public void run() {
		A.test();
	}
}

class A{
	static synchronized void test() {
		for(int i=0; i<10; i++) {
			System.out.println("线程调用方法体--->" + i);
		}
	}
}

// 类锁的第二种表示
//class Thread1 extends Thread{
//	A a = new A();
//	public void run() {
//		a.test();
//	}
//}
//
//class Thread2 extends Thread{
//	B b = new B();
//	public void run() {
//		b.test();
//	}
//}
//// 类锁，虽然不是同一个对象调起，但是归为同一个类，在时间片内也需要等待，一个完成后释放，开启另一个线程
//class A{
//	void test() {
//		synchronized (A.class) {
//			for(int i=0; i<10; i++) {
//				System.out.println("线程调用方法体--->" + i);
//			}
//			
//		}
//	}
//}
//
//// 另外一个类中，创建一个A类的类所，在线程当中也可以
//class B{
//	void test() {
//		synchronized (A.class) {
//			for(int i=0;i<10;i++) {
//				System.out.println("B类线程调用-->"+ i);
//			}
//			
//		}
//	}
//}