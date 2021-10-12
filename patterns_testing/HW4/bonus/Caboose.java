public class Caboose extends TrainCar{
	
	//caboose is end, just pass null to satisfy super requirements
	public Caboose(){
		super(null);
	}
	
	/*
	*override abstract method from TrainCar to move the entire train
	**/
	@Override
	public void advance(double howFar){
		//add to distance
		this.itsDistanceFromHome += howFar;
	}
	
	/*
	*override abstract method from TrainCar to determine if it is in a valid train
	**/
	@Override
	public Boolean isMemberOfValidTrain(){
		//if we got here, we know an engine was created and there 
		//is at least one box car; return true
		return true;
	}
}//end class