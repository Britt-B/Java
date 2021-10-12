/**
*
@author Brittany Bergeron
@version 0.0.1
@since 2/6/19
*
*/


/**
Class represents a number containing all number methods and variables
*/
public abstract class Number{
//add numbers, returns numbers
//use overloaded methods in complex with complex param

	//holds number value
	private float number;
	/**
	@param number This is the variable that represents the value of the number
	*/
	
	/**
	Constructs a number with no parameters
	*/
	public Number(){
		this(0.0f);
	}
	/**
	Constructs a number with a float
	*/
	public Number(float number){
		//set value
		this.number = number;
	}
	
	/**
	@return The number value - represents the number
	*/
	public float getNumber(){
		return this.number;
	}
	
	
	
	/**
	@return The new number - represents the new number created through addition
	*/
	protected float add(Number otherNumber){
		
		//generate new float value
		float newFloat = this.number + otherNumber.getNumber();
		//return new float
		return newFloat;
	}
	
	/**
	@return The new number - represents the new number created through subtraction
	*/
	protected float subtract(Number otherNumber){
		
		//generate new float values
		float newFloat = this.number - otherNumber.getNumber();
		//return new Float
		return newFloat;
	}
	
	/**
	@return The new number - represents the new number created through multiplication
	*/
	protected float multiply(Number otherNumber){
		
		//generate new float value
		float newFloat = this.number * otherNumber.getNumber();
		//return new float
		return newFloat;
	}
	
	/**
	@return The new number - represents the new number created through division
	*/
	protected float divide(Number otherNumber){
		
		//generate new float value
		float newFloat = this.number / otherNumber.getNumber();
		//return new float
		return newFloat;
	}

}//end class