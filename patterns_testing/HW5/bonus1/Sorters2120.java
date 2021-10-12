import java.util.ArrayList;
import java.util.List;
import java.lang.Comparable;
public class Sorters2120 {

    public static <T extends Comparable<T> > void bubbleSort(List<T> theList) {
		//check to make sure at least one swap was made
		boolean swapInvoked = false;
		
        int lastToConsider = theList.size();
		//do while guarantees first iteration
        do{
            for (int j=0; j<lastToConsider-1; j++) {
                if (theList.get(j).compareTo(theList.get(j+1))  >  0 ) {
                    swap(theList,j,j+1);
					//to mark swapInvoked as true, swap must have been successful
					swapInvoked = true;
                }
            }
            lastToConsider--;
        }
		//check condition for first swap
		while((lastToConsider > 1) && swapInvoked);
    }

    private static <T extends Comparable<T> > void swap(List<T> theList, int i1, int i2) {

        T temp = theList.get(i1);
        theList.set(i1,theList.get(i2));
        theList.set(i2,temp);
    }
	
	/*
	*selection sort takes i a list, iterates through the elements, and stores the index of the lowest
	*element. This is moved to the first position of the list. The first index is then incremented and
	*the process repeats.
	**/
    public static <T extends Comparable<T> > void selectionSort(List<T> theList) {

        // stubbed
		
		//pass through the list for each element
		//find minimum
		//mov to lowest index(0,1,2...)
		//run through again, starting at next index
		
		//outer loop determines how many times to swap elements (new size of array)
		for(int i=0;i<theList.size()-1;i++){
			//store index of minimum
			int minIndex = i;
			
			//inner loop determines if the swap should be made
			for(int j=i+1; j<theList.size(); j++){
				//if next element is less than this one, set to min value
				if((theList.get(j)).compareTo(theList.get(minIndex)) < 0){
					minIndex = j;
				}
			}
			//when min is determined, set it to the lowest position available
			swap(theList, minIndex, i);
		}

    }
	
	/*
	*mergeSort will first check if the list is not empty. If this is true, it passes the list to recursiveMergeSortHelper
	*along with a first index of zero and the size of the list
	**/
    public static <T extends Comparable<T> > void mergeSort(List<T> theList) {
		if(!theList.isEmpty()){
			recursiveMergeSortHelper(theList,0,theList.size());
		}
    }
	
	/*
	*recursiveMergeSortHelper will determine the middle of a list and split it in half. the two halves are then recursively passed
	*back to the method until the size of the list is 1. The smaller portions are sent to merge()
	**/
    private static <T extends Comparable<T> > void recursiveMergeSortHelper(List<T> theList, int first, int last) {

        // stubbed
		//divide list into two until size is one
		//recursive call merge on each half
		//remerge lists in sorted form
			//compare indexes, increment index only when added back to list	
		
		//middle of list
		int mid = (theList.size()/2);
		//two halves to be processed
		List<T> left = new ArrayList<T>();
		List<T> right = new ArrayList<T>();
		//make sure the list is large enough to be broken down
		if(theList.size()<=1){
			return;
		}
		//copy first portion
		for(int i=0; i<mid; i++){ 
			left.add(theList.get(i));
		}
		//copy second portion
		for(int i=mid; i<theList.size(); i++){ 
			right.add(theList.get(i));
		}
		//recursive calls
		recursiveMergeSortHelper(left,first,mid);
		recursiveMergeSortHelper(right,mid,last);
		//merge lists
		merge(theList,left,right);
	}
	
	/*
	*merge will compare the lowest elements in each broken down list and add them back to the merged one
	**/
	private static <T extends Comparable<T> > void merge(List<T> theList, List<T> left, List<T> right){
		//hold indexes for left, right, and merged
		int i = 0;
		int j = 0;
		int count = 0;
		
		//while both have elements to be added
		while((i < left.size()) && (j < right.size())){
			if(left.get(i).compareTo(right.get(j))<0){
				theList.set(count++,left.get(i++));
			}
			else{
				theList.set(count++,right.get(j++));
			}
		}
		//all right were added, finish left
		while(i < left.size()){
			theList.set(count++,left.get(i++));
		}
		//all left were added, finish right
		while(j < right.size()){
			theList.set(count++,right.get(j++));
		}
    }//end merge

    public static <T extends Comparable<T> > int indexOf(T searchItem, List<T> theList) {
        return recursiveBinarySearcher(searchItem, theList, 0, theList.size()-1);
    }
	
	/*
	*recursiveBinarySearcher will determine a middle index and check if the requested element is in that spot. If it is
	*not, the new search range is adjusted to wither the higher or lower half which is recursively checked. If the element
	*is not found, -1 is returned
	**/
    private static <T extends Comparable<T> > int recursiveBinarySearcher(T searchItem, List<T> theList, int first, int last) {

        // stubbed
		//break in two, decide if value is lower/higher/equal to middle,
		//look at subList, break in two, search...
		//return index of desired element or negative if done w/no index
		
		//holds middle index of list
		int middle = ((last)+first)/2;
		//int low = 0;
		//int high = theList.size()-1; 
		
		if(first <= middle && last >= middle){
		//if we found the element, return the index
			if(searchItem.compareTo(theList.get(middle)) == 0){
				return middle;
			}
			//if lower than middle, recursive with lower half of list
			else if(searchItem.compareTo(theList.get(middle)) < 0){
				int newLast = middle-1;
				return recursiveBinarySearcher(searchItem, theList, first, newLast);
			}
			//if higher than middle, recursive with higher half of list
			else{
				int newFirst = middle+1;
				return recursiveBinarySearcher(searchItem, theList, newFirst, last);
			}
		}
		//If value is not found, return -1
		else{
			return -1;
		}
    }
}
