package lintCode_algo.dfs_combination_6;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * <p>
 * You don't need to care the order of combinations, but you should make sure the numbers in a combination are sorted.
 * <p>
 * Have you met this question in a real interview?
 * Example
 * Given n = 4 and k = 2, a solution is:
 * <p>
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4]
 * ]
 */
public class _152 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        // write your code here
        search(1, n, k, new ArrayList<Integer>());
        return res;
    }

    /**
     * Based on the algorithm design manual book.
     *
     * @param start
     * @param n
     * @param k
     * @param path
     */
    private void search(int start, int n, int k, ArrayList<Integer> path) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
        } else {
            if (start > n) {
                return;
            }
            path.add(start);
            search(start + 1, n, k, path);
            path.remove(path.size() - 1);

            search(start + 1, n, k, path);
        }
    }
}
