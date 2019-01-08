package lintCode_alg._7_dfs_perm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a digit string excluded 01, return all possible letter combinations that the number could
 * represent.
 *
 * <p>A mapping of digit to letters (just like on the telephone buttons) is given below.
 *
 * <p>Cellphone
 *
 * <p>Example Given "23"
 *
 * <p>Return ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
 *
 * <p>Notice Although the above answer is in lexicographical order, your answer could be in any
 * order you want.
 */
public class _425 {
    public static class Sol1 {
        public List<String> letterCombinations(String digits) {
            String[] phone = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

            List<String> res = new ArrayList<>();
            if (digits.length() == 0) {
                return res;
            }

            search(0, digits, phone, "", res);
            return res;
        }

        private void search(int start, String input, String[] map, String path, List<String> res) {
            if (start == input.length()) {
                res.add(path);
            } else {
                int d = input.charAt(start) - '0';
                for (char c : map[d].toCharArray()) {
                    search(start + 1, input, map, path + c, res);
                }
            }
        }
    }

    public static class Sol2 {
        List<String> res = new ArrayList<>();
        Map<Integer, String> map = new HashMap<>();

        public List<String> letterCombinations(String digits) {
            // write your code here
            if (digits == null || digits.length() == 0) {
                return res;
            }
            map.put(2, "abc");
            map.put(3, "def");
            map.put(4, "ghi");
            map.put(5, "jkl");
            map.put(6, "mno");
            map.put(7, "pqrs");
            map.put(8, "tuv");
            map.put(9, "wxyz");

            search(digits, 0, "");
            return res;
        }

        private void search(String digits, int start, String path) {
            if (start == digits.length()) {
                res.add(path);
            } else {
                int num = digits.charAt(start) - '0';

                if (!map.containsKey(num)) {
                    return;
                }
                String candidates = map.get(num);
                for (int i = 0; i < candidates.length(); i++) {
                    search(digits, start + 1, path + candidates.substring(i, i + 1));
                }
            }
        }
    }
}
