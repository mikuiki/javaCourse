package mThread_sync_obj;

public class Entrance {

	public static void main(String[] args) {
		
		Object object = new Object();
		MyThread1 myThread1 = new MyThread1();
		MyThread2 myThread2 = new MyThread2();
		
		myThread1.setObject(object);
		myThread2.setObject(object);
		
		myThread1.start();
		myThread2.start();
	}

}


class MyThread1 extends Thread{
	Object obj;
	public void run() {
		synchronized (obj) {
			for(int i=0; i<10; i++) {
				System.out.println("子线程1-->" + i);
			}
		}	
	}
	void setObject(Object obj) {
		this.obj = obj;
	}
}


class MyThread2 extends Thread{
	Object obj;
	public void run() {
		
		for(int i=0; i<10; i++) {
			System.out.println("子线程2-外部没有sync-与子线程1交错->" + i);
		}
		
		synchronized (obj) {
			for(int i=0; i<10; i++) {
				System.out.println("子线程2-->" + i);
			}
		}

	}
	void setObject(Object obj) {
		this.obj = obj;
	}
}