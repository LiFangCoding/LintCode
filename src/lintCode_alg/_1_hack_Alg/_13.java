package lintCode_alg._1_hack_Alg;

/**
 * For a given source string and a target string, you should output the first index(from 0) of target string in source string.
 * <p>
 * If target does not exist in source, just return -1.
 * <p>
 * Have you met this question in a real interview?
 * Clarification
 * Do I need to implement KMP Algorithm in a real interview?
 * <p>
 * Not necessary. When you meet this problem in a real interview, the interviewer may just want to test your basic implementation ability. But make sure you confirm with the interviewer first.
 * Example
 * If source = "source" and target = "target", return -1.
 * <p>
 * If source = "abcdabcdefg" and target = "bcd", return 1.
 * <p>
 * Challenge
 * O(n2) is acceptable. Can you implement an O(n) algorithm? (hint: KMP)
 */
public class _13 {
    // T: O(n * m)
    // s = "abc" t = "bc" return 1
    public static class sol1_bruteforce {
        public int strStr(String s, String t) {
            // Write your code here
            if (s == null || t == null) {
                return -1;
            }

            int slen = s.length();
            int tlen = t.length();
            int end = slen - tlen;

            if (end < 0) {
                return -1;
            }

            for (int i = 0; i <= end; i++) {
                // if s from index i contains t.
                if (isIn(s, i, t)) {
                    return i;
                }
            }

            return -1;
        }

        private boolean isIn(String s, int start, String t) {
            for (int i = 0; i < t.length(); i++) {
                if (s.charAt(i + start) != t.charAt(i)) {
                    return false;
                }
            }
            return true;
        }
    }

    //TODO
    public static class sol2_KMP {

    }

}
