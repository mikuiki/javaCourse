package ListStudying_assign_q3;

import java.util.ArrayList;
import java.util.Iterator;


public class Entrance {
	public static void main(String[] args) {
		ArrayList<String> c = new ArrayList<>();
		c.add("a");
		c.add("b");
		c.add("c");
		c.add("小明");
		
		Iterator<String> it = c.iterator();		
		String cString = "小明";
		
		while(it.hasNext()) {
			String bufString = it.next();
			System.out.println(bufString);
			if(bufString.equals(cString)) {
				it.remove();
			}
		}
		System.out.println(c.size());
	}
}