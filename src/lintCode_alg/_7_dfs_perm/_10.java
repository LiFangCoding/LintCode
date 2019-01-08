package lintCode_alg._7_dfs_perm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a string, find all permutations of it without duplicates.
 * <p>
 * Example
 * Given "abb", return ["abb", "bab", "bba"].
 * <p>
 * Given "aabb", return ["aabb", "abab", "baba", "bbaa", "abba", "baab"].
 */
public class _10 {
    public List<String> stringPermutation2(String str) {
        List<String> res = new ArrayList<>();
        char[] chars = str.toCharArray();
        Arrays.sort(chars);

        search(chars, 0, new boolean[chars.length], "", res);
        return res;
    }

    private void search(char[] chars, int start, boolean[] marked, String path, List<String> res) {
        if (start == chars.length) {
            res.add(path);
        } else {
            for (int i = 0; i < chars.length; i++) {
                if (marked[i]) {
                    continue;
                }

                //cannot select one if previous one is not selected
                if (i > 0 && chars[i] == chars[i - 1] && !marked[i - 1]) {
                    continue;
                }

                marked[i] = true;
                search(chars, start + 1, marked, path + String.valueOf(chars[i]), res);
                marked[i] = false;
            }
        }
    }
}
