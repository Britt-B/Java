/**
*
@author Brittany Bergeron
@version 0.0.1
@since 2/12/19
*
*/

import java.util.ArrayList;

public class MyObservable{
	
	//values
	private boolean hasChanged;
	private int numObservers;
	private ArrayList <MyObserver> myObserverArrayList = new ArrayList(); 
	/**
	@param hasChanged holds the boolean value of the current observable's change status
	@param numObservers holds the number of observers currently looking at the observable
	@param myObserverArrayList groups the current observers together to be notified of change
	*/
	
	/**
	*constructor to initaialize parameters to 0/false values
	*/
	public MyObservable(){
		hasChanged = false;
		numObservers = 0;
	}
	
	/**
	*add observers to array by verifying they have not been added previously
	*/
	public void addMyObserver(MyObserver o){
		//adds observer to set of observers for this object, provided it is NOT
		//THE SAME as observer already in set
		
		boolean addedAlready = false;
		//check if observer is already in array
		if(myObserverArrayList.contains(o)){
				addedAlready = true;
		}
		
		//add to array
		if(!addedAlready){
			myObserverArrayList.add(o);
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
		//check if observer is already in array
		myObserverArrayList.remove(o);
		if(numObservers > 0){
			this.numObservers -= 1;
		}
	}
	
	/**
	*deleteMyObservers removes all observers, sets the number of observers to 0,
	*and sets array to length 0
	*/
	public void deleteMyObservers(){
		//clear all observers
		myObserverArrayList.clear();
		this.numObservers = 0;			
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
		notifyMyObservers(null);
	}
	
	/**
	*notifyMyObservers loops through Observer arrayList and invokes the update method, passing
	*a reference to this observable as an object and another object argument
	*/
	public void notifyMyObservers(Object arg){
		//see above, takes in object to pass to observer
		if(hasChanged){
			for(int i=0; i < myObserverArrayList.size(); i++){
				myObserverArrayList.get(i).update(this, arg);
			}
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