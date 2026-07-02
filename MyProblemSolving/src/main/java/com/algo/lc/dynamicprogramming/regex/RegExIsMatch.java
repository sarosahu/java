package com.algo.lc.dynamicprogramming.regex;

/**
 * 10. Regular Expression Matching
 * Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:
 *
 * '.' Matches any single character.​​​​
 * '*' Matches zero or more of the preceding element.
 * Return a boolean indicating whether the matching covers the entire input string (not partial).
 *
 * Example 1:
 * >>>>>>>>>
 * Input: s = "aa", p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 *
 * Example 2:
 * >>>>>>>>>
 * Input: s = "aa", p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 *
 * Example 3:
 * >>>>>>>>>
 * Input: s = "ab", p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 *
 * Constraints:
 *
 * 1 <= s.length <= 20
 * 1 <= p.length <= 20
 * s contains only lowercase English letters.
 * p contains only lowercase English letters, '.', and '*'.
 * It is guaranteed for each appearance of the character '*', there will be a previous valid character to match.
 */
public class RegExIsMatch {
    public static boolean isMatch(String s, String p) {
        //return isMatchR(s, p);
        return isMatchR(s, p);
    }

    private static boolean isMatchR(String s, String p) {
        // This check is not required since our constraint says s and p are non empty strings
        if (p.isEmpty()) {
            return s.isEmpty();
        }

        boolean firstMatch = !s.isEmpty() &&
                (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.');

        if (p.length() >= 2 && p.charAt(1) == '*') {
            return isMatch(s, p.substring(2)) ||
                    (firstMatch && isMatch(s.substring(1), p));
        } else {
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }

    public static boolean isMatchDPR(String s, String p) {

        Boolean [][] memo = new Boolean[s.length() + 1][p.length() + 1];
        return isMatchDPRHelper(0, 0, s, p, memo);
    }

    private static boolean isMatchDPRHelper(int i, int j, String text, String pattern, Boolean[][] memo) {
        if (memo[i][j] != null) {
            return memo[i][j] == true;
        }
        boolean ans;
        int tLen = text.length();
        int pLen = pattern.length();
        if (j == pLen) {
            ans = i == tLen;
        } else {
            boolean firstMatch =
                    (i < tLen && (text.charAt(i) == pattern.charAt(j) ||
                            pattern.charAt(j) == '.'));
            if (j + 1 < pLen && pattern.charAt(j + 1) == '*') {
                // When p -> 'a*ab' and s -> 'ab' --> the result should be true
                // hence assume zero match, and call isMatchDPRHelper(i, j + 2,..)
                ans = isMatchDPRHelper(i, j + 2, text, pattern, memo) ||
                        // If above returns false, then if firstMatch is true, then
                        // call isMatchDPRHelper(i + 1, j, ..), assuming the pattern
                        // (e.g. p -> 'a*b', s -> 'aab') would be repeated.
                        (firstMatch && isMatchDPRHelper(i + 1, j, text, pattern, memo));
            } else {
                ans = firstMatch && isMatchDPRHelper(i + 1, j + 1, text, pattern, memo);
            }
        }
        memo[i][j] = ans;
        return ans;
    }

    public static boolean isMatchDP(String text, String pattern) {
        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
        dp[text.length()][pattern.length()] = true;

        for (int i = text.length(); i >= 0; i--) {
            for (int j = pattern.length() - 1; j >= 0; j--) {
                boolean first_match =
                        (i < text.length() &&
                                (pattern.charAt(j) == text.charAt(i) ||
                                        pattern.charAt(j) == '.'));
                if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
                    dp[i][j] = dp[i][j + 2] || (first_match && dp[i + 1][j]);
                } else {
                    dp[i][j] = first_match && dp[i + 1][j + 1];
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        String []s = {"ab", "aab"};
        String [] p = {"a*ab", "a*b"};
        for (int i = 0; i < p.length; i++) {
            System.out.printf("string : %s, pattern : %s --> ", s[i], p[i]);
            boolean ret = isMatch(s[i], p[i]);
            System.out.println(ret);
        }

        for (int i = 0; i < p.length; i++) {
            System.out.printf("string : %s, pattern : %s --> ", s[i], p[i]);
            boolean ret = isMatchDPR(s[i], p[i]);
            System.out.println(ret);
        }

        for (int i = 0; i < p.length; i++) {
            System.out.printf("string : %s, pattern : %s --> ", s[i], p[i]);
            boolean ret = isMatchDP(s[i], p[i]);
            System.out.println(ret);
        }

    }
}
