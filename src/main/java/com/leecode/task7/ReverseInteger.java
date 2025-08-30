package com.leecode.task7;

/**
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside
 * the signed 32-bit integer range [-231, 231 - 1], then return 0.
 * <p>
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 */
public class ReverseInteger {
    public int reverse(int x) {
        if (isOutOfRange(x)) {
            return 0;
        }
        long rev = 0;
        while (x != 0) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        if (isOutOfRange(rev)) {
            return 0;
        } else {
            return (int) rev;
        }
    }

    private boolean isOutOfRange(long x) {
        return x < Integer.MIN_VALUE || x >= Integer.MAX_VALUE;
    }
}
