import java.io.IOException;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class StudentDatabaseSerializedFileReader{
	
	private static ObjectInputStream inputDB;
	/**
	@param inputDB is intput stream to be read
	*/
	
	/**
	*openFile converts Sting of file name to Object Input Stream and stores it
	*/
	public static void openFile(String fileName){
		//try to set inputstream to file
		try{
			inputDB = new ObjectInputStream(Files.newInputStream(Paths.get(fileName)));
		}
		//catch invalid/exception with file
		catch(IOException e){
			System.err.println("Error opening file. Terminating.");
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	/**
	@return db readData tries to convert ObjectInputStream from filePath to StudentDatabase
	*/
	public static StudentDatabase readData(){
		//initialize database to null
		StudentDatabase db = new StudentDatabase();
		
		try{
			//cast to database and read
			db = (StudentDatabase)inputDB.readObject();
		}
		catch (ClassNotFoundException e){
			e.printStackTrace();
		}
		catch (IOException e){
			try {
				inputDB.close();
				if (e instanceof EOFException) {
					System.out.println("Reached end of file, " + e);
				} else {
					e.printStackTrace();
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		//return student database
		return db;
	}
	
	/**
	*close file stream, filter through possible errors
	*/
	public static void closeFile() {
		//try to close
		try{
			if (inputDB != null)
			inputDB.close();
		}
		catch (IOException e){
			try {
				inputDB.close();
				if (e instanceof EOFException) {
					System.out.println("Reached end of file, " + e);
				} 
				else {
					e.printStackTrace();
				}
			} 
			catch (IOException e1) {
				e1.printStackTrace();
			}
		}
    }
	
}//end class