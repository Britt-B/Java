import java.io.IOException;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class StudentDatabaseSerializedFileWriter{
	
	private static ObjectOutputStream outputDB;
	/**
	@param outputDB is output stream to be read
	*/
	
	/**
	*openFile converts Sting of file name to object output Stream
	*/
	public static void openFile(String fileName){
		//try to set outputstream to file
		try{
			//fileOutput = new FileOutputStream(fileName);
			outputDB = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)));
		}
		//catch invalid/exception with file
		catch(IOException e){
			System.err.println("Error opening file. Terminating.");
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	/**
	*writeFile takes in a student database and converts it to a csv file
	*/
	public static void writeData(StudentDatabase db){
		//try to convert to OutputStrem
		
		try{
			//try to write Student Database in file
			outputDB.writeObject(db);
		}
		catch(IOException e){
			System.err.println("Error opening file. Terminating.");
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	/**
	*close file stream
	*/
	public static void closeFile() {
        //try to close
		try{
			if (outputDB != null)
			outputDB.close();
		}
		catch (IOException e){
			try {
				outputDB.close();
				if (e instanceof EOFException) {
					System.out.println("Reached end of file, " + e);
				} 
				else{
					e.printStackTrace();
				}
			} 
			catch (IOException e1) {
				e1.printStackTrace();
			}
		}
    }
	
}//end class