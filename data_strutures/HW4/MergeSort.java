public class MergeSort<T>{
	
	public static <T extends Comparable<? super T>> void mergeSort(T [] a){
		T [] temp = (T []) new Comparable [a.length];
		mergeSort(a, temp, 0, a.length-1);
	}
	
	private static <T extends Comparable<? super T>> void mergeSort(T [] a, T[] temp, int left, int right){
		if(left<right){
			int center = (left+right)/2;
			mergeSort(a, temp, left, center);
			mergeSort(a, temp, center+1, right);
			merge(a, temp, left, center+1, right);
		}
	}
	
	private static <T extends Comparable<? super T>> void merge(T [] a, T [] temp, int leftPos, int rightPos, int rightEnd){
		int leftEnd = rightPos-1;
		int tempPos = leftPos;
		int numElements = rightEnd-leftPos+1;
		
		while(leftPos <= leftEnd && rightPos <= rightEnd){
			if(a[leftPos].compareTo(a[rightPos])<=0){
				temp[tempPos++] = a[leftPos++];
			}
			else{
				temp[tempPos++] = a[rightPos++];
			}
		}
		
		while(leftPos <= leftEnd){
			temp[tempPos++] = a[leftPos++];
		}
		
		while(rightPos <= rightEnd){
			temp[tempPos++] = a[rightPos++];
		}
		
		for(int i=0; i<numElements; i++, rightEnd--){
			a[rightEnd] = temp[rightEnd];
		}
	}
}