package com.test.lettercombination.utils;

import com.test.lettercombination.beans.DigitLettersList;

import java.util.Arrays;
import java.util.Map;

public class ConvertUtils {

    /**
     * Convert digit array into DigitLettersList ( 0 to 9)
     * @param digits
     * @param digitLettersMap
     * @return
     */
    public static DigitLettersList convertDigit0To9(Integer[] digits, Map<Integer, String[]> digitLettersMap) {

        DigitLettersList digitLettersList = new DigitLettersList();

        Arrays.stream(digits).forEach(digit -> digitLettersList.add(digitLettersMap.get(digit)));

        return digitLettersList;
    }

    /**
     * Convert digit array into DigitLettersList ( 0 to 99)
     * i.e Digit 23's letters will be "a, b, c, d, e, f ".
     *     Digit 2 (a, b, c) + Digit 3 (d, e, f)
     *
     *
     * @param digits
     * @param digitLettersMap
     * @return
     */
    public static DigitLettersList convertDigit0To99(Integer[] digits, Map<Integer, String[]> digitLettersMap) {

        DigitLettersList digitLettersList = new DigitLettersList();

        Arrays.stream(digits).forEach(digit -> {

            // If input digit range is 0-9
            if (digitLettersMap.containsKey(digit)) {
                digitLettersList.add(digitLettersMap.get(digit));
            }
            // If input digit range is 10-99
            else {
                String[] letters = null;

                int quotient = digit / 10;
                int remainder = digit % 10;

                if (digitLettersMap.containsKey(quotient) && digitLettersMap.containsKey(remainder)) {
                    if (quotient != remainder) {
                        String[] quotientLetters = digitLettersMap.get(quotient);
                        String[] remainderLetters = digitLettersMap.get(remainder);

                        letters = Arrays.copyOf(quotientLetters, quotientLetters.length + remainderLetters.length);
                        System.arraycopy(remainderLetters, 0, letters, quotientLetters.length, remainderLetters.length);
                    } else {
                        letters = digitLettersMap.get(quotient);
                    }
                    digitLettersList.add(letters);
                }
            }
        });

        return digitLettersList;
    }
}
