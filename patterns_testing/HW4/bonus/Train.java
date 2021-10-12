public class Train{
	
	//Train only knows about it's engine
	private Engine engine;
	
	//constructor; give the engine knowledge of number of car to follow
	public Train(int numCars){
		Engine engine = new Engine(numCars);
		this.engine = engine;
	}
	
	/*
	@return distance from home to verify in tester
	**/
	public double getItsDistanceFromHome(){
		return this.engine.getItsDistanceFromHome();
	}
	
	/*
	@return engine to verify in tester
	**/
	public Engine getEngine(){
		return this.engine;
	}
}//end class