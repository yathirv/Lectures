package lectures;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class hashMap {

	public static void main(String[] args) { // TODO Auto-generated method stub

		HashMap<Integer, String> hm = new HashMap<Integer, String>();
//		Hashtable<Integer, String> ht = new Hashtable<Integer, String>();
		hm.put(0 , " hello");
		hm.put(1 , "gudbye");
		hm.put(2 , " sunShine");
		hm.put(4 , "Morning");
		hm.put(3 , "evening");
		
		System.out.println(hm.get(4));
		hm.remove(4);
		System.out.println(hm.get(4));
		Set<?> sn = hm.entrySet();
		Iterator<?> it = sn.iterator(); 
		
//		hashtable -pass table set collections
		while(it.hasNext())
		{
	
		System.out.println(it.next()); // 0 2
		
		@SuppressWarnings("unchecked")
		Map.Entry<Integer, String> mp = (Map.Entry<Integer, String>) it.next(); // 1 3
		System.out.println("Key :" + mp.getKey());
		System.out.println("Value :" + mp.getValue());
		}

	}
}
