import java.util.ArrayList;
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
        checkForNegativeNumbers(numbersSplitted);
        return numbersSplitted.stream().reduce(0, (a, b) -> a + b);
    }

    private void checkForNegativeNumbers(List<Integer> numbersSplitted) {
        ArrayList<Integer> negativeNumbers = new ArrayList<>();
        for (int i = 0; i < numbersSplitted.size(); i++) {
            if (numbersSplitted.get(i) < 0) negativeNumbers.add(numbersSplitted.get(i));
        }
        if (negativeNumbers.size() > 0) throw new NegativesNumbersException("negatives not allowed: " + negativeNumbers);

    }

    private String[] splitOnComma(String numbers) {
        String delimiters;
        if (numbers.startsWith("/")) {
            String customDelimiter = "" + numbers.charAt(2);
            delimiters = "\n|" + customDelimiter;
            return numbers.substring(3).replaceAll("\\s+", "").split(delimiters);
        } else {
            delimiters = "\\,|\n";
            return numbers.split(delimiters);
        }
    }

    private List<Integer> fromStringToNumber(String[] splittedNumbers) {
        List<Integer> stringsToNumbers = Arrays
                .stream(splittedNumbers)
                .map(number -> Integer.parseInt(number))
                .collect(Collectors.toList());

        return stringsToNumbers;
    }

    private int IntOrException(String number) {
        int stringToNumber = Integer.parseInt(number);
        return stringToNumber;
    }

    public class NegativesNumbersException extends IllegalArgumentException {
        public NegativesNumbersException(String message) {
            super(message);
        }
    }

}