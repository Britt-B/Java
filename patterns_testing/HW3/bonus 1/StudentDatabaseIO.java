

public class StudentDatabaseIO{
	
	/**
	*reads formatted text StudentDatabase from input file, sorts students, serializes the database to outputFileName
	*/
	public static void formattedToSerialized(String inputFileName, String outputFileName){
		//open
		StudentDatabaseCSVFileReader.openFile(inputFileName);
		//read
		StudentDatabase db = StudentDatabaseCSVFileReader.readData();
		//close file
		StudentDatabaseCSVFileReader.closeFile();
		
		//sort
		db.sortByGPA();
		
		//open
		StudentDatabaseSerializedFileWriter.openFile(outputFileName);
		//write
		StudentDatabaseSerializedFileWriter.writeData(db);
		//close file
		StudentDatabaseSerializedFileWriter.closeFile();
	}
	
	/**
	*reads serilized studentDatabase from input file, sorts students, then writes back out as formatted file
	*/
	public static void serializedToFormatted(String inputFileName, String outputFileName){
		//open
		StudentDatabaseSerializedFileReader.openFile(inputFileName);
		//read
		StudentDatabase db = StudentDatabaseSerializedFileReader.readData();
		//close file
		StudentDatabaseSerializedFileReader.closeFile();
		
		
		//sort
		db.sortByGPA();
		
		//open
		StudentDatabaseCSVFileWriter.openFile(outputFileName);
		//write
		StudentDatabaseCSVFileWriter.writeData(db);
		//close file
		StudentDatabaseCSVFileWriter.closeFile();
		
	}
	
	/**
	*reads formatted studentDatabase from input file, sorts students, then writes back out as formatted file
	*/
	public static void formattedToFormatted(String inputFileName, String outputFileName){
		//open
		StudentDatabaseCSVFileReader.openFile(inputFileName);
		//read
		StudentDatabase db = StudentDatabaseCSVFileReader.readData();
		//close file
		StudentDatabaseCSVFileReader.closeFile();
		
		//sort
		db.sortByGPA();
		
		//open
		StudentDatabaseCSVFileWriter.openFile(outputFileName);
		//write
		StudentDatabaseCSVFileWriter.writeData(db);
		//close file
		StudentDatabaseCSVFileWriter.closeFile();
	}
	
	/**
	*reads serialized studentDatabase from input file, sorts students, then writes back out as serialized file
	*/
	public static void serializedToSerialized(String inputFileName, String outputFileName){
		//open
		StudentDatabaseSerializedFileReader.openFile(inputFileName);
		//read
		StudentDatabase db = StudentDatabaseSerializedFileReader.readData();
		//close file
		StudentDatabaseSerializedFileReader.closeFile();
		
		
		//sort
		db.sortByGPA();
		
		//open
		StudentDatabaseSerializedFileWriter.openFile(outputFileName);
		//write
		StudentDatabaseSerializedFileWriter.writeData(db);
		//close file
		StudentDatabaseSerializedFileWriter.closeFile();
		
	}
	
}//end class