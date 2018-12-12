package lintCode_algo.dfs_combination_6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * <p>
 * Each number in C may only be used once in the combination.
 * <p>
 * Example
 * Given candidate set [10,1,6,7,2,1,5] and target 8,
 * <p>
 * A solution set is:
 * <p>
 * [
 * [1,7],
 * [1,2,5],
 * [2,6],
 * [1,1,6]
 * ]
 * Notice
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 */
public class _153 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] input, int target) {
        // write your code here
        if (input == null || input.length == 0) {
            return res;
        }

        Arrays.sort(input);
        // should be new ArrayList<Integer>()
        search(0, false, input, target, new ArrayList<Integer>());
        // always forget return
        return res;
    }

    private void search(int start, boolean selected, int[] input, int target, List<Integer> path) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(path));
        } else if (target < 0) {
            return;
        } else {
            if (start >= input.length) {
                return;
            }

            // remove duplciates
            if (start != 0 && input[start] == input[start - 1]) {
                if (!selected) {
                    // just ignore the same. Only one candidate this condition. will not have: not selected, selecgted.
                    search(start + 1, false, input, target, path);
                    return;
                }
            }

            path.add(input[start]);
            search(start + 1, true, input, target - input[start], path);
            //always mistake remove part.
            path.remove(path.size() - 1);

            search(start + 1, false, input, target, path);
        }
    }
}
