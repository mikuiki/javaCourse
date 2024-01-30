package mThread_yield_join;


// yield 丢弃当前剩余时间片，立马回到调度中心
//public class Entrance {
//
//	public static void main(String[] args) throws InterruptedException {
//		Thread1 thread1 = new Thread1();
//		thread1.start();
//		for(int i=0; i<10; i++) {
//			System.out.println("main-->进程" + i);
//			if(i == 5) {
//				Thread.yield(); // 时间片走完，然后给到调度中心，给其他线程一个机会，
//                              // 但是选择上不一定选中其他线程
//			}
//		}
//
//	}
//
//}


public class Entrance{
	public static void main(String[] args) throws InterruptedException {
		Thread1 thread1 = new Thread1();
		Thread2 thread2 = new Thread2();
		thread1.start();
		thread2.start();
		thread1.join(); // 1. 主线程是产生join的线程，主线程进入阻塞状态；
						// 2. thread1调的join，执行完毕thread1后，开始执行主进程
						// 总结： 会让当前进程（在那个进程中执行出来的）暂停执行，进入就绪状态
						// 只涉及到主线程进入阻塞状态以及主线程什么时候回归
		thread2.join();
		for(int i=0; i<10; i++) {
			System.out.println("main-->进程" + i);
		}
	}
}

class Thread1 extends Thread{
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println("Thread1-->进程" + i);
		}
	}
}
class Thread2 extends Thread{
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println("Thread2-->进程" + i);
		}
	}
}