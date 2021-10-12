/**
*
@author Brittany Bergeron
@version 0.0.1
@since 2/12/19
*
*/


public class MyObservable{
	
	//values
	private boolean hasChanged;
	private int numObservers;
	private MyObserver[] myObserverArray; 
	/**
	@param hasChanged holds the boolean value of the current observable's change status
	@param numObservers holds the number of observers currently looking at the observable
	@param myObserverArray groups the current observers together to be notified of change
	*/
	
	
	/**
	*constructor to initaialize parameters to 0/false values
	*/
	public MyObservable(){
		hasChanged = false;
		myObserverArray = new MyObserver[0];
		numObservers = 0;
	}
	
	
	/**
	*add observers to array by verifying they have not been added previously and copying the array into a new
	*appropriately sized one
	*/
	public void addMyObserver(MyObserver o){
		//adds observer to set of observers for this object, provided it is NOT
		//THE SAME as observer already in set
		
		boolean addedAlready = false;
		//check if observer is already in array
		for(int i=0; i < myObserverArray.length; i++){
			if(o == myObserverArray[i]){
				addedAlready = true;
			}
		}
		
		//add to array
		if(!addedAlready){
			//create new array to adjust size
			MyObserver[] newArray = new MyObserver[(numObservers + 1)];
			//copy observer references into new array
			for(int i = 0; i < myObserverArray.length; i++){
				newArray[i] = myObserverArray[i];
			}
			//set this array equal to new array
			this.myObserverArray = newArray;
			//add new observer to array
			myObserverArray[numObservers] = o;
			//increment number of observers by one
			numObservers += 1;
		}
	}
	
	/**
	*clear changed sets hasChanged boolean to false
	*/
	protected void clearChanged(){
		//indicates  object has no longer changed; use hasChanged boolean or all observers have been notified already
		this.hasChanged = false;
	}
	
	/**
	@return the integer number of observers currently assigned to watch this observable
	*/
	public int countMyObservers(){
		//number of observers store as int
		return this.numObservers;
	}
	
	/**
	*deleteMyObserver removes one observer as specified in the parameter
	*/
	public void deleteMyObserver(MyObserver o){
		//check if observer is in array
		for(int i=0; i < myObserverArray.length; i++){
			if(o == myObserverArray[i]){
				//remove object from array
				myObserverArray[i] = null;
				//count stores int to point to an index of the new array
				int count = 0;
				//create new array to adjust size
				MyObserver[] newArray = new MyObserver[(numObservers -1)];
				//loop through old array, take non-null references and copy them to new array
				for(int j=0; j<numObservers; j++){
					if(myObserverArray[i] != null){
						newArray[count] = myObserverArray[j];
						count++;
					}
				}
				//assign the modified array to observer array
				this.myObserverArray = newArray;
				//decrease numObservers
				this.numObservers -= 1;
			}
		}
	}
	
	/**
	*deleteMyObservers removes all observers, sets the number of observers to 0,
	*and sets array to length 0
	*/
	public void deleteMyObservers(){
		//clear all observers
		this.numObservers = 0;
		this.myObserverArray = new MyObserver[0];			
	}
	
	/**
	@return the boolean value of hasChanged determines if the observable has been changed since
	*last notified
	*/
	public boolean hasChanged(){
		//tests if object has changed - query; return this.hasChanged
		return this.hasChanged;
	}
	
	/**
	*notify with no argument sends null arg
	*/
	public void notifyMyObservers(){
		//pass with nul
		notifyMyObservers(null);
	}
	
	/**
	*notifyMyObservers loops through Observer array and invokes the update method, passing
	*a reference to this observable as an object and another object argument
	*/
	public void notifyMyObservers(Object arg){
		//see above, takes in object to pass to observer
		if(hasChanged){
			for(int i=0; i < myObserverArray.length; i++){
				if(myObserverArray[i] != null){
					myObserverArray[i].update(this, arg);
				}
			}
			//clear hasChanged to false value
			clearChanged();
		}
	}
	
	/**
	*setChanged gives hasChanged a value of true
	*/
	protected void setChanged(){
		//markes hasChanged true (mutator)
		this.hasChanged = true;
	}
}