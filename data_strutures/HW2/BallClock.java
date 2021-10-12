/********************************************************
	Purpose: Program takes integer input from text file,
	calculates the number of cycles before repeated ball 
	configuration, and sends output to the console.

********************************************************/

public class BallClock{
	//make 3 stacks for each slot
	private BallStack minutes;
	private BallStack fives;
	private BallStack hours;
	
	//arrays to compare orders
	private BallQueue initial;
	private BallQueue ending;
	
	//track total minutes
	int totalMinutes;
	
	//constructor
	public BallClock(int numBalls){
		this.minutes = new BallStack(4);
		this.fives = new BallStack(11);
		this.hours = new BallStack(11);
		
		//arrays hold balls to check
		initial = new BallQueue(numBalls);
		ending = new BallQueue(numBalls);
		
		//set start position in queues
		setupBalls(numBalls);
		
		//set total minutes to 0
		totalMinutes = 0;
	}
	
	//setup balls
	private void setupBalls(int numBalls){
		//fill array with ball numbers to check
		for(int i=1; i<=numBalls; i++){
			initial.enqueue(i);
			ending.enqueue(i);
		}
	}
	
	//calculations
	public int startClock(){
		
		//while config is not identical to start config
		while(!checkConfig() || totalMinutes<1){
			addMinute();
			totalMinutes++;
		}
		
		//1440 minutes/day
		return totalMinutes/(1440);
	}
	
	private void addMinute(){
		
		//if minute slot is open (at size 4, cannot push more on stack)
		if(minutes.size() < 4){
			//push next element from ending
			minutes.push(ending.dequeue());
		}
		//else, add 1 5-minute ball and pop minutes onto ending
		else{
			for(int i=0; i<4; i++){
				ending.enqueue(minutes.pop());
			}
			addFive();
		}
	}
	
	private void addFive(){

		//if fives slot is open
		if(fives.size() < 11){
			//push until 11 slots taken
			fives.push(ending.dequeue());
		}
		//else, add 1 hour ball and pop fives onto ending
		else{
			for(int i=0; i<11; i++){
				ending.enqueue(fives.pop());
			}
			addHours();
		}
	}
	
	private void addHours(){
		//if hours slot is open
		if(hours.size() < 11){
			hours.push(ending.dequeue());
		}
		//else, add pop new ball and pop hours onto ending
		else{
			for(int i=0; i<11; i++){
				ending.enqueue(hours.pop());
			}
			//move final ball after full clock reset to end of queue
			ending.enqueue(ending.dequeue());
		}
	}
	
	private boolean checkConfig(){
		
		//set default true
		boolean isEqual = true;
		//once item in ending is not equal to initial, set equal to false and break
		for(int i=0; i<initial.size(); i++){
			if(initial.peekIndex(i) != ending.peekIndex(i)){
				isEqual = false;
				break;
			}
		}
		return isEqual;
	}
}