package mThread_sleep;

// 抛异常的原因：IOException在sleep的方法体内
public class Entrance {
	public static void main(String[] args) throws Exception {
		String aString = new String("a");
		Thread1 thread1 = new Thread1();
		Thread2 thread2 = new Thread2();
		thread1.setObj(aString);
		thread2.setObj(aString);
		
		thread2.start();
		thread1.start();
		
		for(int i=0; i <1000; i++) {
			System.out.println("main进程" + i);
		}
		

	}

}

class Thread1 extends Thread{
	Object obj;
	
	public void run() {
		synchronized (obj) {
			// 情况一：
			// 如果Thread1先被调度中心选中，进入sleep状态，时间片走完，但是不会释放锁，所以main进程会先打印，然后thread1打印
			// 释放锁之后，thread2开始打印
			// 情况二：
			// Thread2先被调度中心选中，则进程2和主进程交错打印，进程二打印完成之后释放锁，然后进程一开始执行
			try {
				Thread1.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(int i=0; i <100; i++) {
				System.out.println("子线程进程1-->" + i);
			}

		}
	}
	
	void setObj(Object obj) {
		this.obj = obj;
	}
}

class Thread2 extends Thread{
	Object obj;
	
	public void run() {
		synchronized (obj) {
			for(int i=0; i <100; i++) {
				System.out.println("子线程进程2-->" + i);
			}
		}
	}
	
	void setObj(Object obj) {
		this.obj = obj;
	}
}