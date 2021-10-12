/**
*
@author Brittany Bergeron
@version 0.0.1
@since 2/5/19
*
*/

/**
Class represents a complex number
*/
class ComplexNumber{
	
	//class variables	
	private float a;
	private float b;
	/**
	@param a This is the first part of the complex number (the real number portion)
	@param b This is the second part of the complex number (the immaginary part)
	*/
	
	/**
	Constructs a complex number with no parameters
	*/
	public ComplexNumber(){
		this(0.0f, 0.0f);
	}
	/**
	Constructs a complex number given two floats
	*/
	public ComplexNumber(float _a, float _b){
		this.a = _a;
		this.b = _b;
	}
	
	/**
	@return The value of A - represents the real number portion of a complex number
	*/
	public float getA(){
		return this.a;
	}
	/**
	@return The value of B - represents the immaginary number portion of a complex number
	*/
	public float getB(){
		return this.b;
	}
	
	/**
	@return The new complex number - represents the new complex number created through addition
	*/
	public ComplexNumber add(ComplexNumber otherNumber){
		//new complex to be returned
		ComplexNumber newComplex;
		//create new a and b to pass as args
		float newA = this.a + otherNumber.getA();
		float newB = this.b + otherNumber.getB();
		//create new complex
		newComplex = new ComplexNumber(newA, newB);
		
		return newComplex;
	}
	
	/**
	@return The new complex number - represents the new complex number created through subtraction
	*/
	public ComplexNumber subtract(ComplexNumber otherNumber){
		//new complex to be returned
		ComplexNumber newComplex;
		//create new a and b to pass as args
		float newA = this.a - otherNumber.getA();
		float newB = this.b - otherNumber.getB();
		//create new complex
		newComplex = new ComplexNumber(newA, newB);
		
		return newComplex;
	}

	/**
	@return The new complex number - represents the new complex number created through multiplication
	*/
	public ComplexNumber multiply(ComplexNumber otherNumber){
		//new complex to be returned
		ComplexNumber newComplex;
		//create new a and b to pass as args
		float newA = (this.a * otherNumber.getA()) - (this.b * otherNumber.getB());
		float newB = (this.b * otherNumber.getA()) + (this.a * otherNumber.getB());
		
		//create new complex
		newComplex = new ComplexNumber(newA, newB);
		
		return newComplex;
	}
	
	/**
	@return The new complex number - represents the new complex number created through division
	*/
	public ComplexNumber divide(ComplexNumber otherNumber){
		//new complex to be returned
		ComplexNumber newComplex;
		//generate denominator
		float denominator = (float)(Math.pow(otherNumber.getA(), 2) + Math.pow(otherNumber.getB(), 2));
		//create new a and b to pass as args
		float newA = ( ((this.a * otherNumber.getA()) + (this.b * otherNumber.getB())) / denominator);
		float newB = ( ((this.b * otherNumber.getA()) - (this.a * otherNumber.getB())) / denominator);
		//create new complex
		newComplex = new ComplexNumber(newA, newB);
		
		return newComplex;
	}
	
	/**
	@return The complex String  - represents the String of a complex number
	*/
	@Override
	public String toString(){
		//hold string
		String complexString = "";
		//if a (real number) is 0, don't add to string
		if(this.a != 0){
			complexString += ((this.a));
		}
		//if b is 0, don't add it and use else box to represent the 0
		if(this.b != 0){
			//if b is negative, leave plus sign out
			if(this.b < 0){
				complexString += ((this.b));
			}
			//b is positive, include plus sign
			else{
				complexString += ("+" + (this.b));
			}
			//tack on i to end
			complexString += "i";
		}
		else{
			complexString += "0.0";
		}
		return complexString;
	}
	
	/**
	@return The equality check - represents the boolean value when two complex numbers are compared
	*/
	@Override
	public boolean equals(Object z){
		//create new ComplexNumber to cast
		ComplexNumber newComplex;
		//hold boolean value as false
		boolean isEqual = false;
		
		//tolerance for error
		double tolerance = 0.0001;
		
		//check if object is a complex number, then check if values match
		if(z instanceof ComplexNumber){
			//cast to complex number
			newComplex = (ComplexNumber) z;
			//check values
			if( (Math.abs(this.a - newComplex.getA()) < tolerance ) && ( Math.abs(this.b - newComplex.getB()) < tolerance )){
				isEqual = true;
			}
		}
		return isEqual;
	}
	
	
}//end class