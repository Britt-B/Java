Brittany Bergeron README

Compile Instructions
	Typing "javac *.java" in the HW3 directory should result in a successful compilation 
	of all files in the folder.

Run instructions
	To run the tester, type 
	"java org.junit.runner.JUnitCore StudentDatabaseConversionTester". The tester should
	complete all 6 tests successfully.
Expected resut
	6 tests should pass, and corresponding csv, ser, and excel files should be created


Breakdown of code written by student (that's me!)
	StudentDatabaseSerializedFileReader:
		This class is meant to open an existing file, read data from it, and return a
		StudentDatabase object.
		The openFile() method will use the name of a file to find
		it's path. This is converted to an input stream, which can be converted again to
		an object input stream. This stream is stored for use. If the file is invalid/ an
		exception occurs, it is caught and the system will exit.
		The readData() method will attempt to read the object input stream previously
		stored and store a new StudentDatabase object. Catch blocks will handle the case
		a class is not found or an IO exception occurs. The new StudentDatabase object
		is returned.
		The closeFile() method will attempt to close the file stream, printing the stack
		trace when it fails.
		
	StudentDatabaseSerializedFileWriter:
		This class works in  very similar manner to the reader file. While the read 
		class took read a file and returned a database, the write class takes in a 
		database and returns a file. The openFile() and closeFile() are identical if the 
		object input stream is replaced with an object output stream. writeData() is what 
		distinguishes these two classes. The method attempts to write the given
		StudentDatabase to the object output stream. IO exception is caught, the
		stackTrace is printed, and the system exits.
		
	
	StudentDatabaseIO:
		The StudentDatabaseIO is meant to handle the reading, writing, and sorting of 
		files and databases. It is capable of formattedToSerialized() and 
		serializedToFormatted(). Each one will call it's static methods respecting the type 
		of conversion specified in the following process:
		openFile(inputFileName)
		store readData() in a StudentDatabase
		closeFile()
		sort the stored database
		openFile(outputFileName)
		writeData(database)
		closeFile()
		
	StudentDatabaseCSVFileWriter:
		Although the majority of this code was provided, a few things needed to be completed.
		The header format was not present in the code, so it was placed before the for loop
		that iterates through each student. This ensures that everything lines up correctly.
		The student name must be arranged correctly, so a full name was created. Because the
		file is seperated by commas, a \ must be used to place a comma in the name. After this,
		each piece of data is matched with it's respective format type. A new line is then set 
		for the next entry in the loop to begin.
		
	StudentDatabaseConversionTester:
		The testers will open CSV/Serialized Files, read them, close them, reopen them in a
		CSV/Serialized format, and repeat the process. The student databases are stored and
		tested for equality. Assuming all the code is written correctly, all tests will pass
		without issues.
		
Bonus 1:
	compile: 	javac *.java
	run:		java org.junit.runner.JUnitCore StudentDatabaseConversionTester
	result:		8 tests should pass, and corresponding csv, ser, and excel files should be created
	
	For bonus one, Formatted to formatted and serialized to serialized methods were implemented
	in the StudentDatabaseIO class. The methods will open, read/write, close, and sort csv/ser 
	files respectively.
	Two testers were added to the junit tester; One is strictly .csv files and the other is 
	strictly .ser. Each one will directly invoke open,read/write, and close methods. The
	studentDatabase objects are sorted and stored, the IO class handles the files to sort and
	store the objects in a seperate database, and the two objects are compared.
	
Bonus 2:
	compile: 	javac *.java
	run:		java org.junit.runner.JUnitCore StudentDatabaseConversionTester
	result:		4 tests should pass, and corresponding csv, ser, and excel files should be created
	
	For bonus two, SortStudentDatabse class was added, and a new junit tester was created.
	
	SortStudentDatabse:
		This class is meant to take in a file name. Given the file, a substring of the last four
		characters is created. If the string equals .csv or .ser, corresponding input/output boolean
		values are given the value true. Otherwise, an error ccurs and the system will ezit. The
		booleans are checked in if/else statements to determine the proper methods to send the file
		names to (in the StudentDatabaseIO class).
	
	StudentDatabaseConversionTester:
		The tester is made so each test will create a .ser and/or .csv file directly through the 
		CSVFile/SerializedFile reader and writer classes. This is used strictly for comparison purposes. 
		These files are converted and stored in databases, which can be compared to other databases 
		created by using the SortStudentDatabase.sortFileByType() method.
	