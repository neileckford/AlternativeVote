package alternativevote;

import java.util.ArrayList;

public class BallotPaper {
	
	ArrayList<Integer> theParties = new ArrayList<Integer>();
	
	public BallotPaper(int p1, int p2, int p3, int p4){
		theParties.add(p1);
		theParties.add(p2);
		theParties.add(p3);
		theParties.add(p4);
	}
	
	public void adjust(){
		for (int i=0;i<theParties.size();i++){
			theParties.set(i, theParties.get(i) - 1);
		}
	}
	
	public void showPaper(){
		for (Integer p : theParties){
			System.out.print(p + " ");
		}	
		System.out.print("\n");
	}
}
