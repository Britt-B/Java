import java.io.IOException;
import java.lang.IllegalStateException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Formatter;


public class StudentDatabaseCSVFileWriter {

    private static Formatter output;

    public static void openFile (String filename) {

        try {
            output = new Formatter(filename);
        }   
        catch (IOException e) {
            System.err.println("Error opening file.  Terminating");
            System.exit(1);
        }        
    }    

    public static void writeData(StudentDatabase db) {
        int numStudents = db.getNumStudents();
		
		//header format
		output.format("ID,Sex,Ethnic Grp,Name,Prim Prog,Acad Plan,Sub-Plan,Strt Level,Total,GPA,FAFSA,Take Prgrs,Fin Need");
		output.format("%n");
		
        for (int i=0; i<numStudents; i++) {
            Student current = db.getStudent(i);
            output.format("%d,%s,%s,",current.getStudentID(),current.getSex(),current.getEthnicGroup());

            // YOUR CODE HERE
            /* here, you're going to output the rest of the student information to the file
               see the format of how the "parsing" method works in StudentDatabaseCSVFileReader
               NOTE: THE OUTPUT SHOULD BE IN EXACTLY THE SAME FORMAT AS THE INPUT!!!
            */
			
			//first and middle
			String fullString = "\"" + current.getLastName() + ", " + current.getFirstName() + " " + current.getMiddleInitial() + "\"";
			
			output.format("%s,", fullString);
			output.format("%s,%s,%s,", current.getProgram(), current.getAcademicPlan(), current.getSubPlan());
			output.format("%d,%.1f,%f,", current.getStrtLevel(), current.getTotal(), current.getGPA());
			output.format("%s,%.1f,%.1f", current.getFAFSA(), current.getTakePrgrs(), current.getFinancialNeed());

            // end the line that represents all the data for one student
            output.format("%n");
        }
    }

    public static void closeFile() {
        if (output != null)
            output.close();
        output = null;
    }

}
