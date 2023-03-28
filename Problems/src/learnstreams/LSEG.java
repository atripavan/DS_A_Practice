package learnstreams;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//list of names
public class LSEG {
	
	public void findAndCountDuplicates(List<String> strList) {
		
		Map<String, Integer> strCounterMap = new HashMap<>();
		for(String s : strList) {			
			Integer count = strCounterMap.getOrDefault(s, 0);
			strCounterMap.put(s, count+1);
		}
		
		Map<String, Long> finalMap = strList.stream().collect(Collectors.groupingBy(String::toString,Collectors.counting()));
		finalMap.forEach((String k, Long v) -> System.out.println(k + " - " + v.toString()));
		/*
		 * for(Entry<String, Integer> e : strCounterMap.entrySet()) {
		 * System.out.println(e.getKey() + " - " + e.getValue()); }
		 */
		
	}

}
