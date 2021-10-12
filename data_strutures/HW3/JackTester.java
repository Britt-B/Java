import static org.junit.Assert.*;
import org.junit.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;

//To test the hashcode swap in JackEffedUp
public class JackTester{

	//test fixture; declare private variables 
	private BufferedWriter bw;
	private BufferedWriter bwCheck;
	
	private BufferedReader br;
	
	private File file;
	private File fileCheck;
	
	private ByteArrayOutputStream bos;
	
	
	//create several test objects
	@Before
	public void setup(){
		//create file and second to hold big input
		try{
			file = new File("input.txt");
			bw = new BufferedWriter(new FileWriter(file));
			
			fileCheck = new File("inputCheck.txt");
			bwCheck = new BufferedWriter(new FileWriter(fileCheck));
		}
		catch(IOException e){
			//problem with file
			System.out.println("Check file input");
			e.printStackTrace();
		}
		
		//setup system error stream to check
		bos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(bos));
	}

	//mix of upper/lower cases and spaces in message
	@Test
	public void testUpperLowerSpaces(){
		try{
			//2 swaps
			bw.write("2");
			bw.newLine();
			//upper and lowercase
			bw.write("A b");
			bw.newLine();
			bw.write("C d");
			bw.newLine();
			//odd sequence
			bw.write("a Bc D");
			bw.close();
		}
		catch(IOException e){
			//problem with file
			System.out.println("Check file input");
			e.printStackTrace();
		}
		
		//setup jack class (make hash tables, strings, etc)
		JackEffedUp.main(null);
		//check for expected output
		assertEquals("b Ad C", JackEffedUp.fixMessage());
	}
	
	//test to make sure nonvalid input is not passed in
	@Test
	public void testNonvalid(){
		//A should throw exception(doesn't parse to int)
		try{
			bw.write("A");
			bw.newLine();
			bw.close();
			
			//try to run
			JackEffedUp.main(null);
			assertEquals("NumberFormatException", bos.toString());
			bos.close();
		}
		catch(IOException e){
			//problem with file
			//System.out.println("Check file input");
			e.printStackTrace();
		}
	}
	
	//test too many swaps on one line
	@Test
	public void testTooManyLetters(){
		try{
			bw.write("4");
			bw.newLine();
			bw.write("A B C D");
			bw.newLine();
			bw.write("E F G H");
			bw.close();
			
			//try to run
			JackEffedUp.main(null);
			assertEquals("Too many characters", bos.toString());
			bos.close();
		}
		catch(IOException e){
			//problem with file
			System.out.println("Check file input");
			e.printStackTrace();
		}
	}
	
	//test too many swaps on one line
	@Test
	public void testTooManySwaps(){
		//declared one swap when there are two
		try{
			bw.write("1");
			bw.newLine();
			bw.write("A B");
			bw.newLine();
			bw.write("C D");
			bw.newLine();
			bw.write("A B C D");
			bw.close();
			
			//try to run
			JackEffedUp.main(null);
			assertEquals("Too many lines in text file", bos.toString());
			bos.close();
		}
		catch(IOException e){
			//problem with file
			System.out.println("Check file input");
			e.printStackTrace();
		}
		//try to run
		JackEffedUp.main(null);
	}
	
	//test not enough swaps on one line
	@Test
	public void testNotEnoughSwaps(){
		try{
			//expected 5 when there are 2
			bw.write("5");
			bw.newLine();
			bw.write("A B");
			bw.newLine();
			bw.write("C D");
			bw.close();
			
			//try to run
			JackEffedUp.main(null);
			assertEquals("Not enough lines in text", bos.toString());
			bos.close();
		}
		catch(IOException e){
			//problem with file
			System.out.println("Check file input");
			e.printStackTrace();
		}
		//try to run
		JackEffedUp.main(null);
	}

	//big file input (check 5 mil letter swaps)
	@Test
	public void testBigInput(){
		//store correct value after swap to check
		String checked = "";
		
		try{
			//swap two letters; A and Z
			bw.write("1");
			bw.newLine();
			bw.write("A Z");
			bw.newLine();
			//sequence of 2.5 mil a's and 2.5 mil z's (lowercase)
			for(int i=1; i<2500000; i++){
				bw.write("a z");
			}
			//close writer
			bw.close();
			
			//recreate correct answer to check
			bwCheck.write("1");
			bwCheck.newLine();
			bwCheck.write("A Z");
			bwCheck.newLine();
			//this time swap a and z
			for(int i=1; i<2500000; i++){
				bwCheck.write("z a");
			}
			//close writer
			bwCheck.close();
			
			//new buffered reader to get string from file
			br = new BufferedReader(new FileReader(fileCheck));
			//take off num swaps and letters to swap
			br.readLine();
			br.readLine();
			//store resulting string
			checked = br.readLine();
			//close reader
			br.close();
			
		}
		catch(IOException e){
			//problem with file
			System.out.println("Check file input");
			e.printStackTrace();
		}
		
		//try to run
		JackEffedUp.main(null);
		//check stored string to return from swap method
		assertEquals(JackEffedUp.fixMessage(), checked);
	}

}//end class