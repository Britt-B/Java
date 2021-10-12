public class RealNumber extends Number{
	
	
	public RealNumber(){
		this(0.0f);
	}
	public RealNumber(float number){
		super(number);
	}
	
	/**
	@return The new real number created by invoking the super class add method
	*/
	public RealNumber add(RealNumber number){
		//create new real
		RealNumber newReal = new RealNumber(super.add(number));
		//return
		return newReal;
	}
	
	/**
	@return The new real number created by invoking the super class subtract method
	*/
	public RealNumber subtract(RealNumber number){
		//create new real
		RealNumber newReal = new RealNumber(super.subtract(number));
		//return
		return newReal;
	}
	
	/**
	@return The new real number created by invoking the super class mutiply method
	*/
	public RealNumber multiply(RealNumber number){
		//create new real
		RealNumber newReal = new RealNumber(super.multiply(number));
		//return
		return newReal;
	}
	
	/**
	@return The new real number created by invoking the super class divide method
	*/
	public RealNumber divide(RealNumber number){
		//create new real
		RealNumber newReal = new RealNumber(super.divide(number));
		//return
		return newReal;
	}
	
	/**
	@return The number String  - represents the String of a number
	*/
	@Override
	public String toString(){
		//convert to string
		String numberString = ("" + this.getNumber());
		//return
		return numberString;
	}
	
	/**
	@return The equality check - represents the boolean value when two numbers are compared
	*/
	@Override
		public boolean equals(Object z){
		//create new number to cast
		Number newNumber;
		//hold boolean value as false
		boolean isEqual = false;
		
		//tolerance for error
		double tolerance = 0.0001;
		
		//check if object is a number, then check if values match
		if(z instanceof Number){
			//cast to number
			newNumber = (Number) z;
			//check values
			if(Math.abs(super.getNumber() - newNumber.getNumber()) < tolerance ){
				isEqual = true;
			}
		}
		return isEqual;
	}
}