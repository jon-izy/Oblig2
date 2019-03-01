import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculatorProvider {

  public int Add(String numbers) {
      if (numbers.length() > 1) return parseStringsToNumber(numbers);
      if (numbers != "") return Integer.parseInt(numbers);
      return 0;
  }

  private int parseStringsToNumber(String numbers) {
      List<Integer> numbersSplitted = fromStringToNumber(splitOnComma(numbers));
      return numbersSplitted.stream().reduce(0, (a, b) -> a +b);
  }

  private String[] splitOnComma(String numbers) {
      return numbers.split(",");
  }

  private List<Integer> fromStringToNumber(String[] splittedNumbers) {
      List<Integer> collect = Arrays.stream(splittedNumbers).map(number -> Integer.parseInt(number)).collect(Collectors.toList());
      return  collect;
  }

}
