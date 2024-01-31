package stackStudy_assignment2;

import javax.xml.transform.Templates;

class SingleListStack{
	public static void main(String[] args) {
		MyLinkedList myLinkedList = new MyLinkedList();
		myLinkedList.insert(0);
		myLinkedList.insert(1);
		myLinkedList.insert(2);
		myLinkedList.insert(3);
		myLinkedList.insert(4);
		
		myLinkedList.show();
		
		myLinkedList.pop();
		myLinkedList.show();
		myLinkedList.pop();
		myLinkedList.show();
		myLinkedList.pop();
		myLinkedList.show();
	}
}


class Unit{
	int value;
	Unit nextUnit;
	
	Unit(int value){
		this.value = value;
	}
	
	
}

class MyLinkedList{
	private Unit firstUnit;
	private Unit lastUnit;
	private int size;

	
	void insert(int value) {
		Unit pushUnit = new Unit(value);
		if(size ==0) {
			firstUnit = pushUnit;
			lastUnit = pushUnit;
		}else {
			lastUnit.nextUnit = pushUnit;
			lastUnit = pushUnit;
		}
		size++;
	}
	
	int pop() {
		if(size > 0) {
			size --;
			return lastUnit.value;	
		}else {
			return -1;
		}
	}
	
	void show() {
		Unit tempUnit = firstUnit;
		for(int i =0; i< size; i++) {
			System.out.print(tempUnit.value + "--");
			tempUnit = tempUnit.nextUnit;
		}
		System.out.println();
	}
	
}