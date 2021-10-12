
/****************************************
Input: 1 integer that states how many swaps, /n, 2 chars that were swapped, /n ... string text inputted by Jill

Output: fixed text

Assume: only letters swapped, affects upper and lower case

****************************************/
//imports
import java.io.IOException;
import java.io.File;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.Scanner;

public class JackEffedUp{
	
	//letters to be swapped
	private static char[] swaps;
	//message taken in to decipher
	private static String message;
	//alphabet to analyze (hash table)
	private static int[] alphabet;

	public static void main(String[] args){
		try{
			//scan input file
			File textFile = new File("input.txt");
			
			//create scanner
			Scanner input = new Scanner(textFile);
			
			//set size of swaps in array
			int numberOfSwaps = 0;
			
			//ensure first input is integer
			numberOfSwaps = Integer.parseInt(input.nextLine());
			
			//use number of swaps * 2 to determine size of swaps[]
			swaps = new char[numberOfSwaps*2];

			//cycle each line in text file
			for(int i=0; i<=numberOfSwaps; i+=2){
				//char, space, char
				String line = input.nextLine();
				
				//take in each swap, placing into an array (Upper case value)
				swaps[i] = Character.toUpperCase(line.charAt(0));
				swaps[i+1] = Character.toUpperCase(line.charAt(2));
				
				//make sure only 2 chars per line	
				if(line.length() > 3){
					System.out.print("Too many characters");
					throw new Exception();
				}
				
				if(!input.hasNext()){
					System.out.print("Not enough lines in text");
					throw new Exception();
				}
			}
			
			//take final string and convert to char array, if no next not enough lines
			if(input.hasNext()){
				message = input.nextLine();
			}
			/*else{
				System.out.print("Not enough lines in text");
				throw new Exception();
			}
			*/
			//more lines than expected
			//should not have next, if it does throw error
			if(input.hasNext()){
				System.out.print("Too many lines in text file");
				throw new Exception();
			}
			
			//close scanner
			input.close();
			
			//commence operation "fix the problem"
			setup();
			String fixed = fixMessage();
			//System.out.println(fixed);
		}
		//IO exception handler
		catch(IOException e){
			//problem with file
			System.out.println("Check file input");
			//e.printStackTrace();
		}
		catch(NumberFormatException n){
			System.out.print("NumberFormatException");
		}
		catch(Exception e){
		//all catch
		}
	}
	
	
	private static void setup(){
		//assign prime array; 26 upper + 26 lower = 52; 59 is prime
		alphabet = new int[59];
		
		//fill alphabet array with caps
		for(int i=0; i<26; i++){
			char next = 'A';
			next = (char)(i+65);
			alphabet[hashItOut(next)] = next;
			next = (char)(next++);
		}
		//fill alphabet array with lowercase
		for(int i=0; i<26; i++){
			char next = 'a';
			next = (char)(i+97);
			alphabet[hashItOut(next)] = next;
			next = (char)(next++);
		}
		
		//switch values; swaps[n] <--> swaps[n+1]
		for(int i=0; i<swaps.length; i+=2){
			//find index to place in alphabet by getting the hash value of the letter to swap
			//assign the element in i to i+1, and i+1 to i
			
			char swap1 = swaps[i];
			char swap2 = swaps[i+1];
			
			alphabet[(hashItOut(swap1))] = swap2;
			alphabet[(hashItOut(swap2))] = swap1;
			
			//now, do the same for lower case (lower = caps + 32)
			
			
			alphabet[(hashItOut((char)(swap1+32)))] = Character.toLowerCase(swap2);
			alphabet[(hashItOut((char)(swap2+32)))] = Character.toLowerCase(swap1);
		}
	}
	
	
	
	//hash function that converts input to ascii numerical value % table size for indexx
	private static int hashItOut(char c){
		return (int)c%alphabet.length;
	}
	
	
	public static String fixMessage(){
		//String Buffer
		StringBuffer sb = new StringBuffer("");
		
		//iterator to deal with string
		StringCharacterIterator iter = new StringCharacterIterator(message);
		
		//hold new character index to replace
		int newIndex = -1;
		//while iterator has not ended
		while(iter.current() != CharacterIterator.DONE){
			//add spaces
			if(iter.current() == ' '){
				sb.append(" ");
			}
			//find the index via hash function, replace current char in message with appropriate
			else{
				newIndex = hashItOut(iter.current());
				sb.append((char)alphabet[newIndex]);
			}
			//next char in string
			iter.next();
		}
		//return new message
		return sb.toString();
	}
	
}