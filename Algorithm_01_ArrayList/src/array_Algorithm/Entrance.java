package array_Algorithm;

public class Entrance {
	
	public static void main(String[] args) {
		MyArray myArray = new MyArray();
		myArray.insert(0);
		myArray.insert(4);
		myArray.insert(3);
		myArray.insert(2);
		myArray.insert(8);
		myArray.insert(1,1);
		myArray.insert(1,3);
		
		myArray.show();
		
		System.out.println(myArray.length);
		System.out.println(myArray.data.length);
		
	}
}

class MyArray{
	int[] data;
	int length = 0;
	
	MyArray(){
		data = new int[5];
	}
	
	void expand() {
		if(length >= data.length/2) {
			int[] temp = data;
			data = new int[data.length*2];
			for(int i=0; i<length; i++) {
				data[i] = temp[i];
			}
		}
	}
	
	int find(int x) {
		return data[x];
	}
	
	void insert(int x) {
		expand();
		data[length] =x;
		length = length + 1;
		
	}
	
	void insert(int x, int position) {
		expand();
		length++;
		int posTemp = position;
		int temp = data[position];
		int tempnext = 0;
		
		for(int i = position + 1; i < length; i++) {
			tempnext = data[i];
			data[i] = temp;
			temp = tempnext;
			position ++;
		}
		
		data[posTemp] = x;
	}
	
	
	int findPosition(int x) {
		for(int i = 0; i< length; i++) {
			if(data[i] == x) {
				return i;
			}
		}
		return -1;
	}
	
	void show() {
		for(int i=0; i< length; i++) {
			System.out.println(data[i]);
		}
	}
}