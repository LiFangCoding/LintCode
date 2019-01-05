package lintCode_alg._6_dfs_combination;

import java.util.ArrayList;
import java.util.List;

/**
 * Give a string, you can choose to split the string after one character or two adjacent characters,
 * and make the string to be composed of only one character or two characters. Output all possible
 * results.
 *
 * <p>Example Given the string "123" return [["1","2","3"],["12","3"],["1","23"]]
 */
public class _680 {
    public List<List<String>> splitString(String s) {
        // write your code here
        List<List<String>> res = new ArrayList<>();

        if (s == null) {
            return res;
        }

        addPaths(s, new ArrayList<>(), res);
        return res;
    }

    private void addPaths(String s, List<String> path, List<List<String>> res) {
        int len = s.length();

        if (len == 0) {
            res.add(new ArrayList<>(path));
        } else {
            for (int i = 1; i <= len && i <= 2; i++) {
                path.add(s.substring(0, i));
                addPaths(s.substring(i, len), path, res);
                path.remove(path.size() - 1);
            }
        }
    }
}
