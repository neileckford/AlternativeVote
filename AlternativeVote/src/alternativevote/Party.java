package alternativevote;

public class Party {
	String name;
	int votes;
	int position;
	static int counter=0;
	
	public Party(String n, int p){
		name = n;
		position = counter++;
		votes = 0;
	}
	
	public void reset(){
		votes = 0;
	}
	
	public void upTotal(){
		votes += 1;
	}
	
	public int getPosition(){
		return position;
	}
}
