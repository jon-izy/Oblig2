import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculatorProvider {

  public int add(String numbers) {
      if (numbers.isEmpty()) return 0;
      return adding(numbers);
  }

  private int adding(String numbers) {
      List<Integer> numbersSplitted = fromStringToNumber(splitOnComma(numbers));
      return numbersSplitted.stream().reduce(0, (a, b) -> a +b);
  }

  private String[] splitOnComma(String numbers) {
      return numbers.split(",");
  }

  private List<Integer> fromStringToNumber(String[] splittedNumbers) {
      return Arrays.stream(splittedNumbers).map(number -> Integer.parseInt(number)).collect(Collectors.toList());
  }

}
