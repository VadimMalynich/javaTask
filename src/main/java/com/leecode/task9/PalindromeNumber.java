package com.leecode.task9;

/**
 * Given an integer x, return true if x is a palindrome, and false otherwise.
 */
public class PalindromeNumber {
    private long x;

    public PalindromeNumber() {
    }

    public PalindromeNumber(long x) {
        this.x = x;
    }

    public void setX(long x) {
        this.x = x;
    }

    public long getX() {
        return x;
    }

    public boolean identifyPalindrome(int x) {
        if (x < 0) {
            return false;
        } else {
            return x == Long.parseLong(String.valueOf(new StringBuilder(String.valueOf(x)).reverse()));
        }
    }
}
