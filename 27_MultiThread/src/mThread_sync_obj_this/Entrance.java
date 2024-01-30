package mThread_sync_obj_this;


public class Entrance {

	public static void main(String[] args) {
		Thread1 thread1 = new Thread1();
		Thread2 thread2 = new Thread2();
		
		A a = new A();
		// 通过setA 方法明确是同一个对象的，这样在调起类A 的方法体test的时候，this才会定位同一个this，才会有synchronized效果
		thread1.setA(a);
		thread2.setA(a);
		thread1.start();
		thread2.start();
		
	}

}

class Thread1 extends Thread{
	A a;
	public void run() {
		a.test();
	}
	void setA(A a) {
		this.a = a;
	}
}

class Thread2 extends Thread{
	A a;
	public void run() {
		a.test();
	}
	
	void setA(A a) {
		this.a = a;
	}
}

class A{
	void test() {
		synchronized (this) {
			for(int i=0; i<10; i++) {
				System.out.println("线程调用方法体--->" + i);
			}	
		}
	}
}