package mThread_create_common;

public class Entrance {

	public static void main(String[] args) {
		MyThread myThread = new MyThread(); // 新启动一个线程
		myThread.start();					// 新启动一个线程
		
		for(int i = 0 ; i <100; i++) {
			System.out.println("主线程 -> " + i);
		}
		
		MyThread2 myThread2 = new MyThread2(); // 新启动一个线程
		myThread2.start();					// 新启动一个线程

	}

}


class MyThread extends Thread{
	public void run() {
		for(int i = 0 ; i <1000; i++) {
			System.out.println("Mythread -> " + i);
		}
	}
}


class MyThread2 extends Thread{
	public void run() {
		for(int i = 0 ; i <100; i++) {
			System.out.println("Mythread2 -> " + i);
		}
	}
}