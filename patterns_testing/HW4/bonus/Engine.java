public class Engine extends TrainCar{
	
	//constructor takes number of cars to add to engine
	public Engine(int numCarsAfterEngine){
		//call super constructor, create new box car, decreasing number of cars remaining by 1
		super(new BoxCar(null, numCarsAfterEngine-1));
		//if negative number, give value of 0
		if(numCarsAfterEngine < 0){
			super.itsNextConnectedCar = new BoxCar(null, 0);
		}
		
	}
	
	//return distance for tester to verify
	public double getItsDistanceFromHome(){
		return super.itsDistanceFromHome;
	}
	
	//override abstract method from TrainCar
	@Override
	public void advance(double howFar){
		
		//Overflow to zero to keep direction consistent
		if((howFar == Integer.MAX_VALUE) || (howFar == Integer.MIN_VALUE)){
			howFar = 0.0;
		}
		
		//move this car
		super.itsDistanceFromHome += howFar;
		
		//make sure next car exists
		if(super.itsNextConnectedCar != null){
			//move each train specified distance
			super.itsNextConnectedCar.advance(howFar);
		}
	}
	
	//override abstract method from TrainCar
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