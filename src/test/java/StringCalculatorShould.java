import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class StringCalculatorShould {
    private StringCalculatorProvider stringCalculator;

    @Before
    public void before() {
        stringCalculator = new StringCalculatorProvider();
    }

    @Test
    public void return_0() {
        assertThat(stringCalculator.add(""), is(0));
    }

    @Test
    public void return_1() {
        assertThat(stringCalculator.add("1"), is(1));
    }

    @Test
    public void return_2() {
        assertThat(stringCalculator.add("2"), is(2));
    }

    @Test
    public void return_3() {
        assertThat(stringCalculator.add("1,2"), is(3));
    }

    @Test
    public void return_4() {
        assertThat(stringCalculator.add("2,2"), is(4));
    }

    @Test
    public void return_27() {
        assertThat(stringCalculator.add("20,7"), is(27));
    }

    @Test
    public void return_53() {
        assertThat(stringCalculator.add("40,13"), is(53));
    }

    @Test
    public void return_99() {
        assertThat(stringCalculator.add("33,33,33"), is(99));
    }

    @Test
    public void return_55() {
        assertThat(stringCalculator.add("1,2,3,4,5,6,7,8,9,10"), is(55));
    }

    @Test
    public void return_6() {
        assertThat(stringCalculator.add("1\n2,3"), is(6));
    }
    //Support different delimiters
    //to change a delimiter, the beginning of the string will contain a separate line that looks like this:
    // “//[delimiter]\n[numbers…]” for example “//;\n1;2” should return three where the default delimiter is ‘;’ .
    @Test
    public void return_3_with_custom_delimiters() {
        assertThat(stringCalculator.add("//;\n1;2"), is(3));
    }

}
