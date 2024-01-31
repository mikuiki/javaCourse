package linkedData;

class Entrance{
	public static void main(String[] args) {
		Unit aUnit = new Unit(1);
		MyLinked myLinked = new MyLinked();
		myLinked.firstUnit = aUnit;
		myLinked.endInsert(new Unit(4));
		myLinked.endInsert(new Unit(5));
		myLinked.endInsert(new Unit(6));
		myLinked.endInsert(new Unit(6));
		myLinked.endInsert(aUnit);
		myLinked.endInsert(new Unit(2));
		myLinked.show();
		myLinked.positionInsert(new Unit(7), 0);
		myLinked.show();
		
		myLinked.positionRemove(2);
		myLinked.show();
		
		int loc = myLinked.findPosition(aUnit);
		System.out.println(loc);
//		
//		MyIterator myExIterator = new MyIterator(myLinked);
//		while(myExIterator.hasNext()) {
//			
//			System.out.print(myExIterator.next().UnitValue);
//		}
		
		myLinked.linkReverse();
		myLinked.show();
		
	}
}



class Unit{
	int UnitValue;
	Unit nextUnit = null;
	
	Unit(int x){
		this.UnitValue = x;
	}
}

class MyLinked{
	Unit firstUnit;
	Unit lastUnit;
	int size;
	
	void endInsert(Unit x) {
		if(size == 0) {
			firstUnit = x;
			lastUnit = x;
		}else {
			lastUnit.nextUnit = x;
			lastUnit = x;
		}
		size++;	
	}
	
	void positionInsert(Unit x, int position) {
		if(position == 0) {
			x.nextUnit = firstUnit;
			firstUnit = x;
		}else if(position >= size) {
			lastUnit.nextUnit = x;
			lastUnit = x;
		}else {
			Unit tempUnit = findUnit(position);
			findUnit(position - 1).nextUnit = x;
			x.nextUnit = tempUnit;
		}
		size ++;
	}
	
	void endRemove() {
		if(size > 0) {
			lastUnit = findUnit(size - 1);
			size --;
		}
	}
	
	void positionRemove(int position) {
		if(position ==0) {
			firstUnit = firstUnit.nextUnit;	
			size --;
		}else if(position >= size) {
			System.out.println("no such position");
		}else if(position == size -1){
			endRemove();
		}else {
			findUnit(position -1).nextUnit = findUnit(position + 1);
			size --;
		}
	}
	
	void show() {
		Unit tempUnit;
		tempUnit = firstUnit;
		for(int i =0; i<size; i++) {
			System.out.print(tempUnit.UnitValue + "--->");		
			tempUnit = tempUnit.nextUnit;
			
		}
		System.out.println();
	}
	
	Unit findUnit(int x) {
		
		Unit tempUnit = firstUnit;
		for(int i = 0; i<x; i++) {
			tempUnit = tempUnit.nextUnit;
		}
		return tempUnit;	
	}
	
	int findPosition(Unit x) {
		Unit tempUnit = firstUnit;
		for(int i = 0; i< size; i++) {
			if(tempUnit.equals(x)) {
				return i;
			}
			tempUnit = tempUnit.nextUnit;
		}
		return -1;
	}
	
	void linkReverse() {
		Unit tempUnitFirst = lastUnit;
		Unit tempUnit = lastUnit;

		for(int i = 0; i< size - 1; i++) {
			Unit nexTempUnit = findUnit(findPosition(tempUnit)-1);
			tempUnit.nextUnit = nexTempUnit;
			tempUnit = nexTempUnit;
		}
		lastUnit = tempUnit;
		firstUnit = tempUnitFirst;
		
		
	}
	
}

class MyIterator{
	int pointer = 0;
	MyLinked myLinked;
	
	public MyIterator(MyLinked a) {
		// TODO Auto-generated constructor stub
		this.myLinked = a;
	}
	
	boolean hasNext() {
		if(pointer < myLinked.size) {
			return true;
		}else {
			return false;
		}
	}
	
	Unit next() {
		Unit tempUnit = myLinked.findUnit(pointer);
		pointer++;
		return tempUnit;
	}
}