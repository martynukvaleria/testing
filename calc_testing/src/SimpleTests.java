import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class SimpleTests {
    @Test
    public void testAddition() {
        double result = Calculator.calculateResult(5, '+', 3);
        Assert.assertEquals(result, 8.0, "Addition test failed");
    }

    @Test
    public void testSubtraction() {
        double result = Calculator.calculateResult(10, '-', 4);
        Assert.assertEquals(result, 6.0, "Subtraction test failed");
    }

    @Test
    public void testMultiplication() {
        double result = Calculator.calculateResult(6, '*', 2);
        Assert.assertEquals(result, 12.0, "Multiplication test failed");
    }

    @Test
    public void testDivision() {
        double result = Calculator.calculateResult(8, '/', 2);
        Assert.assertEquals(result, 4.0, "Division test failed");
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testDivisionByZero() {
        Calculator.calculateResult(10, '/', 0);
    }
}
