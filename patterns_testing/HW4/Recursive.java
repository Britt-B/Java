//recursive method to compare 2 strings in alpha;
//do not use compareTo()

//import ArrayLists
import java.util.ArrayList;

public class Recursive{
	/* 
	@return compareTo takes two string parameters, determines the order, 
	*and returns a positive, negative, or 0 number
	**/
	public static int compareTo(String s1, String s2){
		
		//handle null strings
		if(s1 == null || s2 == null){
			//both null is equivalent
			if(s1 == s2){
				return 0;
			}
			//the null value comes first otherwise
			else if(s1 == null){
				return -1;
			}
			else{
				return 1;
			}
				
		}
		else{
			//determine order through subtraction	
			int value = s1.charAt(0) - s2.charAt(0);
			
			//base case is when a different value can be determined and order the strings
			if(s1.charAt(0) != s2.charAt(0)){
				return value;
			}
			
			//if end of  one/both strings was reached
			else if((s1.length() == 1) || (s2.length() == 1)){
				//string one ends
				if(s1.length() < s2.length()){
					return -1;
				}
				//string two ends
				else if(s2.length() < s1.length()){
					return 1;
				}
				//both end
				else{
					return 0;
				}
			}
			
			//recursive method with arguments of substring starting at index one 
			//(to check each value in the string)
			else{
				return compareTo(s1.substring(1), s2.substring(1));
			}
		}
	}

	/*
	@return findMinimum is a recursive method that uses compareTo(String, String) 
	*to find min String in array given number of elements
	**/
	public static String findMinimum(ArrayList<String> stringArray){
		
		//if only one string remains, min was found (base case)
		if(1 == stringArray.size()){
			//return only string
			return stringArray.get(0);
		}
		
		else{
			//store number returned by compareTo()
			int numCompare = compareTo(stringArray.get(0), stringArray.get(1));
			//new array list holder
			ArrayList<String> newList = (ArrayList)stringArray.clone();
			//if return was less than 0, the stings are in order
			if(numCompare < 0){
				//take away the "higher value"
				newList.remove(1);
			}
			//if return was greater than 0, the strings are out of order
			//if they are equal, it is irrelevant which one to remove
			else if((numCompare > 0)||(0 == numCompare)){
				//remove "higher value"
				newList.remove(0);
			}
			//find min of new list
			return findMinimum(newList);
		}
	}
	
	
}//end class