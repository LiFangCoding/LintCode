package lintCode_alg._1_hack_Alg;

public class _200 {
    // abcbd
    public String longestPalindrome(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return null;
        }

        String res = null;
        int max = 0;
        int len = s.length();

        for (int i = 0; i < len; i++) {
            if (i < len - 1) {
                String evenPalin = getPalin(s, i, i + 1);
                int evenLen = evenPalin.length();
                if (max < evenLen) {
                    max = evenLen;
                    res = evenPalin;
                }
            }

            String oddPalin = getPalin(s, i, i);
            int oddLen = oddPalin.length();
            if (max < oddPalin.length()) {
                max = oddLen;
                res = oddPalin;
            }
        }

        return res;
    }

    private String getPalin(String s, int start, int end) {
        while (start >= 0 && end < s.length()) {
            if (s.charAt(start) == s.charAt(end)) {
                start--;
                end++;
            } else {
                break;
            }
        }

        return s.substring(start + 1, end);
    }
}
