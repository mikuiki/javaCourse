package queueStudyList;


class Entrance{

	public static void main(String[] args) {
		Myqueue myqueue = new Myqueue();

		myqueue.enqueue(new Unit("WO"));
		myqueue.enqueue(new Unit("WOSHI"));
		myqueue.enqueue(new Unit(1));
		myqueue.enqueue(new Unit(2));
		
		myqueue.show();
		System.out.println(myqueue.dequeue().value);
		myqueue.show();
		System.out.println(myqueue.dequeue().value);
		myqueue.show();
	}	
}

class Unit<T>{
	T value;
	Unit<T> nextT;
	
	Unit(T a){
		this.value = a;
	}
}

class Myqueue<T>{
	
	Unit<T> firstUnit;
	Unit<T> lastUnit;
	int size;
	
	void enqueue(Unit<T> t) {
		if(size == 0) {
			firstUnit = t;
			lastUnit = t;
			size ++;
		}else {
			lastUnit.nextT = t;
			lastUnit = t;
			size ++;
		}
	}
	
	Unit<T> dequeue() {
		if(size == 0) {
			return null;
		}else {
			Unit<T> tempUnit;
			tempUnit = firstUnit;
			firstUnit = firstUnit.nextT;
			size --;
			return tempUnit;
		}
	}
	
	void show() {
		if(size != 0) {
			Unit<T> tempUnit = firstUnit;
			for(int i = 0; i <size; i++) {
				System.out.print(tempUnit.value + "-->");
				tempUnit = tempUnit.nextT;
			}
			System.out.println();
		}
		
	}
	
	
}
