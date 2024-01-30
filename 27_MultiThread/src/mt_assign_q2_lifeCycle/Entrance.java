package mt_assign_q2_lifeCycle;

public class Entrance{
	public static void main(String[] args) {
		Test t1=new Test();
		Test t2 = new Test();
		MyThread myThread1=new MyThread();
		MyThread myThread2=new MyThread();
		myThread1.setTest(t1);
		myThread2.setTest(t2);
		myThread1.start();
		myThread2.start();
	}
}

class Test{
	void test(){
		synchronized(this){
			for(int i=0;i<10;i++){
				System.out.println("test方法中synchronized修饰的代码块-->" + i);
			}
		}
	}	
}

class MyThread extends Thread{
	private Test t;
	
	void setTest(Test t){
		this.t=t;
	}
	public void run(){
		t.test();
	}
}
