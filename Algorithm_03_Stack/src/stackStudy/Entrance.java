package stackStudy;


public class Entrance {

	public static void main(String[] args) {
		
		MyStack myStack = new MyStack();
	
		myStack.insert(0);
		myStack.insert(2);
		myStack.insert(1);
		myStack.insert(3);
		myStack.insert(5);
		myStack.insert(4);
		myStack.show();
		
		myStack.pop();
		myStack.show();
		
		myStack.pop();
		myStack.show();
		
	}

}

class MyStack{
	private int size;
	private int[] myStackContent = new int[5];
	
	private void extendLength(){
		if(size > myStackContent.length /2) {
			int[] data = new int[size * 2];
			for(int i = 0; i< size; i ++) {
				data[i] = myStackContent[i];
			}
			myStackContent = data;
		}
	}
	
	void insert(int x) {
		extendLength();
		myStackContent[size] = x;
		size ++;
	}
	
	int pop() {
		return myStackContent[--size];
	}
	
	void show() {
		for(int i = 0; i< size; i++) {
			System.out.print(myStackContent[i] + "--");
		}
		System.out.println();
	}
}