package lintCode_alg._6_dfs_combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of distinct integers, return all possible subsets.
 *
 * <p>Example If S = [1,2,3], a solution is:
 *
 * <p>[ [3], [1], [2], [1,2,3], [1,3], [2,3], [1,2], [] ] Challenge Can you do it in both
 * recursively and iteratively?
 *
 * <p>Notice Elements in a subset must be in non-descending order. The solution set must not contain
 * duplicate subsets.
 */
public class _17 {
    public static class sol0 {
        // This is jiuzhang's reference solution.
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> results = new ArrayList<>();
            Arrays.sort(nums);
            dfs(nums, 0, new ArrayList<>(), results);
            return results;
        }

        // 1. 递归的定义
        // 以 subset 开头的，配上 nums 以 index 开始的数所有组合放到 results 里
        private void dfs(int[] nums, int index, List<Integer> subset, List<List<Integer>> results) {
            // 3. 递归的出口
            if (index == nums.length) {
                results.add(new ArrayList<>(subset));
                return;
            }

            // 2. 递归的拆解
            // (如何进入下一层)

            // 选了 nums[index]
            subset.add(nums[index]);
            dfs(nums, index + 1, subset, results);

            // 不选 nums[index]
            subset.remove(subset.size() - 1);
            dfs(nums, index + 1, subset, results);
        }
    }

    public static class sol1 {
        List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> subsets(int[] input) {
            // Important: Cannot have input.length == 0 here. [] -> []. Correct: [] -> [[]]
            if (input == null) {
                return res;
            }

            Arrays.sort(input);
            search(0, input, new ArrayList<>());
            // always forget return statement
            return res;
        }

        private void search(int start, int[] input, List<Integer> path) {
            if (start == input.length) {
                res.add(new ArrayList<>(path));
            } else {
                path.add(input[start]);
                search(start + 1, input, path);
                path.remove(path.size() - 1);

                search(start + 1, input, path);
            }
        }
    }
}
