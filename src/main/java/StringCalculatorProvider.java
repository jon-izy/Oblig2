import java.lang.reflect.Array;
import java.util.ArrayList;

public class StringCalculatorProvider {

  public int Add(String numbers) {
      if (numbers.length() > 1) return parseStringsToNumber(numbers);
      if (numbers != "") return Integer.parseInt(numbers);
      return 0;
  }

  private int parseStringsToNumber(String numbers) {
      String[] splittedString = splitOnComma(numbers);
      return Integer.parseInt(splittedString[0]) + Integer.parseInt(splittedString[1]);
  }

  private String[] splitOnComma(String numbers) {
      return numbers.split(",");
  }

}
