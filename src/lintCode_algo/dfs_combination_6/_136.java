package lintCode_algo.dfs_combination_6;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * <p>
 * Return all possible palindrome partitioning of s.
 * <p>
 * Example
 * Given s = "aab", return:
 * <p>
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 */
public class _136 {
    public List<List<String>> partition(String s) {
        // write your code here
        List<List<String>> res = new ArrayList<>();

        if (s == null) {
            return res;
        }
        search(s, new ArrayList<>(), res);
        return res;
    }

    private void search(String s, List<String> path, List<List<String>> res) {
        if (s.length() == 0) {
            res.add(new ArrayList<>(path));
        } else {
            for (int i = 1; i <= s.length(); i++) {
                String cand = s.substring(0, i);
                if (isPalindrom(cand)) {
                    path.add(cand);
                    String remain = s.substring(i);
                    search(remain, path, res);
                    path.remove(path.size() - 1);
                }
            }
        }
    }

    private boolean isPalindrom(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
            if (chars[i] != chars[j]) {
                return false;
            }
        }
        return true;
    }
}
