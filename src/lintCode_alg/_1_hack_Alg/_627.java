package lintCode_alg._1_hack_Alg;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
 * <p>
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 * <p>
 * Assume the length of given string will not exceed 1010.
 * <p>
 * Have you met this question in a real interview?
 * Example
 * Given s = "abccccdd" return 7
 * <p>
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 */
public class _627 {
    public int longestPalindrome(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return 0;
        }

        Set<Character> set = new HashSet<>();
        int count = 0;

        for (char c : s.toCharArray()) {
            if (!set.contains(c)) {
                set.add(c);
            } else {
                set.remove(c);
                count += 2;
            }
        }

        if (!set.isEmpty()) {
            count++;
        }

        return count;
    }
}
