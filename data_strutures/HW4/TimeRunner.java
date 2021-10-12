/*
Purpose: Take N elements, insert into a heap(1 by 1), build heap in linear
		Avoid using integers (bonus)
		
		Compare and provide analysis of run time for inputs:
				sorted
				reverse-ordered
				randomly-ordered
		
		Try range 1k to 10mil
		
		How does timing depend on N, and ordering of data to start?
		
	***upload  analysis as pdf in git repo***
*/

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TimeRunner{
	//array of blankets to load into heap (will be sorted first
	private static Blanket[] blankies;
	private static Blanket[] reversedBlankies;
	private static Blanket[] randomBlankies;
	
	//store average of 10 rounds
	private static long[] averages;
	
	public static void main(String[] args) throws InterruptedException{
		
		System.out.print("Enter Number of Blankets to compare: ");
		//size of array
		Scanner input = new Scanner(System.in);
		int size = input.nextInt();
		
		//make arrays
		blankies = new Blanket[size];
		reversedBlankies = new Blanket[size];
		randomBlankies = new Blanket[size];
		
		averages = new long[6];
	
	//Sorted array
		//make array of blankets
		for(int i=blankies.length-1; i>=0; i--){
			blankies[i] = new Blanket(i);
			//it is convenient to copy the array into random Blankies here
			randomBlankies[i] = new Blanket(i);
		}
		//sort the blankets
		//MergeSort.mergeSort(blankies);
	//Reversed array
		int j = blankies.length-1;
		for(int i=0; i<blankies.length; i++,j--){
			reversedBlankies[i] = blankies[j];
		}
	//Random array
		List<Blanket> blanks = Arrays.asList(randomBlankies);
		Collections.shuffle(blanks);
		randomBlankies = blanks.toArray(new Blanket[randomBlankies.length]);
		
		for (int i = 0; i<10; i++){
			//System.out.println("Execution time in milliseconds: ");
			//run method that tries inserts from the sorted, reversed, random
			inserts();
			//run method that tries builds from the sorted, reversed, random
			builds();
		}
		
		getAverage();
	}
	
	private static void getAverage(){
		for(int i=0; i<averages.length; i++){
			averages[i]/=10;
		}
		System.out.println("- insert/sorted avg:	" + averages[0]);
		System.out.println("- insert/reversed avg:	" + averages[1]);
		System.out.println("- insert/random avg:	" + averages[2]);
		System.out.println("");
		System.out.println("- built/sorted avg:	" + averages[3]);
		System.out.println("- built/reversed avg:	" + averages[4]);
		System.out.println("- built/random avg:	" + averages[5]);
	}
	
	public static void inserts()throws InterruptedException{
		long start,end,msElapsed;
	//sorted
		//create empty heap
		BinaryHeap sortedInsert = new BinaryHeap(blankies.length);
		
		//start time
		start = System.nanoTime();
		//insert one by one
		for(int i=0; i<blankies.length; i++){
			sortedInsert.insert(blankies[i]);
		}
		//end time
		end = System.nanoTime();
		
		//calculate milliseconds
		msElapsed = (end - start) / 1000000;
		averages[0]+= msElapsed;
		//print results
		//System.out.println("- sorted/insert: " + msElapsed);
			
	//reverse ordered
		//create empty heap
		BinaryHeap reversedInsert = new BinaryHeap(reversedBlankies.length);
		
		//start time
		start = System.nanoTime();
		//insert one by one
		for(int i=0; i<blankies.length; i++){
			reversedInsert.insert(reversedBlankies[i]);
		}
		//end time
		end = System.nanoTime();
		
		//calculate milliseconds
		msElapsed = (end - start) / 1000000;
		averages[1]+= msElapsed;
		//print results
		//System.out.println("- reversed/insert: " + msElapsed);
		
	//random ordered
		//create empty heap
		BinaryHeap randomInsert = new BinaryHeap(randomBlankies.length);
		
		//start time
		start = System.nanoTime();
		//insert one by one
		for(int i=0; i<randomBlankies.length; i++){
			randomInsert.insert(randomBlankies[i]);
		}
		//end time
		end = System.nanoTime();
		
		//calculate milliseconds
		msElapsed = (end - start) / 1000000;
		averages[2]+= msElapsed;
		//print results
		//System.out.println("- random/insert: " + msElapsed);
	}
	
	
	public static void builds()throws InterruptedException{
		long start,end,msElapsed;
	//sorted
		//start time
		start = System.nanoTime();
		//build heap
		BinaryHeap sortedBuild = new BinaryHeap(blankies);
		//end time
		end = System.nanoTime();
		
		//calculate milliseconds
		msElapsed = (end - start) / 1000000;
		averages[3]+= msElapsed;
		//print results
		//System.out.println("- sorted/build: " + msElapsed);
			
	//reverse ordered
		//start time
		start = System.nanoTime();
		//build heap
		BinaryHeap reversedBuild = new BinaryHeap(reversedBlankies);
		//end time
		end = System.nanoTime();
		
		//calculate milliseconds
		msElapsed = (end - start) / 1000000;
		averages[4]+= msElapsed;
		//print results
		//System.out.println("- reversed/build: " + msElapsed);
		
	//random ordered
		//start time
		start = System.nanoTime();
		//build heap
		BinaryHeap randomBuild = new BinaryHeap(randomBlankies);
		//end time
		end = System.nanoTime();
		
		//calculate milliseconds
		msElapsed = (end - start) / 1000000;
		averages[5]+= msElapsed;
		//print results
		//System.out.println("- random/build: " + msElapsed);
	}
}