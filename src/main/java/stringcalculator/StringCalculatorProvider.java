package stringcalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class StringCalculatorProvider {

    int add(String numbers) {
        if (numbers.isEmpty()) return 0;
        return adding(numbers);
    }

    private int adding(String numbers) {
        List<Integer> numbersSplit = fromStringToNumber(splitOnComma(numbers));
        checkForNegativeNumbers(numbersSplit);
        return numbersSplit.stream().reduce(0, (a, b) -> a + b);
    }

    private void checkForNegativeNumbers(List<Integer> numbersSplit) {
        ArrayList<Integer> negativeNumbers = new ArrayList<>();
        for (Integer integer : numbersSplit) {
            if (integer < 0) negativeNumbers.add(integer);
        }
        if (negativeNumbers.size() > 0) throw new NegativesNumbersException("negatives not allowed: " +  negativeNumbers);

    }

    private String[] splitOnComma(String numbers) {
        String delimiters;
        if (numbers.startsWith("/")) {
            String customDelimiter = "" + numbers.charAt(2);
            delimiters = "\n|" + customDelimiter;
            return numbers.substring(3).replaceAll("\\s+", "").split(delimiters);
        } else {
            delimiters = "[,\n]";
            return numbers.split(delimiters);
        }
    }

    private List<Integer> fromStringToNumber(String[] splitNumbers) {
        return Arrays
                .stream(splitNumbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    class NegativesNumbersException extends IllegalArgumentException {
        NegativesNumbersException(String message) {
            super(message);
        }
    }

}