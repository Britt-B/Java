public class SortStudentDatabase{
	
	public static void sortFileByType(String input, String output){
		
		//determine suffix
		String inputType = input.substring(input.length()-4);
		String outputType = output.substring(output.length()-4);
		
		//store types as boolean
		boolean csvIn = false;
		boolean serIn = false;
		boolean csvOut = false;
		boolean serOut = false;
		
		//determine input type
		if(inputType.equals(".csv")){
			csvIn = true;
		}
		else if(inputType.equals(".ser")){
			serIn = true;
		}
		//error if not csv or ser
		else{
			System.out.println("Enter .csv or .ser files.");
			System.exit(1);
		}
		//determine output type
		if(outputType.equals(".csv")){
			csvOut = true;
		}
		else if(outputType.equals(".ser")){
			serOut = true;
		}
		//error if not csv or ser
		else{
			System.out.println("Enter .csv or .ser files.");
			System.exit(1);
		}
		
		//determine which method to invoke, pass args
		if(csvIn){
			if(csvOut){
				StudentDatabaseIO.formattedToFormatted(input, output);
			}
			else{
				StudentDatabaseIO.formattedToSerialized(input, output);
			}
		}
		else if(serIn){
			if(csvOut){
				StudentDatabaseIO.serializedToFormatted(input, output);
				
			}
			else{
					StudentDatabaseIO.serializedToSerialized(input, output);
			}
		}
	}
}//end class