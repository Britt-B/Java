public class BoxCar extends TrainCar{
	
	//box car constructor takes in next box car (initially null) and number of cars 
	//remaining to create
	public BoxCar(TrainCar next, int numCarsLeft){
		//call super
		super(next);
		//make sure at least one car to be made
		if(numCarsLeft > 1){
			//change the super value of next car to a new boxCar with 1 less to create
			super.itsNextConnectedCar = (new BoxCar(null, numCarsLeft-1));
		}
		//if one left, it becomes the caboose
		if(1 == numCarsLeft){
			//change super next car to caboose
			super.itsNextConnectedCar = (new Caboose());
		}
		//otherwise(meaning 0), null is already stored and no more cars are created
		
	}
	
	
	/*
	*override abstract method from TrainCar to move the entire train
	**/
	@Override
	public void advance(double howFar){
		//make sure next car exists
		if(super.itsNextConnectedCar != null){
			//move each train specified distance
			super.itsNextConnectedCar.advance(howFar);
		}
		//move this car as well
		super.itsDistanceFromHome += howFar;
	}
	
	/*
	*override abstract method from TrainCar to determine if it is in a valid train
	**/
	@Override
	public Boolean isMemberOfValidTrain(){
		//make sure next car exists
		if(super.itsNextConnectedCar == null){
			return false;
		}
		//"ask" each next car if it is connected; if it hits a caboose, true will be returned
		else if(super.itsNextConnectedCar.isMemberOfValidTrain()){
			return true;
		}
		//did not hit caboose
		else{
			return false;
		}
	}
}//end class