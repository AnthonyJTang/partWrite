//Anthony Tang, ajt161230, Anthony.Tang@utdallas.edu
//main for partWrite

import java.util.Random;

class partWrite{

	public static int root = 1;
	public static int first = 1;
	public static int second = 2;
	public static int third = 3;
	public static int fourth = 4;
	public static int fifth = 5;
	public static int sixth = 6;
	public static int seventh = 7;
	public static int eight = 8; 
	
	public static void main (String args[]) {
        
		writeNote melody = new writeNote();
				
        //assume 4/4 8 measures. 32 beats
        int[] staff = new int[32];
		
        melody.generateMelody(staff);
        
		//last measure needs to resolve. 
		toNotes.printNotes(staff);
 
    }
    
	
	
}
