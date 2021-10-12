/**
*
@author Brittany Bergeron
@version 0.0.1
@since 2/5/19
*
*/

/**
Class represents a real number
*/
public class RealNumber{
	//holds number value
	private float realNumber;
	/**
	@param realNumber This is the variable that represents the value of the real number
	*/
	
	/**
	Constructs a real number with no parameters
	*/
	public RealNumber(){
		this(0.0f);
	}
	/**
	Constructs a real number with a float
	*/
	public RealNumber(float realNumber){
		//set value
		this.realNumber = realNumber;
	}
	
	/**
	@return The realNumber value - represents the real number
	*/
	public float getRealNumber(){
		return this.realNumber;
	}
	
	
	
	/**
	@return The new real number - represents the new real number created through addition
	*/
	public RealNumber add(RealNumber otherReal){
		//new real to be  returned
		RealNumber newReal;
		//generate new float value
		float newFloat = this.realNumber + otherReal.getRealNumber();
		//give newReal parameter and return
		newReal = new RealNumber(newFloat);
		return newReal;
	}
	
	/**
	@return The new real number - represents the new real number created through subtraction
	*/
	public RealNumber subtract(RealNumber otherReal){
		//new real to be  returned
		RealNumber newReal;
		//generate new float value
		float newFloat = this.realNumber - otherReal.getRealNumber();
		//give newReal parameter and return
		newReal = new RealNumber(newFloat);
		return newReal;
	}
	
	/**
	@return The new real number - represents the new real number created through multiplication
	*/
	public RealNumber multiply(RealNumber otherReal){
		//new real to be  returned
		RealNumber newReal;
		//generate new float value
		float newFloat = this.realNumber * otherReal.getRealNumber();
		//give newReal parameter and return
		newReal = new RealNumber(newFloat);
		return newReal;
	}
	
	/**
	@return The new real number - represents the new real number created through division
	*/
	public RealNumber divide(RealNumber otherReal){
		//new real to be  returned
		RealNumber newReal;
		//generate new float value
		float newFloat = this.realNumber / otherReal.getRealNumber();
		//give newReal parameter and return
		newReal = new RealNumber(newFloat);
		return newReal;
	}
	
	/**
	@return The real String  - represents the String of a real number
	*/
	@Override
	public String toString(){
		//convert to string
		String realString = ("" + this.realNumber);
		//return
		return realString;
	}
	
	/**
	@return The equality check - represents the boolean value when two real numbers are compared
	*/
	@Override
		public boolean equals(Object z){
		//create new RealNumber to cast
		RealNumber newReal;
		//hold boolean value as false
		boolean isEqual = false;
		
		//tolerance for error
		double tolerance = 0.0001;
		
		//check if object is a real number, then check if values match
		if(z instanceof RealNumber){
			//cast to real number
			newReal = (RealNumber) z;
			//check values
			if(Math.abs(this.realNumber - newReal.getRealNumber()) < tolerance ){
				isEqual = true;
			}
		}
		return isEqual;
	}

}//end class