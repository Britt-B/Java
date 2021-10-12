import static org.junit.Assert.*;
import org.junit.*;

import java.util.ArrayList;

public class CompareTest{
	//test these strings to account for various cases:
	private static String string1;
	private static String string2;
	private static String string3;
	private static String string4;
	private static String string5;
	private static String string6;
	private static String string7;
	
	private ArrayList<String> stringList = new ArrayList<>();
	
	//instantiate vars
	@Before
	public void setup(){
		//strings to compare
		string1 = "aretha franklin";
		string2 = "madonna";
		string3 = "madonna";
		string4 = "whitney houston";
		string5 = "beyoncé";
		//make sure null is handled correctly
		string6 = null;
		string7 = null;
		
		//add strings to list for compareing array list (null added later)
		stringList.add(string1);
		stringList.add(string2);
		stringList.add(string3);
		stringList.add(string4);
		stringList.add(string5);
	}
	
	//test if comparison method returns expected results
	@Test
	public void compareToTest(){
		//compare in order
		int first = Recursive.compareTo(string1,string2);
		//compare same string values
		int second = Recursive.compareTo(string2,string3);
		//compare out of order
		int third = Recursive.compareTo(string4,string3);
		//cmpare string and null
		int fourth = Recursive.compareTo(string5,string6);
		//compare 2 nulls
		int fifth = Recursive.compareTo(string6,string7);
		
		//assertions
		assertTrue(first < 0);
		assertTrue(second == 0);
		assertTrue(third > 0);
		assertTrue(fourth > 0);
		assertTrue(fourth > 0);
		assertTrue(fifth == 0);
	}
	
	//test if arrayList min finder works
	@Test
	public void compareArrayList(){
		//remove items and test to assure method is working properly
		String result1 = Recursive.findMinimum(stringList);
		
		stringList.remove(0);
		String result2 = Recursive.findMinimum(stringList);
		
		stringList.remove(3);
		String result3 = Recursive.findMinimum(stringList);
		
		stringList.remove(0);
		String result4 = Recursive.findMinimum(stringList);		
		
		stringList.remove(0);
		String result5 = Recursive.findMinimum(stringList);
		
		//add one null element, ensure it is minimum
		stringList.add(string6);
		String result6 = Recursive.findMinimum(stringList);
		
		//add another null element to make sure it doesn't break
		stringList.add(string7);
		String result7 = Recursive.findMinimum(stringList);
		
		//assertions
		assertEquals("aretha franklin", result1);
		assertEquals("beyoncé", result2);
		assertEquals("madonna", result3);
		assertEquals("madonna", result4);
		assertEquals("whitney houston", result5);
		assertEquals(null, result6);
		assertEquals(null, result7);
	}
	
}