package lintCode_algo._7_dfs_perm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a list of numbers, return all possible permutations.
 * <p>
 * You can assume that there is no duplicate numbers in the list.
 * <p>
 * Have you met this question in a real interview?
 * Example
 * For nums = [1,2,3], the permutations are:
 * <p>
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */

public class _15 {
    public List<List<Integer>> permute(int[] input) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(input);

        search(0, input, new boolean[input.length], new ArrayList<>(), res);
        return res;

    }

    private void search(int start, int[] input, boolean[] marked, ArrayList<Integer> path, List<List<Integer>> res) {
        if (start == input.length) {
            List<Integer> oneRes = new ArrayList<>(path);
            res.add(oneRes);
        } else {
            for (int i = 0; i < input.length; i++) {
                if (marked[i]) {
                    continue;
                }

                marked[i] = true;
                path.add(input[i]);
                search(start + 1, input, marked, path, res);
                marked[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
