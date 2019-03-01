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
}
