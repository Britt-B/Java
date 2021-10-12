//imports
import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class BallClockRunner{

	public static void main(String[] args){
		
		try{
			File textFile = new File("input.txt");
			//create scanner
			Scanner input = new Scanner(textFile);
			
			//cycle each line in text file
			while(input.hasNextLine()){
				//store next integer to calculate from file
				int nextNumber = Integer.parseInt(input.nextLine());
				if(nextNumber != 0){
					//make a ball clock with integer
					BallClock clock = new BallClock(nextNumber);
					//calculate number of repititions
					int total = clock.startClock();
					//print results
					System.out.println(nextNumber + " balls cycle after " + total + " days.");
				}
			}
		}
		//IO exception handler
		catch(IOException e){
			//problem with file
			System.out.println("Check file input");
			e.printStackTrace();
		}
	
	}
}