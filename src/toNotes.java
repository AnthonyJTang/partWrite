import java.io.*;

public class toNotes{

	public static void printNotes(int[] staff) {
		//check key
		
		String noteLine =   "\\version \"2.18.2\"\r\n" + 
							"\\relative c'\r\n" + 
							"{ \n";
		PrintStream outFile = null;
		
		try {
			outFile = new PrintStream("autoGen004.ly");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("file failed to open");
		}
	
		//print the intervals to output (tested in C major)
		for(int i = 0; i < staff.length; i++) {
			//if the multiple of 4 print a | to make a measure.
			//assume 4/4 for testing 
			if((i%4) == 0) {
				noteLine +=(" | ");
			}
			
			if(staff[i] == 1) {
				noteLine +=("c ");
			}
			else if(staff[i] == 2) {
				noteLine +=("d ");
			}
			else if(staff[i] == 3) {
				noteLine +=("e ");
			} 
			else if(staff[i] == 4) {
				noteLine +=("f ");
			}
			else if(staff[i] == 5) {
				noteLine +=("g ");
			}
			else if(staff[i] == 6) {
				noteLine +=("a ");
			}
			else if(staff[i] == 7) {
				noteLine +=("b ");
			}
			else if(staff[i] == 8) {
				noteLine +=("c ");
			}
			else {
				noteLine +=("~ ");
			}
		}
		
		noteLine += (" || \n");
		noteLine +=("}");
		
		System.out.println(noteLine);
		//print 
		outFile.print(noteLine);
	}
}

