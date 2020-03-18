package homework3;

import java.util.HashMap;
import java.util.Map;

public class Count {
	public static void main(String[] args) {
		Map<String,Integer> record = new HashMap<>();
		for(int i=0;i<args.length;i++) {
			if(record.containsKey(args[i])) {
				int temp = record.get(args[i])+1;
				record.put(args[i], temp);
			}
			else {
				record.put(args[i], 1);
			}
		}
		for(Map.Entry<String, Integer> entry:record.entrySet()){  
		    System.out.println(entry.getKey()+"="+entry.getValue());  
		}  	
	}	
}
