public abstract class TrainCar{
	
	//vars to determine distance from home and next car
	protected double itsDistanceFromHome;
	protected TrainCar itsNextConnectedCar;
	
	//constructor takes in next TrainCar, sets distance to 0
	public TrainCar(TrainCar nextCar){
		itsNextConnectedCar = nextCar;
		itsDistanceFromHome = 0.0;
	}
	
	//abstract methods to override
	public abstract void advance(double howFar);
	public abstract Boolean isMemberOfValidTrain();
	
}//end class