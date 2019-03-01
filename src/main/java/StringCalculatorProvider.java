public class StringCalculatorProvider {

  public int Add(String numbers) {
      if (numbers.length() > 1) return parseStringToNumber(numbers);
      if (numbers != "") return Integer.parseInt(numbers);
      return 0;
  }

  private int parseStringToNumber(String numbers) {
      return Integer.parseInt(numbers.split(",")[0]) + Integer.parseInt(numbers.split(",")[1]);
  }

}
