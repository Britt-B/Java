Brittany Bergeron
README

ComplexNumber class:
	Overview:
	The purpose of ComplexNumber is to construct a complex number that can be manipulated through
	4 basic operations: addition, subtraction, multiplication, and dividion. The values of the complex
	number and it's String representation can be retrieved, as well as the boolean value for equality.
	
	Structure:
	The class has two constructors: The first takes no parameters, passing two 0 values into the second 
	parameter. The second then sets the 2 class variables:  "a" represents the real portion, and "b" represents 
	the complex portion. Two query methods return these values respectively.
	
		Addition:
			The method takes in a complex number and adds it to the current instance. A new number is generated
			and returned.
			(a + bi) - (c + di) = (a + c) + (b + d)i
		Subtraction:
			The method takes in a complex number and subtracts it from the current instance. A new number is generated
			and returned.
			(a + bi) - (c + di) = (a - c) + (b - d)i
		Multiplication:
			The method takes in a complex number and finds a new "a" value by subtracting the product of the two "b"
			values from the product of the two "a" values. Similarly, the new "b" value is found by across multiplying
			the "a" and "b" values, and adding them together.
			(a + bi)(c + di) = (ac - bd) + (bc + ad)
		Division:
			The method takes in a complex number and first calculates a denominator by adding the squares of the second 
			"a" and "b" values. It then finds a new "a" value by adding the product of the two "a" values with the 
			product of the two "b" values. The sum is then divided by the denominator. Similarly, a new "b" value is 
			found by subtracting the product of the current "a" value with the second "b" value from the product of the 
			current "b" value with the second "a" value. The sum is then divided by the denominator.
			(a + bi)/(c + di) = [(ac + bd)/(c^2 + d^2)] + [(bc - ad)/(c^2 + d^2)]
		
		The toString is overridden to represent the complex number in string format. The selection statements determine
		that the "a" and "b" portions are not 0, then adds the values to the string. If both values are 0, simply "0" is
		returned.
		
		The equals method is also overridden. It uses a tolerance of 0.0001 to measure equality due to rounding. If the
		object passed in is an instance of ComplexNumber, it will be casted and stored in a variable newComplex as such. 
		The absolute value of the difference of the new complex number and the current instance are found. If the result 
		is under the tolerance, the numbers are determined to be equal.

		
ComplexNumberTester:
	Overview: The purpose of this class is to test Instances of ComplexNumber, and ensure the methods are working as expected.
	
	Structure:
		Class variables:
			5 complex number objects are declared as private variables to use within the test cases.
			A constant TOLERANCE is initialized to 0.0001 to compensate rounding.
			complexHolder is a complex number whose purpose is to temporarily store the value of some other complex number.
			
		@Before:
			the setup method initializes the 5 complex numbers with values. The values given include positive, negative, 
			decimal, and no value passed in to ensure a variety of test cases.
			
		@Test Construction:
			This test checks that both the constructors worked as expected, and the query methods return appropriate vales.
			
		@Test Add, Subtract, Multiply, Divide:
			These four tests invoke their respective methods. complexHolder is first set to store the returned value of the
			operation performed, and is then compared (with the two query methods) to the correct answer using the TOLERANCE 
			constant.
			
		@Test toString:
			This test needs to ensure that the signs and decimals are correct, as well as the "i" tacked onto the end. Each 
			complex number is compared to the expected string output.
			
		@Test equals:
			Equals will use the complexHolder to store each of the 5 complex numbers, and compare it to the original. To
			further test this, a false case was created with two non-equivalent cases.
			
Bonus 1:
	Overview: The purpose of this class is to allow the interaction of real and complex numbers using methods.
	
	Structure:
		Real Number:
			The structure of real number is a very simple class that includes a float variable to represent the number.
			The methods include direct addition, subtraction, multiplication, and division operations to allow the real
			numbers to interact with each other. The toString method simply prints the float value, and the equals checks
			using the same tolerance process as complex number.
		Complex Number:
			Complex number uses overloaded methods to take in a RealNumber for each operation. The real number is treated as
			the "a" portion of the complex number, and the "b" portion remains the same.
			
Bonus 2: 
	Overview: The purpose of this class was to make the code more efficient by using common methods and variables through
	inheritance.
		
	Structure:
		Number:
			The Number abstract class contains the real number portion of it's subclasses as well as all real number operations. 
			toString and equals were different for each class, so they were not included here. Each protected method returns a 
			float for the subclasses to handle accordingly.
		RealNumber:
			Real Number uses almost strictly the Number classes varaibale/methods. It invokes each operation, but instead of returning
			a float value it returns a real number.
		ComplexNumber:
			Complex Number retains it's previous attributes, except for all real number handling is sent to the superclass. The
			operational methods take the returned float value and treat it as the "a" or real number portion.
			
Bonus Testers:
	The testers were adjusted by adding mixed tests. So, each test was duplicated, replacing the complex numbers with either 2 real
	numbers or both a real and a complex number.