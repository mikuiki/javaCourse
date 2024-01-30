package timeConsumed;

class TimeConsumed{
	public static void main(String[] args) {
		int[] existA = new int[]{1,2,3,4,5,6};
		System.out.println(existA.length);
		
		int value1 = 4;
		int value2 = 7;
		
		MatchedIndex mIndex = new MatchedIndex();
		
		System.out.println(mIndex.matchFuction(existA, value1));
		System.out.println(mIndex.matchFuction(existA, value2));
		
		System.out.println(mIndex.matchBinary(existA, value1));
		System.out.println(mIndex.matchBinary(existA, value2));
		
		int a = 503;
		mIndex.printDigit(a);
	}
}



class MatchedIndex{
	
	int[] arrayInt;
	int index;
	
	int matchFuction(int[] arrayA, int value) {
		
		for(int i =0 ; i< arrayA.length; i++) {
			if(arrayA[i] == value) {
				return i;
			}
		}
		
		return -1;
		
	}
	
	
	int matchBinary(int[] arr, int value) {
		int minIndex = 0;
		int maxIndex = arr.length -1;
		
		while(minIndex <= maxIndex) {
			int middleIndex = (maxIndex+minIndex)/2;
			if(value == arr[middleIndex]) {
				return middleIndex;
			}
			else if(value > arr[middleIndex]) {
				minIndex = middleIndex + 1;
				
			}else {
				maxIndex = middleIndex - 1;
			}
		}
		
		return -1;
	}
	
	void printDigit(int x) {
		
		int buf;
		if(x > 0) {
			buf = x%10;
			System.out.print(buf);
			printDigit(x/10);
		}

	}
}