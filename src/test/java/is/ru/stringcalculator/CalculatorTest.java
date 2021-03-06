package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}	

	@Test
    public void testMultipleNumbers(){
    	assertEquals(6, Calculator.add("1,2,3"));
    	}

	@Test
        public void testNewLine(){
        assertEquals(6, Calculator.add("1\n2,3"));
        }

	@Test
	public void testDelimiter(){
	String crit = "/" + "/" +";\n1;2";
	assertEquals(3, Calculator.add(crit));
	}

	@Test (expected=IllegalArgumentException.class)
	public void testNegatives(){
        Calculator.add("-1, 2, -3");
	}

	@Test
	public void testLargerThenThousand(){
	boolean  ifOver = true;
	boolean hasOver = Calculator.hasOverThousand("1001,2");
	assertEquals(ifOver, hasOver);
	}

	@Test
	public void testRemoverThousand(){
	assertEquals(25, Calculator.add("1123,20,5"));
	}
}

