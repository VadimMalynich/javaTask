package com.leecode.task3;

import java.util.Scanner;

/**
 * Given a string str, find the length of the longest substring without duplicate characters.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter string");
        String str = scanner.nextLine();
        System.out.println(maxSizeLength(str));

    }

    public static int maxSizeLength(String str) {
        switch (str.length()) {
            case 0:
                return 0;
            case 1:
                return 1;
            default:
                int max = 0;
                StringBuilder stringBuilder;
                for (int i = 0; i < str.length() - 1; i++) {
                    stringBuilder = new StringBuilder(str.substring(i));
                    for (int j = 0; j < stringBuilder.length(); j++) {
                        String a = String.valueOf(stringBuilder.charAt(j));
                        int b = stringBuilder.indexOf(a, j + 1);
                        if (b > j) {
                            stringBuilder.delete(b, stringBuilder.length());
                        }
                    }
                    if (stringBuilder.length() > max) {
                        max = stringBuilder.length();
                    }
                }
                return max;
        }
    }
}
