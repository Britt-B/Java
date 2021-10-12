Brittany Bergeron
README

HW2_starter_code
	RedirectTester:
		This tester creates five observables and four observers. Each observable is given edge case values (positive, negative, 
		max/min overflows, null, 0, and negative decimal casts). Output is stored as a ByteArrayOutput stream and assigned to 
		the variable output. Each of the 2 tests assert that the objects' toString methods are equal to the expected System output.	
	
	
HW2	
	MyObserver:
		This interface only contains the update method, which takes in two arguments. One is a reference to the observables
		which updated the method, and the other is an object that is either passed in or given the value null in MyObservable.
	
	
	MyObservable:
		Data:
			MyObservable has 3 class variables. hasChanged: a boolean value that determines the changed state(as indicated by 
			the setChanged and clearChanged methods), numObservers: an int that stores the total number of observers watching 
			this observable, and MyObserver[]: an array that holds all of the current observables.
		Constructor:
			The constructor sets all class values to 0/false.
		Methods:
			addMyObservers:
				Adding observers is a process that involes looping through the observer array to insure that the observer is
				not currently watching, copying the old array values into a new array that has 1 more index, and increasing the
				total number of observers watching.
			
			clearChanged:
				(protected) Clearing the changed status simply assigns the value of false to the hasChanged class variable.
			countMyObservers:
				This is a query method that returns the class variable numObservers.
			hasChanged:
				This is a queary method that returns the class variable hasChanged.
			notifyMyObservers:
				This method is overloaded; one takes no arguments and passes null to the second, which takes an Object. When called,
				All observers currently in the MyObserver array will be notified. The update method is invoked, passing a reference to
				this instance of MyObservable and the Object argument. The clearChanged method is then called to reset hasChanged.
			setChanged: 
				A protected mutator method that changes the value of hasChanged to false.
				
				
	RedirectTester:
		This tester implements the tests as previously described, as well as a few others. It now includes testMyObservableCount,
		which asserts that each pokemon has the correct amount of observers. testMyObservableChanged wil assert that setChanged, 
		notifyMyObservers, and clearChanged(called implicitly), will return the expected values.

	
bonus1:
	MyObservable:
		Same as previously stated, now implementing delete methods. deleteMyObserver loops throug the observer array, checking if
		the desired Observer exists. If found, it will set that element value to null. The old array values not equal to null are
		then copied into a new array of one less length, and the numObservers is decremented by on. deleteMyObservers changes the
		numObservers to 0 and sets myObserverArray to length 0.
	
	
	RedirectTester:
		The tester now includes tests to delete one or all of the observers, and asserts that the new number of observers is now true.
	

bonus2:
	MyObservable:
		ArrayList! Yay, so much easier! This bonus removes the need to "alter" the size of the array, and looping through it is 
		generally unnecessary. Methods contains(), add(), and remove() have replaced redundant code. The only loop that remains is in
		notifyMyObservers, as each observer needs to be updated.