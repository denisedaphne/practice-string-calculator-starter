package com.tw;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public int add(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        String delimiter = ",|\n";
        String numbers = input;

        if (input.startsWith("//")) {
            Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
            if (matcher.find()) {
                delimiter = Pattern.quote(matcher.group(1));
                numbers = matcher.group(2);
            }
        }

        String[] numberArray = numbers.split(delimiter);
        int sum = 0;

        for (String number : numberArray) {
            sum += Integer.parseInt(number);
        }

        return sum;
    }
}
