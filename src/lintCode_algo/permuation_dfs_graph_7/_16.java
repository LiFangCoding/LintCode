package lintCode_algo.permuation_dfs_graph_7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a list of numbers with duplicate number in it. Find all unique permutations.
 * <p>
 * Have you met this question in a real interview?
 * Example
 * For numbers [1,2,2] the unique permutations are:
 * <p>
 * [
 * [1,2,2],
 * [2,1,2],
 * [2,2,1]
 * ]
 * Challenge
 * Using recursion to do it is acceptable. If you can do it without recursion, that would be great!
 */
public class _16 {
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

                // This is !markd[i - 1], the previous one is not selected. Do not select later one.
                if (i > 0 && input[i] == input[i - 1] && !marked[i - 1]) {
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
