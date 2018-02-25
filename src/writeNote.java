import java.util.Random;

public class writeNote {
	//http://www.donaldsonworkshop.com/coriakin/melody.html
	
	
	
	public void generateMelody(int[] staff) {
        //some notes will demand a follow up. 
		//Apparent in the first (if not starting at the root).
		int nextMust = -1; 
		
        //set the rand and seed 
        Random rand = new Random(System.currentTimeMillis());
        
        //pick your first note
        	//I , IV, V almost always	
		staff[0] = rand.nextInt(10); 
			
		//so like half the time the root will be 0
			if(staff[0] < 7){
				staff[0] = 1;	
			}
		//30% chance for starting on the 5th
			else if(staff[0] < 8){
				staff[0] = 5;
				nextMust = 1;
			}
		//20% chance for a fourth start.
			else {
				staff[0] = 4;
				nextMust = 1;
			}
		
		//print till last measure
			
			//weights for each leap given on a 0-9 scale. 
			//weights should be adjusted with each iteration
			int stepweight = 6;
			int leapweight = 3;
				int smallLeapWeight= 6;
					int twoLeapWeight = 2;
					int threeLeapWeight = 3;
				int largeLeapWeight = 9;
					int fourLeapWeight = 6;
					int fiveLeapWeight = 7;
					//sixLeapWeight; dont do this 
					int sevenLeapWeight = 10;
			
		
		//generate the rest of the notes 
		for(int i = 1; i < (staff.length); i++) {
			
			if(nextMust != -1) {
				staff[i] = nextMust;
				nextMust = -1; //set nextMust back to -1 to indicate it is empty
			}
			
			else {
				staff[i] = rand.nextInt(10); 	
				
				//chance the movement will be stepwise. 
				if(staff[i] <stepweight) {
					//increment or decrement by 1
					if(staff[i]%2 == 1) {
						++staff[i]; 
					}
					else{
						--staff[i];
					}
				}
				
				else if(staff[i] < leapweight) {
					if(staff[i] < twoLeapWeight) {
						staff[i] = staff[i-1] + 2;
					}
					else if(staff[i] < threeLeapWeight) {
						staff[i] = staff[i-1] + 3;
					}
					else if(staff[i] < fourLeapWeight) {
						staff[i] = staff[i-1] + 4;
					}
					else if(staff[i] < fiveLeapWeight) {
						staff[i] = staff[i-1] + 5;
					}			
					else if(staff[i] < sevenLeapWeight) {
						staff[i] = staff[i-1] + 7;
					}
				}
				
			} //end of else selection note block 
		
			//if you have a negative number, roll over	
			if(staff[i] < 1) {
				staff[i] = 8 + staff[i];
			}
			if(staff[i] > 8) {
				staff[i] = staff[i]%8 + 1;
			}
			if(i == staff.length-1) {
				nextMust = 1;
			}
		
		}//end of note selection for loop
	
	}
}
