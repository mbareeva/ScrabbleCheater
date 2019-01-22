package util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubSets {
	
	
	public static Set<String> getSubSets(String str) {
		Set<String> mainSet = new HashSet<>();
		//add all the letters from str to the main set
		for(int i = 0; i < str.length(); i++)
			mainSet.add(Character.toString(str.charAt(i)));
		
		//create list of set elements to retrieve elements later in loop:
		List<String> s = new ArrayList<String>(mainSet);
		
		//the amount of subsets of a given set
		long subsetSize = (long) Math.pow(2, str.length());
		
		//set to store subsets
	//	Set<Set<String>> subsets = new HashSet<>();
		
		int counter, j;
		Set<String> subs = new HashSet<>();
		//generate each subset 1 by 1:
		for(counter = 0; counter <  subsetSize; counter++) 
        { 
		String subset = "";
			//bit implementation
            for(j = 0; j < str.length(); j++) 
            { 
                /* Check if j-th bit in the  
                counter is set If set then  
                print jth element from set */
                if((counter & (1 << j)) > 0) 
                 subset += s.get(j); 
            }
            subs.add(subset);
        }
		return subs;	      
    } 
}

