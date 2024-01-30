package linkedData;

public class Entrance {

	public static void main(String[] args) {
			
		LinkedData lData = new LinkedData();
		Unit xUnit = new Unit(5);
		lData.insert(new Unit(0));
		lData.insert(new Unit(1));
		lData.insert(new Unit(2));
		lData.insert(new Unit(3));
		lData.insert(new Unit(4));
		
		lData.insert(xUnit,4);
		System.out.println(lData.lastUnit.x);
		System.out.println(lData.lastUnit.last.x);
		System.out.println("------------");
		
		lData.show();
		System.out.println("------------");
		System.out.println(lData.size);
		System.out.println("------------");
		lData.showFromBack();
		
		
		
	}

}

class Unit{
	
	int x;
	Unit next = null;
	Unit last = null;
	
	Unit(int x){
		this.x = x;
	}
	
}



class LinkedData{
	Unit firstUnit;
	Unit lastUnit;
	int size=0;
	
	
/**
 * find and findPosition时间复杂度分析
 * 
 * @param position
 * @return
 */
	Unit find(int position) {
		if(firstUnit == null || position <0	) 
			return null;
		if(position == 0)
			return firstUnit;
		if(position == size -1) {
			return lastUnit;
		}
		
		
		if(position < size/2) {
			int index = 0;
			Unit nextNode = firstUnit;
			while(nextNode.next != null) {
				nextNode = nextNode.next;
				index ++;
				if(index == position) {
					return nextNode;
				}
			}
		}else {
			int indexBack = size -1;
			Unit lastNodeUnit = lastUnit;
			while(lastNodeUnit.last != null) {
				lastNodeUnit = lastNodeUnit.last;
				indexBack--;
				if(indexBack == position) {
					return lastNodeUnit;
				}
			}
		}
		
		return null;
	}
	
	
/**
 * 
 * @param x
 * @return
 */
	int findPosition(int x) {
		for(int i = 0; i< size; i++) {
			if(x == find(i).x) {
				return i;
			}
		}
		return -1;
	}
	
	
	
	boolean insert(Unit ut, int position) {
		
		if(position < 0 || position >= size) {
			return false;
		}
		
		else if(position == size-1) {
			Unit tempUnit = lastUnit;
			ut.last = lastUnit;
			lastUnit = ut;
			tempUnit.next = ut;
			
		}else if(position == 0){
			Unit tempUnit = firstUnit;
			firstUnit.last = ut;
			firstUnit = ut;
			ut.next = tempUnit;
			
		}else{
			Unit temp = find(position).next;
			find(position).next = ut;
			ut.last = find(position);
			ut.next = temp; 
			temp.last = ut;
		}
		size++;
		return true;
	}
	
	boolean insert(Unit ut) {
		if(size == 0) {
			firstUnit = ut;
			lastUnit = firstUnit;
			size++;
			return true;
		}else {
			Unit lastTempUnit = lastUnit;
			
			lastUnit.next = ut;
			lastUnit = ut;
			ut.last = lastTempUnit;
			size++;
			return true;
		}
		
	}
	
	
	void show() {
		Unit utempUnit = firstUnit;
		for(int i = 0; i<size; i++) {
			System.out.println(utempUnit.x);
			utempUnit = utempUnit.next;
		}
	}
	
	void showFromBack() {
		Unit utLastUnit = lastUnit;
		for(int i=0; i<size; i++) {
			System.out.println(utLastUnit.x);
			utLastUnit = utLastUnit.last;
		}
	}
	
}
