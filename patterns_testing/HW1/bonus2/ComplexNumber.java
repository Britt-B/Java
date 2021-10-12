/**
*
@author Brittany Bergeron
@version 0.0.1
@since 2/6/19
*
*/

/**
Class represents a complex number
*/
class ComplexNumber extends Number{
	
	//class variables	
	private float b;
	/**
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
		//real number portion goes to number constructor
		super(_a);
		this.b = _b;
	}
	
	/**
	@return The value of A - represents the real number portion (from Number class) of a complex number
	*/
	public float getA(){
		return super.getNumber();
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
		float newA = this.getNumber() + otherNumber.getA();
		float newB = this.b + otherNumber.getB();
		//create new complex
		newComplex = new ComplexNumber(newA, newB);
		
		return newComplex;
	}
	/**
	@return The new Complex number created using the superclass Number's add method
	*/
	public ComplexNumber add(RealNumber otherNumber){
		//determine the real number portion with the super class method
		float newReal = super.add(otherNumber);
		//create complex to be returned
		ComplexNumber newComplex = new ComplexNumber(newReal, this.b);
		
		return newComplex;
		
	}
	
	/**
	@return The new complex number - represents the new complex number created through subtraction
	*/
	public ComplexNumber subtract(ComplexNumber otherNumber){
		//new complex to be returned
		ComplexNumber newComplex;
		//create new a and b to pass as args
		float newA = this.getNumber() - otherNumber.getA();
		float newB = this.b - otherNumber.getB();
		//create new complex
		newComplex = new ComplexNumber(newA, newB);
		
		return newComplex;
	}
	/**
	@return The new Complex number created using the superclass Number's subtract method
	*/
	public ComplexNumber subtract(RealNumber otherNumber){
		//determine the real number portion with the super class method
		float newReal = super.subtract(otherNumber);
		//create complex to be returned
		ComplexNumber newComplex = new ComplexNumber(newReal, this.b);
		
		return newComplex;
		
	}

	/**
	@return The new complex number - represents the new complex number created through multiplication
	*/
	public ComplexNumber multiply(ComplexNumber otherNumber){
		//new complex to be returned
		ComplexNumber newComplex;
		//create new a and b to pass as args
		float newA = (this.getNumber() * otherNumber.getA()) - (this.b * otherNumber.getB());
		float newB = (this.b * otherNumber.getA()) + (this.getNumber() * otherNumber.getB());
		
		//create new complex
		newComplex = new ComplexNumber(newA, newB);
		
		return newComplex;
	}
	/**
	@return The new Complex number created using the superclass Number's multiply method
	*/
	public ComplexNumber multiply(RealNumber otherNumber){
		//determine the real number portion with the super class method
		float newReal = super.multiply(otherNumber);
		//create complex to be returned
		ComplexNumber newComplex = new ComplexNumber(newReal, this.b);
		
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
		float newA = ( ((this.getNumber() * otherNumber.getA()) + (this.b * otherNumber.getB())) / denominator);
		float newB = ( ((this.b * otherNumber.getA()) - (this.getNumber() * otherNumber.getB())) / denominator);
		//create new complex
		newComplex = new ComplexNumber(newA, newB);
		
		return newComplex;
	}
	/**
	@return The new Complex number created using the superclass Number's divide method
	*/
	public ComplexNumber divide(RealNumber otherNumber){
		float newReal = 0;
		//can't divide by 0
		if(0 != otherNumber.getNumber()){
			//determine the real number portion with the super class method
			newReal = super.divide(otherNumber);
		}
		//set real value to 0
		else{
			System.out.println("You can not divide by zero. The real number portion has been set to 0.");	
			newReal = 0;
		}
		;
		//create complex to be returned
		ComplexNumber newComplex = new ComplexNumber(newReal, this.b);
		
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
		if(this.getNumber() != 0){
			complexString += ((this.getNumber()));
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
			if( (Math.abs(this.getNumber() - newComplex.getNumber()) < tolerance ) && ( Math.abs(this.b - newComplex.getB()) < tolerance ) ){
				isEqual = true;
			}
		}
		return isEqual;
	}
	
	
}//end class