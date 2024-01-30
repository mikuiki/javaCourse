package hashMap_assign_q1;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Entrance {

	public static void main(String[] args) {
		HashMap<String, Integer> hMap = new HashMap<>();
		
		hMap.put("first", 1);
		hMap.put("Second", 2);
		hMap.put("Third", 3);
		
//		方法一
//		Set<String> keySet = hMap.keySet();
//		for(String unit:keySet) {
//			System.out.println(unit);
//			System.out.println(hMap.get(unit));
//		}
		
//		方法二
		Set<Map.Entry<String, Integer>> sEntries = hMap.entrySet();
		for(Map.Entry<String, Integer> unitEntry : sEntries) {
			System.out.println(unitEntry.getKey());
			System.out.println(unitEntry.getValue());
		}

	}

}
