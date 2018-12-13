package lintCode_algo.dfs_combination_6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
 * <p>
 * Example
 * Input: [1,2,2]
 * Output:
 * <p>
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 * Challenge
 * Can you do it in both recursively and iteratively?
 * <p>
 * Notice
 * Each element in a subset must be in non-descending order.
 * The ordering between two subsets is free.
 * The solution set must not contain duplicate subsets.
 */
public class _18 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        if (nums == null) {
            return res;
        }
        Arrays.sort(nums);
        search(nums, 0, new ArrayList<Integer>(), false);
        return res;
    }

    private void search(int[] nums, int start, ArrayList<Integer> path, boolean selected) {
        if (start == nums.length) {
            res.add(new ArrayList<Integer>(path));
        } else {
            if (start != 0 && nums[start] == nums[start - 1]) {
                if (!selected) {
                    search(nums, start + 1, path, false);
                    return;
                }
            }

            path.add(nums[start]);
            search(nums, start + 1, path, true);
            path.remove(path.size() - 1);

            search(nums, start + 1, path, false);
        }
    }
}
