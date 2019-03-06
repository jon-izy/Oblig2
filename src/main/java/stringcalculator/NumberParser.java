package stringcalculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberParser {
    public NumberParser() {
    }

    private String[] splitOnComma(String numbers) {
        String delimiters;
        if (numbers.startsWith("/")) {
            int START_OF_SUBSTRING = numbers.indexOf("\n") + 1;
            String specialDelimiter = numbers.replace("//", "").replace("\n.*", "");
            System.out.println(specialDelimiter);
            if (specialDelimiter.length() > 1) System.out.println("specialDelimiter = " + specialDelimiter);
            String customDelimiter = "" + numbers.charAt(2);
            delimiters = "" + customDelimiter;
            return numbers.substring(START_OF_SUBSTRING).split(delimiters);
        } else {
            delimiters = "[,\n]";
            return numbers.split(delimiters);
        }
    }

    List<Integer> fromStringToNumber(String numbers) {

        return Arrays
                .stream(splitOnComma(numbers))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}