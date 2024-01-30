package hashMap_course;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Entrance {
	public static void main(String[] args) {
		HashMap<String, Integer> hMap = new HashMap<>();
		Integer h1 = hMap.put("first", 1);
		Integer h2 = hMap.put("Second", 2); 
		Integer h3 = hMap.put("first", 3); // put是有返回值的，如果键已经存在，返回值为原来键值，如果不存在返回null
		
		System.out.println(h1); // null
		System.out.println(h2); // null
		System.out.println(h3); // 返回1
		
//		遍历的方法一：Set生成一个新的对象集合，对象存储键值对的键，然后通过hashmap.get获取到键值对的值，进行遍历
//		关键方法时hashMap.keyset()
//		Set<String> set = hMap.keySet();
//		for(String unit: set) {
//			Integer aInteger = hMap.get(unit);
//			System.out.println(aInteger);
//		}
	
//		遍历方法二：将键值对作为对象存储在set 子类 Map中
//		关键方法时 hashMap.entrySet()
//		Set<Map.Entry<String, Integer>> set = hMap.entrySet();
//		for(Map.Entry<String, Integer>  unit: set) {
//			System.out.println(unit.getKey());
//			System.out.println(unit.getValue());
//		}
		
//		遍历方法三： 迭代器输出
//		Set<Map.Entry<String, Integer>> siSet = hMap.entrySet();
//		
//		Iterator<Map.Entry<String, Integer>> t = siSet.iterator();
//		while(t.hasNext()) {
//			Map.Entry<String, Integer> nextEntry = t.next();
//			System.out.println(nextEntry.getKey());
//			System.out.println(nextEntry.getValue());
//		}
		
		
		
		
	}
}
