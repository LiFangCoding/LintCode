package lintCode_alg._1_hack_Alg;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * <p>
 * Have you consider that the string might be empty? This is a good question to ask during an interview.
 * <p>
 * For the purpose of this problem, we define empty string as valid palindrome.
 * <p>
 * Example
 * "A man, a plan, a canal: Panama" is a palindrome.
 * <p>
 * "race a car" is not a palindrome.
 * <p>
 * Challenge
 * O(n) time without extra memory.
 */
public class _415 {
    public boolean isPalindrome(String s) {
        // write your code here
        if (s == null) {
            return false;
        }

        if (s.length() == 0) {
            return true;
        }

        s = s.toLowerCase();

        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            if (!isValid(s.charAt(start))) {
                start++;
            } else if (!isValid(s.charAt(end))) {
                end--;
            } else if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }

        return true;
    }

    private boolean isValid(char c) {
        // Important. Not c >= 0 && c <= 9, need to compare with '0', '9'
        // Or return Character.isLetter(c) || Character.isDigit(c);
        return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z');
    }
}
