package com.leecode.task5;

public class LongestPalindromicSubstring {
    private String string;

    public LongestPalindromicSubstring() {
    }

    public LongestPalindromicSubstring(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return null;
        }
        if (s.length() == 1) {
            return s;
        }
        int maxSize = 1;
        int size = s.length();
        String palindrome = "";
        StringBuilder palindromeBuilder;
        for (int i = 0; i < size - 1 && (size - i) > maxSize; i++) {
            for (int j = size; j > i + 1 && (j - i) > maxSize; j--) {
                String substring = s.substring(i, j);
                palindromeBuilder = new StringBuilder(substring).reverse();
                if (substring.contentEquals(palindromeBuilder) && substring.length() > maxSize) {
                    palindrome = substring;
                    maxSize = palindrome.length();
                }
            }
        }
        return palindrome;
    }
}