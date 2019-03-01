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
        assertThat(stringCalculator.Add(""), is(0));
    }

    @Test
    public void return_1() {
        assertThat(stringCalculator.Add("1"), is(1));
    }

    @Test
    public void return_2() {
        assertThat(stringCalculator.Add("2"), is(2));
    }

    @Test
    public void return_3() {
        assertThat(stringCalculator.Add("1,2"), is(3));
    }

    @Test
    public void return_4() {
        assertThat(stringCalculator.Add("2,2"), is(4));
    }

    @Test
    public void return_27() {
        assertThat(stringCalculator.Add("20,7"), is(27));
    }

    @Test
    public void return_53() {
        assertThat(stringCalculator.Add("40,13"), is(53));
    }

    @Test
    public void return_99() {
        assertThat(stringCalculator.Add("33,33,33"), is(99));
    }
}
