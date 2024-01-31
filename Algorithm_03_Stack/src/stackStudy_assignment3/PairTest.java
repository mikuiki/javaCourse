package stackStudy_assignment3;


class PairTest{

    public static void main(String[] args) {
    	
    	ValidPair vPair = new ValidPair();
        String example1 = "{[()]()}";
        String example2 = "()]";
        
        System.out.println("Example 1 is valid: " + vPair.isValidPair(example1));
        System.out.println("Example 2 is valid: " + vPair.isValidPair(example2));
    }
}

class ValidPair{
	
	MyStack charteStack = new MyStack();
	
	boolean isValidPair(String input) {
		for(char eachChar : input.toCharArray()) {
			
			if(eachChar == '(' || eachChar == '{' || eachChar == '[' ) {
				
				charteStack.insert(eachChar);
			
			}else if(eachChar == ')' || eachChar == '}' || eachChar == ']' ) {
				
				if(charteStack.size > 0) {
					char temp = charteStack.pop();
					if((temp == '[' && eachChar == ']') || 
					   (temp == '{' && eachChar == '}') || 
					   (temp == '(' && eachChar == ')')) {
						continue;
						
					}else {
						return false;
					}
				}else {
					return false;
				}
			}
		}
		return true;
	}
}

class MyStack{
	int size;
	private char[] myStackContent = new char[5];
	
	private void extendLength(){
		if(size > myStackContent.length /2) {
			char[] data = new char[size * 2];
			for(int i = 0; i< size; i ++) {
				data[i] = myStackContent[i];
			}
			myStackContent = data;
		}
	}
	
	void insert(char x) {
		extendLength();
		myStackContent[size] = x;
		size ++;
	}
	
	char pop() {
		return myStackContent[--size];
	}
	
	void show() {
		for(int i = 0; i< size; i++) {
			System.out.print(myStackContent[i] + "--");
		}
		System.out.println();
	}
}
