package com.leecode.task8;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer.
 * <p>
 * The algorithm for myAtoi(string s) is as follows:
 * <p>
 * Whitespace: Ignore any leading whitespace (" ").
 * Signedness: Determine the sign by checking if the next character is '-' or '+', assuming positivity if neither present.
 * Conversion: Read the integer by skipping leading zeros until a non-digit character is encountered or the end of the string is reached. If no digits were read, then the result is 0.
 * Rounding: If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then round the integer to remain in the range. Specifically, integers less than -231 should be rounded to -231, and integers greater than 231 - 1 should be rounded to 231 - 1.
 * Return the integer as the final result.
 */
public class StringToInteger {
    public int myAtoi(String s) {
        Matcher matcher = Pattern.compile("^[+-]?[0]*\\d{1,11}").matcher(s.trim());
        if (!matcher.find()) {
            return 0;
        }
        return checkOutOfRange(Long.parseLong(matcher.group()));
    }

    private int checkOutOfRange(long x) {
        if (x < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else if (x > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else {
            return (int) x;
        }
    }
}
