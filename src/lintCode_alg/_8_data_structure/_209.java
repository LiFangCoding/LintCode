package lintCode_alg._8_data_structure;

import java.util.HashMap;
import java.util.Map;

/**
 * Find the first unique character in a given string. You can assume that there is at least one unique character in the string.
 * <p>
 * Have you met this question in a real interview?
 * Example
 * For "abaccdeff", return 'b'.
 * <p>
 * Challenge
 * 不使用额外的存储空间。
 */
public class _209 {
    //TODO:
    class Sol_challenge {
        public char firstUniqChar(String str) {
            // Write your code here
            return '0';
        }
    }

    class Sol1 {
        public char firstUniqChar(String str) {
            // Write your code here
            Map<Character, Integer> count = new HashMap<>();
            for (char c : str.toCharArray()) {
                count.put(c, count.getOrDefault(c, 0) + 1);
            }

            for (char c : count.keySet()) {
                if (count.get(c) == 1) {
                    return c;
                }
            }
            return ' ';
        }
    }
}
