import static org.junit.Assert.*;
import org.junit.*;

public class ComplexNumberTester{

	//test fixture; declare private variables
	private ComplexNumber complexNumber1;
	private ComplexNumber complexNumber2;
	private ComplexNumber complexNumber3;
	private ComplexNumber complexNumber4;
	private ComplexNumber complexNumber5;
	
	//create a range to determine decimal equivalence from rounding errors
	private static final float TOLERANCE = 0.0001f;
	
	//use to store values after operations to be compared
	private ComplexNumber complexHolder = new ComplexNumber();
		
	
	
	//create several test objects, including negatives and decimals
	@Before
	public void setup(){
		complexNumber1 = new ComplexNumber();
		complexNumber2 = new ComplexNumber(10, 20);
		complexNumber3 = new ComplexNumber(-10, 3);
		complexNumber4 = new ComplexNumber(40, -100);
		complexNumber5 = new ComplexNumber(50.1f, -50.2f);
		
	}
	
	//test checks construction, and both queries (getA and getB)
	@Test
	public void testConstruction(){
		
		assertEquals(0, complexNumber1.getA(), TOLERANCE);
		assertEquals(0, complexNumber1.getB(), TOLERANCE);
		
		assertEquals(10, complexNumber2.getA(), TOLERANCE);
		assertEquals(20, complexNumber2.getB(), TOLERANCE);
		
		assertEquals(-10, complexNumber3.getA(), TOLERANCE);
		assertEquals(3, complexNumber3.getB(), TOLERANCE);
		
		assertEquals(40, complexNumber4.getA(), TOLERANCE);
		assertEquals(-100, complexNumber4.getB(), TOLERANCE);
		
		assertEquals(50.1, complexNumber5.getA(), TOLERANCE);
		assertEquals(-50.2, complexNumber5.getB(), TOLERANCE);
		
	}
	
	//add
	@Test
	public void testAdd(){
		
		//add 1 and 2 together, check values
		complexHolder = complexNumber1.add(complexNumber2);
		assertEquals(10, complexHolder.getA(), TOLERANCE);
		assertEquals(20, complexHolder.getB(), TOLERANCE);
		
		//add 3 and 4, check
		complexHolder = complexNumber3.add(complexNumber4);
		assertEquals(30, complexHolder.getA(), TOLERANCE);
		assertEquals(-97, complexHolder.getB(), TOLERANCE);
		
		//add 4 and 5, check
		complexHolder = complexNumber4.add(complexNumber5);
		assertEquals(90.1, complexHolder.getA(), TOLERANCE);
		assertEquals(-150.2, complexHolder.getB(), TOLERANCE);
	}
	
	//subtract
	@Test
	public void testSubtract(){
		
		//subtract 1 and 2 together, check values
		complexHolder = complexNumber1.subtract(complexNumber2);
		assertEquals(-10, complexHolder.getA(), TOLERANCE);
		assertEquals(-20, complexHolder.getB(), TOLERANCE);
		
		//subtract 3 and 4, check
		complexHolder = complexNumber3.subtract(complexNumber4);
		assertEquals(-50, complexHolder.getA(), TOLERANCE);
		assertEquals(103, complexHolder.getB(), TOLERANCE);
		
		//subtract 4 and 5, check
		complexHolder = complexNumber4.subtract(complexNumber5);
		assertEquals(-10.1, complexHolder.getA(), TOLERANCE);
		assertEquals(-49.8, complexHolder.getB(), TOLERANCE);
	}
	
	//multiply
	@Test
	public void testMultiply(){
		
		//multiply 1 and 2 together, check values
		complexHolder = complexNumber1.multiply(complexNumber2);
		assertEquals(0, complexHolder.getA(), TOLERANCE);
		assertEquals(0, complexHolder.getB(), TOLERANCE);
		
		//multiply 3 and 4, check
		complexHolder = complexNumber3.multiply(complexNumber4);
		assertEquals(-100, complexHolder.getA(), TOLERANCE);
		assertEquals(1120, complexHolder.getB(), TOLERANCE);
		
		//multiply 4 and 5, check
		complexHolder = complexNumber4.multiply(complexNumber5);
		assertEquals(-3016, complexHolder.getA(), TOLERANCE);
		assertEquals(-7018, complexHolder.getB(), TOLERANCE);
	}
	
	//divide
	@Test
	public void testDivide(){
		
		//divide 1 and 2 together, check values
		complexHolder = complexNumber1.divide(complexNumber2);
		assertEquals(0, complexHolder.getA(), TOLERANCE);
		assertEquals(0, complexHolder.getB(), TOLERANCE);
		
		//divide 3 and 4, check
		complexHolder = complexNumber3.divide(complexNumber4);
		assertEquals(-0.0603f, complexHolder.getA(), TOLERANCE);
		assertEquals(-0.0759f, complexHolder.getB(), TOLERANCE);
		
		//divide 4 and 5, check
		complexHolder = complexNumber4.divide(complexNumber5);
		assertEquals(1.3964f, complexHolder.getA(), TOLERANCE);
		assertEquals(-0.5968f, complexHolder.getB(), TOLERANCE);
		
	}
	
	//toString
	@Test
	public void testToString(){
		
		//make sure negative numbers, decimals, and i shows up accordingly
		assertEquals(complexNumber1.toString(), "0.0");
		
		assertEquals(complexNumber2.toString(), "10.0+20.0i");
		
		assertEquals(complexNumber3.toString(), "-10.0+3.0i");
		
		assertEquals(complexNumber4.toString(), "40.0-100.0i");
		
		assertEquals(complexNumber5.toString(), "50.1-50.2i");
		
		
	}
	
	//equals
	@Test
	public void testEquals(){
		
		//use the complexHolder variable to check all cases
		complexHolder = complexNumber1;
		assertTrue(complexNumber1.equals(complexHolder));
		
		complexHolder = complexNumber2;
		assertTrue(complexNumber2.equals(complexHolder));
		
		complexHolder = complexNumber3;
		assertTrue(complexNumber3.equals(complexHolder));
		
		complexHolder = complexNumber4;
		assertTrue(complexNumber4.equals(complexHolder));
		
		complexHolder = complexNumber5;
		assertTrue(complexNumber5.equals(complexHolder));
		
		//just to be sure, throwing in an assert false
		assertFalse(complexNumber1.equals(complexHolder));
		
	}
}//end class