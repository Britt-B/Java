//build a heap of blankets; compare all the blankets in the world

public class Blanket implements Comparable<Blanket>{
	//rank a blanket based on fluffiness; the rank of this blanket out of all the blankets that exist
	private int fluffinessRating;
	
	//construct a blanket
	public Blanket(int fluffinessRating){
		this.fluffinessRating = fluffinessRating;
	}
	
	//make this blanket comparable to all blankets
	@Override
	public int compareTo(Blanket blanket){
		//this blanket is fluffier
		if(this.fluffinessRating > blanket.getFluffinessRating()){
			return 1;
		}
		//this blanket is not as fluffy as the other blanket
		else if(this.fluffinessRating < blanket.getFluffinessRating()){
			return -1;
		}
		//same level of fluffiness
		else{
			return 0;
		}
	}
	
	public int getFluffinessRating(){
		return this.fluffinessRating;
	}
}