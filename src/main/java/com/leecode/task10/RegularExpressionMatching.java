package com.leecode.task10;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:
 * <p>
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        Matcher matcher = Pattern.compile("^" + p + "$").matcher(s);
        if (matcher.find()) {
            return true;
        }
        return false;
    }
}
