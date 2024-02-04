package queueStudyArray;

class Entrance{
	public static void main(String[] args) {
		MyArrayQueue mArrayQueue = new MyArrayQueue();
		
		mArrayQueue.enqueue(7);
		mArrayQueue.enqueue(1);
		mArrayQueue.enqueue(2);
		mArrayQueue.enqueue(3);
		mArrayQueue.enqueue(90);
		mArrayQueue.show();
		
		System.out.println("enqueue data: " + mArrayQueue.dequeue());
		System.out.println("enqueue data: " + mArrayQueue.dequeue());
		mArrayQueue.show();
		
		mArrayQueue.enqueue(5);
		mArrayQueue.enqueue(6);
		mArrayQueue.enqueue(7);
		mArrayQueue.show();
		
		mArrayQueue.enqueue(15);
		mArrayQueue.enqueue(11);
		mArrayQueue.show();
		
		System.out.println("enqueue data: " + mArrayQueue.dequeue());
		System.out.println("enqueue data: " + mArrayQueue.dequeue());
		mArrayQueue.show();
		
		mArrayQueue.enqueue(18);
		mArrayQueue.show();
		
		
	}
}

class MyArrayQueue{
	int[] data = new int[5];
	int size = 0;
	
	int firstIndex = 0;
	int lastIndex = 0;
	
	void enqueue(int val) {
		// queue initialization, the first element is enqueue
		if(size == 0) {
			firstIndex = 0;
			lastIndex = 0;
			data[0] = val;
			size ++;
		}
		// queue is full, either firstIndex == 0 or not, the extend function will reorder and enlarge the array
		else if(size == data.length){
			extend();
			// after reorder, add the new element at the end of the queue
			data[data.length - 1] = val;
			lastIndex = data.length -1;
			size ++;
		}
		// queue has capacity, judge the status to see if the cycle has happened, that means lastIndex < firstIndex
		else {
			// when using cycle to store data at the first time, the array has been filled with data and firstIndex is not the data[0]
			if((lastIndex == data.length - 1)&& (firstIndex != 0)) {
				lastIndex = 0;
				data[lastIndex] = val;
				size++;
			// others: lastIndex increment and renew the lastIndex
			}else {
				lastIndex = lastIndex + 1;
				data[lastIndex] = val;
				size++;
			}
		}
		
		
	}
	
	// always pop out the element at place of the firstIndex
	int dequeue() {
		if(size == 0) {
			System.out.println("empty queue");
			return -1;
		}else {
			int temp = data[firstIndex];
			if(firstIndex == data.length -1) {
				firstIndex = 0;
				
			}else{
				firstIndex = firstIndex + 1;
			}
			
			size --;
			return temp;
		}
		
	}
	
	
	// 2 conditions to enlarge the array, both under size == length, than length+1
	// 1.firstIndex refers to data[0], and lastIndex refers to data[length-1];
	// 2.cycle has happened, lastIndex == firstIndex - 1;
	void extend() {		
			int[] dataEx = new int[data.length + 1];
			
			if(lastIndex < firstIndex) {
				int temp = 0;
				for(int i = firstIndex; i < data.length; i++) {
					dataEx[temp] = data[i];
					temp ++;
				}
				for(int j = 0; j <= lastIndex; j++) {
					dataEx[temp] = data[j];
					temp ++;
				}
				
			}else {
				for(int i = 0; i < size; i ++) {
					dataEx[i] = data[i];
					
				}
			}
			firstIndex = 0;
			lastIndex = data.length - 1;
			data = dataEx;
	
	}
	
	void show() {
		System.out.println("the size of the queue is: " + size + "; the length of the array is: " + data.length);
		System.out.print("first of queue is: " + data[firstIndex] + "  ");
		System.out.println("last of queue is: " + data[lastIndex]);
		for(int i = 0; i<data.length; i ++) {
			System.out.print(data[i] + "--");
			
		}
		System.out.println();
		
	}
	
	
}