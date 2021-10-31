package stringcalculator;

import org.junit.Test;
import org.junit.Assert;

public class StringCalculatorTest {
    private StringCalculatorProvider stringCalculator;

    // testCase 1 & 2:
    @Test
    public void StringCalculator_Add_NumberString_ReturnesSumOfIntegers(){

        // Setup-part:
        String[] testValues = {"","1","1,2,3"};

        // Expected results:
        int[] expectedValues = {0,1,6};

        // Arrange-part:
        stringCalculator = new StringCalculatorProvider();
        int[] actualValues = {stringCalculator.add(testValues[0]),
                stringCalculator.add(testValues[1]),
                stringCalculator.add(testValues[2])};

        // Assert-part:
        Assert.assertArrayEquals(expectedValues,actualValues);

    }

    // TODO: lag navn på enhetstest og implementer test for case 3
    // Format for name convention in unit-test methods:
    // public void Application_method_input_output()
    @Test
    public void testCase3(){
        // testCase3: "1\n2,3" add => 6

        String testValue = "";
        int expectedValue = 6;  //result

        stringCalculator = new StringCalculatorProvider();

        int actualValue = stringCalculator.add(testValue);

        Assert.assertEquals(expectedValue,actualValue);

    }

    // TODO: lag navn på enhetstest og implementer test for case 4
    // Format for name convention in unit-test methods:
    // public void Application_method_input_output()
    @Test
    public void case4() {
        // testCase4: "//[delimiter]\n[numbers…]"
        int expectedValue = 0;
        int actualValue = 1;

        Assert.assertEquals(expectedValue,actualValue);
    }

    // TODO: lag navn på enhetstest og implementer test for case 5
    // Format for name convention in unit-test methods:
    // public void Application_method_input_output()
    @Test
    public void testCase5() {
        // case5: Calling Add with a negative number will throw an exception “negatives not allowed”
        int expectedValue = 0;
        int actualValue = 1;

        Assert.assertEquals(expectedValue,actualValue);
    }

    // TODO: lag navn på enhetstest og implementer test for case 6
    // Format for name convention in unit-test methods:
    // public void Application_method_input_output()
    @Test
    public void testCase6() {
        // case6: Numbers bigger than 1000 should be ignored, so adding 2 + 1001 = 2
        int expectedValue = 0;
        int actualValue = 1;

        Assert.assertEquals(expectedValue,actualValue);
    }

}

