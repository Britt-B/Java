import static org.junit.Assert.*;
import org.junit.*;

public class ComplexNumberTester{

	//test fixture; declare private variables for complex numbers
	private ComplexNumber complexNumber1;
	private ComplexNumber complexNumber2;
	private ComplexNumber complexNumber3;
	private ComplexNumber complexNumber4;
	private ComplexNumber complexNumber5;
	
	//declare private variables for real numbers
	private RealNumber realNumber1;
	private RealNumber realNumber2;
	private RealNumber realNumber3;
	private RealNumber realNumber4;
	private RealNumber realNumber5;
	
	
	//create a range to determine decimal equivalence from rounding errors
	private static final float TOLERANCE = 0.0001f;
	
	//use to store values after operations to be compared
	private ComplexNumber complexHolder = new ComplexNumber();
	private RealNumber realHolder = new RealNumber();
		
	
	
	//create several test objects, including negatives and decimals
	@Before
	public void setup(){
		//complex numbers
		complexNumber1 = new ComplexNumber();
		complexNumber2 = new ComplexNumber(10, 20);
		complexNumber3 = new ComplexNumber(-10, 3);
		complexNumber4 = new ComplexNumber(40, -100);
		complexNumber5 = new ComplexNumber(50.1f, -50.2f);
		
		//real numbers
		realNumber1 = new RealNumber();
		realNumber2 = new RealNumber(15);
		realNumber3 = new RealNumber(-50);
		realNumber4 = new RealNumber(2.5f);
		realNumber5 = new RealNumber(-4.5f);
		
	}
	
	//test checks construction, and both queries (getA and getB)
	@Test
	public void testConstruction(){
		//complex numbers
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
		
		//realnumbers
		assertEquals(0, realNumber1.getRealNumber(), TOLERANCE);
		assertEquals(15, realNumber2.getRealNumber(), TOLERANCE);
		assertEquals(-50, realNumber3.getRealNumber(), TOLERANCE);
		assertEquals(2.5, realNumber4.getRealNumber(), TOLERANCE);
		assertEquals(-4.5, realNumber5.getRealNumber(), TOLERANCE);
		
	}
	
	//add
	//complex numbers only
	@Test
	public void testComplexOnlyAdd(){
		
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
	//real numbers only
	@Test
	public void testRealOnlyAdd(){
		
		//add 1 and 2 together, check values
		realHolder = realNumber1.add(realNumber2);
		assertEquals(15, realHolder.getRealNumber(), TOLERANCE);
		
		//add 3 and 4 together, check values
		realHolder = realNumber3.add(realNumber4);
		assertEquals(-47.5, realHolder.getRealNumber(), TOLERANCE);
		
		//add 4 and 5 together, check values
		realHolder = realNumber4.add(realNumber5);
		assertEquals(-2, realHolder.getRealNumber(), TOLERANCE);
	}
	//complex and real
	@Test
	public void testBothAdd(){
		
		//add 1 and 1 together, check values
		complexHolder = complexNumber1.add(realNumber1);
		assertEquals(0, complexHolder.getA(), TOLERANCE);
		assertEquals(0, complexHolder.getB(), TOLERANCE);
		
		//add 2 and 2, check
		complexHolder = complexNumber2.add(realNumber2);
		assertEquals(25, complexHolder.getA(), TOLERANCE);
		assertEquals(20, complexHolder.getB(), TOLERANCE);
		
		//add 3 and 3, check
		complexHolder = complexNumber3.add(realNumber3);
		assertEquals(-60, complexHolder.getA(), TOLERANCE);
		assertEquals(3, complexHolder.getB(), TOLERANCE);
		
		//add 4 and 4, check
		complexHolder = complexNumber4.add(realNumber4);
		assertEquals(42.5, complexHolder.getA(), TOLERANCE);
		assertEquals(-100, complexHolder.getB(), TOLERANCE);
		
		//add 5 and 5, check
		complexHolder = complexNumber5.add(realNumber5);
		assertEquals(45.6, complexHolder.getA(), TOLERANCE);
		assertEquals(-50.2, complexHolder.getB(), TOLERANCE);
		
	}
	
	//subtract
	//complex numbers only
	@Test
	public void testComplexOnlySubtract(){
		
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
	//real numbers only
	@Test
	public void testRealOnlySubtract(){
		
		//subtract 1 and 2, check values
		realHolder = realNumber1.subtract(realNumber2);
		assertEquals(-15, realHolder.getRealNumber(), TOLERANCE);
		
		//subtract 3 and 4, check values
		realHolder = realNumber3.subtract(realNumber4);
		assertEquals(-52.5, realHolder.getRealNumber(), TOLERANCE);
		
		//subtract 4 and 5, check values
		realHolder = realNumber4.subtract(realNumber5);
		assertEquals(7, realHolder.getRealNumber(), TOLERANCE);
	}
	//complex and real
	@Test
	public void testBothSubtract(){
		
		//subtract 1 and 1 together, check values
		complexHolder = complexNumber1.subtract(realNumber1);
		assertEquals(0, complexHolder.getA(), TOLERANCE);
		assertEquals(0, complexHolder.getB(), TOLERANCE);
		
		//subtract 2 and 2, check
		complexHolder = complexNumber2.subtract(realNumber2);
		assertEquals(-5, complexHolder.getA(), TOLERANCE);
		assertEquals(20, complexHolder.getB(), TOLERANCE);
		
		//subtract 3 and 3, check
		complexHolder = complexNumber3.subtract(realNumber3);
		assertEquals(40, complexHolder.getA(), TOLERANCE);
		assertEquals(3, complexHolder.getB(), TOLERANCE);
		
		//subtract 4 and 4, check
		complexHolder = complexNumber4.subtract(realNumber4);
		assertEquals(37.5, complexHolder.getA(), TOLERANCE);
		assertEquals(-100, complexHolder.getB(), TOLERANCE);
		
		//subtract 5 and 5, check
		complexHolder = complexNumber5.subtract(realNumber5);
		assertEquals(54.6, complexHolder.getA(), TOLERANCE);
		assertEquals(-50.2, complexHolder.getB(), TOLERANCE);
		
	}
	
	//multiply
	//complex numbers only
	@Test
	public void testComplexOnlyMultiply(){
		
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
	//real numbers only
	@Test
	public void testRealOnlyMultiply(){
		
		//multiply 1 and 2 together, check values
		realHolder = realNumber1.multiply(realNumber2);
		assertEquals(0, realHolder.getRealNumber(), TOLERANCE);
		
		//multiply 3 and 4 together, check values
		realHolder = realNumber3.multiply(realNumber4);
		assertEquals(-125, realHolder.getRealNumber(), TOLERANCE);
		
		//multiply 4 and 5 together, check values
		realHolder = realNumber4.multiply(realNumber5);
		assertEquals(-11.25, realHolder.getRealNumber(), TOLERANCE);
	}
	//complex and real
	@Test
	public void testBothMultiply(){
		
		//multiply 1 and 1 together, check values
		complexHolder = complexNumber1.multiply(realNumber1);
		assertEquals(0, complexHolder.getA(), TOLERANCE);
		assertEquals(0, complexHolder.getB(), TOLERANCE);
		
		//multiply 2 and 2, check
		complexHolder = complexNumber2.multiply(realNumber2);
		assertEquals(150, complexHolder.getA(), TOLERANCE);
		assertEquals(20, complexHolder.getB(), TOLERANCE);
		
		//multiply 3 and 3, check
		complexHolder = complexNumber3.multiply(realNumber3);
		assertEquals(500, complexHolder.getA(), TOLERANCE);
		assertEquals(3, complexHolder.getB(), TOLERANCE);
		
		//multiply 4 and 4, check
		complexHolder = complexNumber4.multiply(realNumber4);
		assertEquals(100, complexHolder.getA(), TOLERANCE);
		assertEquals(-100, complexHolder.getB(), TOLERANCE);
		
		//multiply 5 and 5, check
		complexHolder = complexNumber5.multiply(realNumber5);
		assertEquals(-225.45, complexHolder.getA(), TOLERANCE);
		assertEquals(-50.2, complexHolder.getB(), TOLERANCE);
		
	}
	
	//divide
	//complex numbers only
	@Test
	public void testComplexOnlyDivide(){
		
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
	//real numbers only
	@Test
	public void testRealOnlyDivide(){
		
		//divide 1 and 2, check values
		realHolder = realNumber1.divide(realNumber2);
		assertEquals(0, realHolder.getRealNumber(), TOLERANCE);
		
		//divide 3 and 4, check values
		realHolder = realNumber3.divide(realNumber4);
		assertEquals(-20, realHolder.getRealNumber(), TOLERANCE);
		
		//divide 4 and 5, check values
		realHolder = realNumber4.divide(realNumber5);
		assertEquals(-0.5556f, realHolder.getRealNumber(), TOLERANCE);
	}
	//complex and real
	@Test
	public void testBothDivide(){
		
		//divide 1 and 1 together, check values
		complexHolder = complexNumber1.divide(realNumber1);
		assertEquals(0, complexHolder.getA(), TOLERANCE);
		assertEquals(0, complexHolder.getB(), TOLERANCE);
		
		//divide 2 and 2, check
		complexHolder = complexNumber2.divide(realNumber2);
		assertEquals(0.6667f, complexHolder.getA(), TOLERANCE);
		assertEquals(20, complexHolder.getB(), TOLERANCE);
		
		//divide 3 and 3, check
		complexHolder = complexNumber3.divide(realNumber3);
		assertEquals(0.2f, complexHolder.getA(), TOLERANCE);
		assertEquals(3, complexHolder.getB(), TOLERANCE);
		
		//divide 4 and 4, check
		complexHolder = complexNumber4.divide(realNumber4);
		assertEquals(16, complexHolder.getA(), TOLERANCE);
		assertEquals(-100, complexHolder.getB(), TOLERANCE);
		
		//divide 5 and 5, check
		complexHolder = complexNumber5.divide(realNumber5);
		assertEquals(-11.1333f, complexHolder.getA(), TOLERANCE);
		assertEquals(-50.2f, complexHolder.getB(), TOLERANCE);
		
	}
	
	//complex toString
	@Test
	public void testComplexToString(){
		
		//make sure negative numbers, decimals, and i shows up accordingly
		assertEquals(complexNumber1.toString(), "0.0");
		
		assertEquals(complexNumber2.toString(), "10.0+20.0i");
		
		assertEquals(complexNumber3.toString(), "-10.0+3.0i");
		
		assertEquals(complexNumber4.toString(), "40.0-100.0i");
		
		assertEquals(complexNumber5.toString(), "50.1-50.2i");
		
		
	}
	@Test
	//real number toString
	public void testRealToString(){
		
		//check each instance for signs, decimals, etc
		assertEquals(realNumber1.toString(), "0.0");
		
		assertEquals(realNumber2.toString(), "15.0");
		
		assertEquals(realNumber3.toString(), "-50.0");
		
		assertEquals(realNumber4.toString(), "2.5");
		
		assertEquals(realNumber5.toString(), "-4.5");
	}
	
	//complex equals
	@Test
	public void testComplexEquals(){
		
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
	//real equals
	@Test
	public void testRealEquals(){
		//use holder to check each case
		realHolder = realNumber1;
		assertTrue(realNumber1.equals(realHolder));
		
		realHolder = realNumber2;
		assertTrue(realNumber2.equals(realHolder));
		
		realHolder = realNumber3;
		assertTrue(realNumber3.equals(realHolder));
		
		realHolder = realNumber4;
		assertTrue(realNumber4.equals(realHolder));
		
		realHolder = realNumber5;
		assertTrue(realNumber5.equals(realHolder));
	}
	
}//end class