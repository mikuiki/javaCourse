package mt_assign_q11;

public class Entrance {

	public static void main(String[] args) throws InterruptedException {
		Thread2 thread2 = new Thread2();
		thread2.start(); // 子线程2，准备就绪，主程序和子线程2 同时在线程准备间
						// 如果选中子线程2， run()中，新建子线程1，三个线程：主线程，线程1，线程2
						// 如果选中主线程，主线程阻塞，等待线程二执行完毕之后再继续，线程2开启线程1
		thread2.join(); // 走到这一步，线程1 肯定已激活，主线程阻塞，等待线程二完成，线程1，2二选一
						// 选1，则子线程1优先打印
						// 选2，线程2阻塞，等待子线程1打印完才能继续
		for(int i=0; i<10; i++) {
			System.out.println("主线程--" + i);
		}
		
	}

}

class Thread1 extends Thread{
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println("子线程1--" + i);
		}
	}
}

class Thread2 extends Thread{
	public void run() {
		Thread1 thread1 = new Thread1();
		thread1.start();
		try {
			thread1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i =0; i<10; i++) {
			System.out.println("子线程2--" + i);
		}
	}
}