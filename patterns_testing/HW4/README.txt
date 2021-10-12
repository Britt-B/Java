Brittany Bergeron
README HW4/bonus

Compile Instructions
	Typing "javac *.java" in the HW4 directory should result in a successful compilation 
	of all files in the folder.

Run instructions
	To run the tester, type 
	"java org.junit.runner.JUnitCore CompareTest". The tester should
	complete 2 tests successfully.
Expected resut
	2 tests should pass
	
	
	Recursive
		This class implements two methods: compareTo() and findMinimum().
		
		The compareTo method will take two String parameters and return a negative,
		0, or positive number. It is first determined if at least one null parameter
		exists. If this is the case, the charAt() and subString() methods will throw
		exceptions. Because null is ASCII value 0, if only one string is null, it will
		be the lower String. If both are null, they will be considered equal in this
		case. Assuming neither String is null, the value of the first chracters are 
		subtracted. If these characters were not the same, we can safely determine the
		order and return the result. Otherwise, it is determined if one or both strings
		ended and values -1, 0, and 1 are returned based on which string ended first. If
		these conditions can't be stisfied (the values are equal and there are more
		characters t check), the method returns a recursive call to compareTo() passing
		in substrings starting at index 1.
		
		The findMinimum() method will examine an arrayList of Strings and return the
		String that is first alphabetically. The base case would assume only one String
		was stored in the stringArray. It will return the element at index 0. Otherwise,
		the method will pass the first two values in the list to compareTo() and remove
		the higher value String (the second if positive, the first if negative or 0). The
		newly modified list is used as an argument: return findMinimum(newList).
	.
	
	CompareTest
		The tester will store 5 String literals and 2 null Strings independantly and
		create an arrayList. The first test will ensnure comapareTo is poroperly
		evaluating strings based on several scenarios: 
		-in order
		-equal
		-out of order
		-string and null
		-null and null.
		
		compareArrayList() will store the minimum string, remove a string, find the new
		minimum, repeat.... The 2 final results are based on adding both null strings.
		The values are compared in assertEquals() with expected and stored values.
	.
	
Bonus
Compile Instructions
	Typing "javac *.java" in the HW4/bonus directory should result in a successful 
	compilation of all files in the folder.

Run instructions
	To run the tester, type 
	"java org.junit.runner.JUnitCore TrainTester". The tester should
	complete 2 tests successfully.
Expected resut
	2 tests should pass
	
	TrainCar
		This abstract class is used as a blueprint for Engine, BoxCar, and Caboose. It 
		contains 2 protected variables to represent distance and the next TrainCar as well
		as a constructor(takes TrainCar parameter) and two abstract methods, advance() and
		isMemberOfValidTrain().
	.
	
	Train
		Train is a class that allows for the building of a train. The constructor is made
		to take in a number of train cars which can be used in the BoxCar class. The engine
		variable is instantiated and numCars passes to it. This class has two queries to 
		provide feedback for the tester.
	.
	
	Engine (extends TrainCar)
		Engine's constructor calls the super class by passing in a new BoxCar, which recieves
		the values of null and reduces the number of engines needed by 1. If the number of
		cars passed in is negative, the nextBoxCar is changed to one with 0 as the new number of
		subsequent cars.
		A query for distance was created for testing purposes.
		advance() is overridden from TrainCar. It stops the distance value from overflowing(a train
		shouldn't move in a positive direction and end in a negative. The value of this cars distance
		is changed, and if the next car exists, it will also advance.
		isMemberOfValidTrain() first checks if a car is connected. If there is not, considering
		this is the Engine, the value returned is false. If the next BoxCar is in a valid train,
		true is returned. If it is not, false is returned.
	.
	
	BoxCar (extends TrainCar)
		The constructor for BoxCar is similar to the Engine's. Because it needs a next train car,
		super can be invoked using that car. If the car needs more than one subsequent cars, the
		itsNextConnectedCar (currently null) is changed to a new BoxCar with one less need car.
		When only one car is needed, itsNextConnectedCar becomes the caboose.
		advance() will add distance to the current and any subsequent cars.
		isMemberOfValidTrain() ensures the car is connected, and returns true if it reaches a caboose.
	.
	
	Caboose (extends TrainCar)
		Caboose is the end of the train, so it will only pass null to it's super. advance() only
		adjusts its distance value. isMemberOfValidTrain() returns true, because it must have
		passed through an Engine and some number of BoxCars to reach the Caboose.
	.
	
	TrainTester
		TrainTester creates several Train objects. They are instantiated with:
		a normal train car size
		the minimum needed train car size
		an invalid train size (too small)
		a zero train car size
		a large train size
		a negative train size
		The memberTest determines if the Train is valid. Each train is assterted true/false to it's 
		expected value.
		The distanceTest will test the following trian moves to 0.0001 significance:
		-no move
		-positive decimal move
		-two positive decimal moves
		-Overflow Integer value
		-negative/backwards move
	.
	