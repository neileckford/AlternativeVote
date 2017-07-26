package alternativevote;

import java.util.*;

public class Main {
	String[] partyNames = {"SNP", "Conservatives", "Labour", "Liberal Democrats"};
	
	ArrayList<BallotPaper> paper = new ArrayList<BallotPaper>();
	ArrayList<Party> parties = new ArrayList<Party>();
	int scottishNats;
	int conservative;
	int labour;
	int libDem;
	
	public Main(){
		
		addParties();
		addBallotPapers();
		//showAllPapers();
		calculateResults();
		displayResults();
		eliminateLast();
		calculateResults();
		displayResults();
		eliminateLast();
		calculateResults();
		displayResults();
		eliminateLast();
	}

	public void addParties(){
		parties.add(new Party("SNP",1));
		parties.add(new Party("Conservative",2));
		parties.add(new Party("Labour",3));
		parties.add(new Party("Liberal Democrats",4));
	}
	
	public void addBallotPapers(){
		paper.add(new BallotPaper(1,0,2,0));
		paper.add(new BallotPaper(0,1,0,0));
		paper.add(new BallotPaper(0,1,0,0));
		paper.add(new BallotPaper(0,1,0,0));
		paper.add(new BallotPaper(0,1,0,0));
		paper.add(new BallotPaper(2,0,1,0));
		paper.add(new BallotPaper(2,0,1,0));
		paper.add(new BallotPaper(2,0,1,0));
		paper.add(new BallotPaper(1,0,2,0));
	}
	
	public void calculateResults(){
		for (Party p : parties){
			p.reset();
			for (BallotPaper b : paper){
				if (b.theParties.get(p.getPosition())==1){
					p.upTotal();
				}
			}
		}
	}
	
	public void sortParties(){
		Collections.sort(parties, new Comparator<Party>() {
			@Override
			public int compare(Party p1, Party p2) {
				return p1.votes- p2.votes;
			}
	    });
	}
	
	public void displayResults(){
		sortParties();
		for (Party p : parties){
			System.out.println(p.name + " - " + p.votes);
		}
		System.out.println("Last party is " + parties.get(0).name);
	}
	
	public void eliminateLast(){
		for (BallotPaper b : paper){
			if (b.theParties.get(parties.get(0).getPosition()) == 1){
				b.adjust();
			}
		}
		parties.remove(0);
	}

	public void showAllPapers(){
		for (BallotPaper b : paper){
			b.showPaper();
		}
	}

	public static void main(String[] args){
		Main m = new Main();
	}
}
