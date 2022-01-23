package by.rabota.vjt.service;

import java.util.Comparator;
import java.util.List;

public class DataComparator implements Comparator<List<String>> {
    @Override
    public int compare(List<String> o1, List<String> o2) {
        int firstSize = o1.size();
        int secondSize = o2.size();
        if (firstSize > secondSize) {
            return compareStrings(secondSize, o1, o2);
        } else if (firstSize < secondSize) {
            return compareStrings(firstSize, o1, o2);
        } else {
            return compareStrings(firstSize, o1, o2);
        }
    }

    private int compareStrings(int size, List<String> first, List<String> second) {
        int res;
        Double num1;
        Double num2;
        Integer length = first.size();
        for (int i = 0; i < size; i++) {
            num1 = parseDouble(first.get(i));
            num2 = parseDouble(second.get(i));
            if (num1 != null && num2 != null) {
                res = num1.compareTo(num2);
            } else if (num1 != null) {
                res = -1;
            } else if (num2 != null) {
                res = 1;
            } else {
                res = first.get(i).compareTo(second.get(i));
            }
            if (res != 0) {
                return res;
            }
        }
        return length.compareTo(second.size());
    }

    private Double parseDouble(String str) {
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException | NullPointerException e) {
            return null;
        }
    }
}
