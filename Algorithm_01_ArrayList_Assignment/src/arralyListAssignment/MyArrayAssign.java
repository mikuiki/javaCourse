package arralyListAssignment;

import java.util.ArrayList;
import java.util.Iterator;

public class MyArrayAssign{
	
	public static void main(String[] args) {
		MyArray myArray = new MyArray();
		
		myArray.insert(0, 0);

		System.out.println("--------------");
		myArray.endInsert(1);

		myArray.endInsert(2);

		myArray.endInsert(3);

		myArray.insert(2, 4);
		myArray.show();

		

		
		MyIterator myIterator = new MyIterator(myArray);
		
		while(myIterator.hasNext()) {
			
			int x = myIterator.next();
			if(x == 0) {
				myIterator.itRemove();
			}
		}
		
		myArray.show();
		
	}
}


class MyArray{
	
	int[] my_arr;
	int arrLength;
	
	public MyArray() {
		// TODO Auto-generated constructor stub
		my_arr = new int[5];
	}
	
	void expand() {
		if(arrLength > my_arr.length/2) {
			int[] newArray = new int[arrLength*2];
			for(int i = 0; i< arrLength; i++) {
				newArray[i] = my_arr[i];
			}
			my_arr = newArray;
			
		}
	}
	
	boolean insert(int position, int value) {
		expand();
		if(position < 0) {
			return false;
		}else if(position < arrLength - 1){
			arrLength ++;
			int temp = my_arr[position];
			int tempNext;
			
			for(int i = position; i< arrLength -1; i++) {
				tempNext = my_arr[i + 1];
				my_arr[i + 1] = temp;
				temp = tempNext;
			}
			
			my_arr[position] = value;
			
		}else {
			endInsert(value);
			System.out.println("position out of range, insert to the end of the array");
		}
		return true;
	}
	
	boolean endInsert(int value) {
		expand();
		arrLength++;
		my_arr[arrLength - 1] = value;
		return true;
	}
	
	void show() {
		for(int i =0; i< arrLength; i++) {
			System.out.print(my_arr[i]);
			
		}	
		System.out.println();
//		System.out.println(my_arr.length);
	}
	
	int valueOfIndex(int x) {
		if(x < arrLength) {
			
			return my_arr[x];
		}else {
			return -1;
		}
		
	}
	
	int indexOfValue(int value) {
		for(int i =0; i< arrLength; i++) {
			if(my_arr[i] == value) {
				System.out.println("the first appear index is " + i);
				return i;
			}
		}
		System.out.println("not found");
		return -1;
	}
	
	
	void endRemove() {
		if(arrLength > 0) {
			arrLength --;
		}else {
			System.out.print("empty, cannot remove element");
		}

	}
	
	void removePosition(int position) {
		if(position < arrLength) {
			
			for(int i = position; i < arrLength -1; i ++) {
				my_arr[i] = my_arr[i + 1];
			}
			arrLength --;
		}else {
			endRemove();
		}
	}
}

class MyIterator{
	MyArray myArr;
	int pointer;
	
	public MyIterator(MyArray a) {
		// TODO Auto-generated constructor stub
		this.myArr = a;
	}
	
	boolean hasNext() {
		if(pointer >= myArr.arrLength) {
			return false;
		}else {
			return true;
		}
	}
	
	int next() {
		return myArr.valueOfIndex(pointer++);
	}
	
	void itRemove() {
		myArr.removePosition(pointer-1);
	}
}