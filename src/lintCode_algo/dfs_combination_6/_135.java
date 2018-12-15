package lintCode_algo.dfs_combination_6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description Given a set of candidate numbers (C) and a target number (T), find all unique
 * combinations in C where the candidate numbers sums to T.
 *
 * <p>The same repeated number may be chosen from C unlimited number of times.
 *
 * <p>All numbers (including target) will be positive integers. Elements in a combination (a1, a2, …
 * , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak). The solution set must not contain
 * duplicate combinations. Have you met this question in a real interview? Example Given candidate
 * set [2,3,6,7] and target 7, a solution set is:
 *
 * <p>[7] [2, 2, 3]
 */
public class _135 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] input, int target) {
        // write your code here
        if (input == null || input.length == 0) {
            return res;
        }
        Arrays.sort(input);
        search(0, input, target, new ArrayList<Integer>());
        return res;
    }

    private void search(int start, int[] input, int target, List<Integer> path) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
        } else {
            if (target < 0) {
                return;
            }
            if (start >= input.length) {
                return;
            }
            if (start != 0 && input[start] == input[start - 1]) {
                search(start + 1, input, target, path);
                return;
            }

            path.add(input[start]);
            search(start, input, target - input[start], path);
            path.remove(path.size() - 1);

            search(start + 1, input, target, path);
        }
    }
}
