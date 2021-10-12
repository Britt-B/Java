Brittany Bergeron
README HW5/bonus1+2

Compile Instructions
	Typing "javac *.java" in the HW5 directory should result in a successful compilation 
	of all files in the folder.

Run instructions
	To run the tester, type 
	"java org.junit.runner.JUnitCore SortersTester". The tester should
	complete 4 tests successfully.
Expected resut
	4 tests should pass
	
	selectionSort():
		The general process of selection sort is to pass through the list for each element
		and find minimum value. Each time a new minimum is encountered, it's index is stored.
		after the complete pass, the index of minimum is swapped to the lowest available index
		in the list. On the subsequent iterations, the lowest available index is incremented via
		an outer loop.
	.
	
	mergeSort():
		Merge sort is simple and easy(NOT it actually really sucks I hate it). This portion of the
		will essentially filter out empty lists by not alowing the invokation of the proceeding methods.
		If the list is not empty, it is passed along with it's size to recursiveMergeSortHelper().
	.
	
	recursiveMergeSortHelper():
		The middle of the list is calculated, and each half is distributed into two new lists, provided
		they will be at least 1 element long. The sublists are then passed recursively with their new
		high and low indexes. Once this finishes, the merge() portion is invoked, passing in both halves
		as well as the original list reference.
	.
	
	merge():
		merge() will look at the lowest element in each divided list and compare them. The lower of the two
		will be added into the original list. Once one of the smaller lists run out of elements, the other
		is automatically copied into the end of the original.
	.
	
	indexOf():
		Binary Search requires a pre-sorted list. It will determine the middle index and compare it's element
		to the desired item. If they are equivalent, the index is returned. Otherwise, the new searchable index
		range is adjusted recursively so the lowest/highest value is one index away from the middle, as needed. 
		This process is repeated until either an index is returned or no element is found. In that case, -1 is 
		returned.
	.

***************************************	
Bonus1
Compile Instructions
	Typing "javac *.java" in the HW5/bonus1 directory should result in a successful 
	compilation of all files in the folder.

Run instructions
	To run the tester, type 
	"java org.junit.runner.JUnitCore SortersTester". The tester should
	complete 4 tests successfully.
Expected resut
	4 tests should pass
	
	bubbleSort():
		To halt the bubbleSort algorithm if nothing is swapped, I switched the while loop for a do wile loop. This
		ensures the first iteration of the code. Below swap(), I changed a boolean value to indicate the swap was made.
		When the while conditions are checked, that boolean value determines if the algoritm continues/terminates.
	.
	
***************************************
Bonus2
Compile Instructions
	Typing "javac *.java" in the HW5/bonus2 directory should result in a successful 
	compilation of all files in the folder.

Run instructions
	To run the tester, type 
	"java org.junit.runner.JUnitCore SortersTester". The tester should
	complete 2 tests successfully.
Expected resut
	8 tests should pass
	
	bonus2 required the use of a Comparator parameter in place of requiring T extending Comparable.
	
	SortersTester:
		An anonymous Comparator class was createed that compared two dogs by weight. Because subtracting those
		numbers returns a decimal, integer values must be returned.
		4 new testers were made, using the same logic as the previous ones, but adding a Comparator object as an argument.
	.
	
	Sorters2120:
		Each sorter/searcher was recreated/overloaded using very similar logic.
		T extends Comparable<T> is replaced with <T> to remove the need of Comparable
		swap2() was created to allow the methods to use it considering the same type <T>
		Comparator<T> comp objects are parameters to allow the compare() method
		if(obj1.compareTo(obj2) is essentially replaced with compare(obj1,bj2), eliminating the need for Comparable interface
	.
	