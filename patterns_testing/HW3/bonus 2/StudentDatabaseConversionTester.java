import static org.junit.Assert.*;
import org.junit.*;
import java.io.File;
import java.io.IOException;

public class StudentDatabaseConversionTester{

    @BeforeClass
    public static void buildARandomDatabase() {

        ProcessBuilder cleanup = new ProcessBuilder("rm","*.ser","*.csv");
        try {
            Process p = cleanup.start();
            p.waitFor();
        } catch (InterruptedException e) {
            System.err.println("Clean up process interrupted.");
            System.err.println("Manually remove all .csv and .ser files or indeterminate results may occur.");
        } catch (IOException e) {
            System.err.println("error in cleanup");
        }
    
        ProcessBuilder generate = new ProcessBuilder("java", "MakeRandomStudents", "19");
        File log = new File("studentJUnitTestData.csv");
        generate.redirectErrorStream(true);
        generate.redirectOutput(ProcessBuilder.Redirect.appendTo(log));
        try {
            Process p = generate.start();
            p.waitFor();
        } catch (InterruptedException e) {
            System.err.println("Random Student Generation process interrupted. Return.");
        } catch (IOException e) {
            System.err.println("error starting external process");
        }
		
    }
	
	/*
	*Test and compare sortFileByType csv -> csv
	*/
    @Test
    public void testReadFromCSVThenWriteToCSV() {

		//set up csv files to read/compare to
		StudentDatabaseCSVFileReader.openFile("studentJUnitTestData.csv");
        StudentDatabase db = StudentDatabaseCSVFileReader.readData();
        StudentDatabaseCSVFileReader.closeFile();
		
		//sort
		db.sortByGPA();
		
		//pass in two files to be handled by SortStudentDatabase
		SortStudentDatabase.sortFileByType("studentJUnitTestData.csv", "studentJUnitTestData_out1.csv");
		
		//read to object for comparison
		StudentDatabaseCSVFileReader.openFile("studentJUnitTestData_out1.csv");
        StudentDatabase db2 = StudentDatabaseCSVFileReader.readData();
        StudentDatabaseCSVFileReader.closeFile();
		
        
         // now compare the two databases
         assertEquals(db.getNumStudents(), db2.getNumStudents());
         for (int i=0; i<db.getNumStudents(); i++) {
            Student s1 = db.getStudent(i);
            Student s2 = db2.getStudent(i);
            assertEquals(s1.getStudentID(),s2.getStudentID());
            assertEquals(s1.getSex(),s2.getSex());
            assertEquals(s1.getEthnicGroup(),s2.getEthnicGroup());
            assertEquals(s1.getFirstName(),s2.getFirstName());
            assertEquals(s1.getLastName(),s2.getLastName());
            assertEquals(s1.getMiddleInitial(),s2.getMiddleInitial());
            assertEquals(s1.getProgram(),s2.getProgram());
            assertEquals(s1.getAcademicPlan(),s2.getAcademicPlan());
            assertEquals(s1.getSubPlan(),s2.getSubPlan());
            assertEquals(s1.getStrtLevel(),s2.getStrtLevel());
            assertEquals(s1.getTotal(),s2.getTotal(),0.01);
            assertEquals(s1.getGPA(),s2.getGPA(),0.01);
            assertEquals(s1.getFAFSA(),s2.getFAFSA());
            assertEquals(s1.getTakePrgrs(),s2.getTakePrgrs(),0.01);
            assertEquals(s1.getFinancialNeed(),s2.getFinancialNeed(),0.01);
         }
		 
    }
	
	/*
	*Test and compare sortFileByType csv -> ser
	*/
	@Test
    public void testReadFromCSVThenWriteToSerialized() {
		//set up csv files to read/compare to
		StudentDatabaseCSVFileReader.openFile("studentJUnitTestData.csv");
        StudentDatabase db = StudentDatabaseCSVFileReader.readData();
        StudentDatabaseCSVFileReader.closeFile();
		
		//sort
		db.sortByGPA();
		
		//pass in two files to be handled by SortStudentDatabase
		SortStudentDatabase.sortFileByType("studentJUnitTestData.csv", "studentJUnitTestData_out2.ser");
		
		//read to object for comparison
		StudentDatabaseSerializedFileReader.openFile("studentJUnitTestData_out2.ser");
        StudentDatabase db2 = StudentDatabaseSerializedFileReader.readData();
        StudentDatabaseSerializedFileReader.closeFile();
		
        
         // now compare the two databases
         assertEquals(db.getNumStudents(), db2.getNumStudents());
         for (int i=0; i<db.getNumStudents(); i++) {
            Student s1 = db.getStudent(i);
            Student s2 = db2.getStudent(i);
            assertEquals(s1.getStudentID(),s2.getStudentID());
            assertEquals(s1.getSex(),s2.getSex());
            assertEquals(s1.getEthnicGroup(),s2.getEthnicGroup());
            assertEquals(s1.getFirstName(),s2.getFirstName());
            assertEquals(s1.getLastName(),s2.getLastName());
            assertEquals(s1.getMiddleInitial(),s2.getMiddleInitial());
            assertEquals(s1.getProgram(),s2.getProgram());
            assertEquals(s1.getAcademicPlan(),s2.getAcademicPlan());
            assertEquals(s1.getSubPlan(),s2.getSubPlan());
            assertEquals(s1.getStrtLevel(),s2.getStrtLevel());
            assertEquals(s1.getTotal(),s2.getTotal(),0.01);
            assertEquals(s1.getGPA(),s2.getGPA(),0.01);
            assertEquals(s1.getFAFSA(),s2.getFAFSA());
            assertEquals(s1.getTakePrgrs(),s2.getTakePrgrs(),0.01);
            assertEquals(s1.getFinancialNeed(),s2.getFinancialNeed(),0.01);
         }
		 
    }
	
	/*
	*Test and compare sortFileByType ser -> csv
	*/
	@Test
    public void testReadFromSerialzedThenWriteToCSV() {
		
		//set up csv files to read/compare to
		StudentDatabaseCSVFileReader.openFile("studentJUnitTestData.csv");
        StudentDatabase dbHold = StudentDatabaseCSVFileReader.readData();
        StudentDatabaseCSVFileReader.closeFile();
		
		//sort
		dbHold.sortByGPA();
		
		//ser file to compare
		StudentDatabaseSerializedFileWriter.openFile("studentJUnitTestData_out.ser");
        StudentDatabaseSerializedFileWriter.writeData(dbHold);
        StudentDatabaseSerializedFileWriter.closeFile();

		StudentDatabaseSerializedFileReader.openFile("studentJUnitTestData_out.ser");
        StudentDatabase db = StudentDatabaseSerializedFileReader.readData();
        StudentDatabaseSerializedFileReader.closeFile();
		
		
		
		
		/*StudentDatabaseCSVFileWriter.openFile("studentJUnitTestData_out3.csv");
        StudentDatabaseCSVFileWriter.writeData(db);
        StudentDatabaseCSVFileWriter.closeFile();
		*/
		//pass in two files to be handled by SortStudentDatabase
		SortStudentDatabase.sortFileByType("studentJUnitTestData_out.ser", "studentJUnitTestData_out3.csv");
		
		//read to object for comparison
		StudentDatabaseCSVFileReader.openFile("studentJUnitTestData_out3.csv");
        StudentDatabase db2 = StudentDatabaseCSVFileReader.readData();
        StudentDatabaseCSVFileReader.closeFile();
		
        
         // now compare the two databases
         assertEquals(db.getNumStudents(), db2.getNumStudents());
         for (int i=0; i<db.getNumStudents(); i++) {
            Student s1 = db.getStudent(i);
            Student s2 = db2.getStudent(i);
            assertEquals(s1.getStudentID(),s2.getStudentID());
            assertEquals(s1.getSex(),s2.getSex());
            assertEquals(s1.getEthnicGroup(),s2.getEthnicGroup());
            assertEquals(s1.getFirstName(),s2.getFirstName());
            assertEquals(s1.getLastName(),s2.getLastName());
            assertEquals(s1.getMiddleInitial(),s2.getMiddleInitial());
            assertEquals(s1.getProgram(),s2.getProgram());
            assertEquals(s1.getAcademicPlan(),s2.getAcademicPlan());
            assertEquals(s1.getSubPlan(),s2.getSubPlan());
            assertEquals(s1.getStrtLevel(),s2.getStrtLevel());
            assertEquals(s1.getTotal(),s2.getTotal(),0.01);
            assertEquals(s1.getGPA(),s2.getGPA(),0.01);
            assertEquals(s1.getFAFSA(),s2.getFAFSA());
            assertEquals(s1.getTakePrgrs(),s2.getTakePrgrs(),0.01);
            assertEquals(s1.getFinancialNeed(),s2.getFinancialNeed(),0.01);
         }
		 
    }
	
	/*
	*Test and compare sortFileByType ser -> ser
	*/
	@Test
    public void testReadFromSerialzedThenWriteToSerialized() {
		
		//set up csv files to read/compare to
		StudentDatabaseCSVFileReader.openFile("studentJUnitTestData.csv");
        StudentDatabase dbHold= StudentDatabaseCSVFileReader.readData();
        StudentDatabaseCSVFileReader.closeFile();
		
		//sort
		dbHold.sortByGPA();
		
		//ser file to compare
		StudentDatabaseSerializedFileWriter.openFile("studentJUnitTestData_out.ser");
        StudentDatabaseSerializedFileWriter.writeData(dbHold);
        StudentDatabaseSerializedFileWriter.closeFile();

		StudentDatabaseSerializedFileReader.openFile("studentJUnitTestData_out.ser");
        StudentDatabase db = StudentDatabaseSerializedFileReader.readData();
        StudentDatabaseSerializedFileReader.closeFile();
		
		//pass in two files to be handled by SortStudentDatabase
		SortStudentDatabase.sortFileByType("studentJUnitTestData_out.ser", "studentJUnitTestData_out4.ser");
		
		//read to object for comparison
		StudentDatabaseSerializedFileReader.openFile("studentJUnitTestData_out4.ser");
        StudentDatabase db2 = StudentDatabaseSerializedFileReader.readData();
        StudentDatabaseSerializedFileReader.closeFile();
		
        
         // now compare the two databases
         assertEquals(db.getNumStudents(), db2.getNumStudents());
         for (int i=0; i<db.getNumStudents(); i++) {
            Student s1 = db.getStudent(i);
            Student s2 = db2.getStudent(i);
            assertEquals(s1.getStudentID(),s2.getStudentID());
            assertEquals(s1.getSex(),s2.getSex());
            assertEquals(s1.getEthnicGroup(),s2.getEthnicGroup());
            assertEquals(s1.getFirstName(),s2.getFirstName());
            assertEquals(s1.getLastName(),s2.getLastName());
            assertEquals(s1.getMiddleInitial(),s2.getMiddleInitial());
            assertEquals(s1.getProgram(),s2.getProgram());
            assertEquals(s1.getAcademicPlan(),s2.getAcademicPlan());
            assertEquals(s1.getSubPlan(),s2.getSubPlan());
            assertEquals(s1.getStrtLevel(),s2.getStrtLevel());
            assertEquals(s1.getTotal(),s2.getTotal(),0.01);
            assertEquals(s1.getGPA(),s2.getGPA(),0.01);
            assertEquals(s1.getFAFSA(),s2.getFAFSA());
            assertEquals(s1.getTakePrgrs(),s2.getTakePrgrs(),0.01);
            assertEquals(s1.getFinancialNeed(),s2.getFinancialNeed(),0.01);
         }
		
	}
	
} // end test class
