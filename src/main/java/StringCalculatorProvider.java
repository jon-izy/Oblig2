public class StringCalculatorProvider {

  public int Add(String numbers) {
      if (numbers.length() > 1) return parseStringsToNumber(numbers);
      if (numbers != "") return Integer.parseInt(numbers);
      return 0;
  }

  private int parseStringsToNumber(String numbers) {
      String[] splittedString = splitOnComma(numbers);
      int sum = 0;
      for (int i = 0; i < splittedString.length; i ++) {
        sum += Integer.parseInt(splittedString[i]);
      }
      return sum;
  }

  private String[] splitOnComma(String numbers) {
      return numbers.split(",");
  }

}
