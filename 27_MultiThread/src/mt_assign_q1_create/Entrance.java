package mt_assign_q1_create;

public class Entrance {

	public static void main(String[] args) {
		Thread thread1 = new Thread() {
			public void run() {
				System.out.println("方法三：静态匿名内部类，重写run函数，start函数开启线程");
			}
		};
		thread1.start();
		
		Runnable myRunnable = new Runnable() {
			public void run() {
				System.out.println("方法四：静态匿名内部类，重写接口Runnable的run函数，对象传入Thread构造函数");
			}
		};
		Thread thread2Thread = new Thread(myRunnable) ;
		thread2Thread.start();
	}

}

//class Thread1 extends Thread{
//	public void run() {
//		System.out.println("方法一：继承Thread类，重写run函数，start函数开启线程");
//	}
//}
//
//class myRunnable implements Runnable{
//	public void run() {
//		System.out.println("方法二：新建类实施Runnable接口，主程序中将相应对象传入Thread构造函数");
//	}
//}