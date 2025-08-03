package com.leecode.task6;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * <p>
 * Write the code that will take a string and make this conversion given a number of rows:
 * <p>
 * string convert(string s, int numRows);
 */
public class ZigzagConversion {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() == 1 || s.length() == numRows) {
            return s;
        }
        int numColumns = calculateWidth(s, numRows);
        char[][] arr = new char[numRows][numColumns];
        int arrIndex = 0;
        boolean isUp = false;
        int fillIndex = numRows - 1;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numColumns; i++) {
            if (isUp && fillIndex > 1) {
                fillIndex--;
                arr[fillIndex][i] = s.charAt(arrIndex);
                arrIndex++;
                if (fillIndex == 1) {
                    isUp = !isUp;
                }
            } else {
                for (int j = 0; j < numRows; j++) {
                    if (arrIndex == s.length()) {
                        break;
                    }
                    arr[j][i] = s.charAt(arrIndex);
                    arrIndex++;
                }
                isUp = !isUp;
                fillIndex = numRows - 1;
            }
        }
        for (char[] chars : arr) {
            for (char aChar : chars) {
                if (aChar != '\u0000') {
                    result.append(aChar);
                }
            }
        }
        return result.toString();
    }

    public static int calculateWidth(String s, int numRows) {
        int x = 0;
        int index = 0;
        int count;
        boolean goingDown = true;
        while (index < s.length()) {
            if (!goingDown) {
                count = index + numRows - 2;
                if (count < s.length()) {
                    x += numRows - 2;
                } else {
                    x += s.length() - index;
                }
                index += numRows - 2;
            } else {
                x++;
                index += numRows;
            }
            goingDown = !goingDown;
        }
        return x;
    }

    public void printArray(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}
