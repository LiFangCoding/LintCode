package lintCode_algo.dfs_perm_7;

import java.util.ArrayList;

/**
 * Description
 * Follow up for N-Queens problem.
 * <p>
 * Now, instead outputting board configurations, return the total number of distinct solutions.
 * <p>
 * Have you met this question in a real interview?
 * Example
 * For n=4, there are 2 distinct solutions.
 */
public class _34 {

    public int totalNQueens(int n) {
        // write your code here
        if (n == 0) {
            return 0;
        }

        int[] res = {0};

        search(0, n, new ArrayList<>(), res);
        return res[0];
    }

    //path is a list of row selected.
    private void search(int col, int n, ArrayList<Integer> path, int[] res) {
        if (col == n) {
            res[0] = res[0] + 1;
        } else {
            for (int row = 0; row < n; row++) {
                if (isValid(row, col, path)) {
                    path.add(row);
                    search(col + 1, n, path, res);
                    path.remove(path.size() - 1);
                }
            }
        }
    }

    private boolean isValid(int row, int col, ArrayList<Integer> path) {
        for (int i = 0; i < path.size(); i++) {
            if (Math.abs(row - path.get(i)) == Math.abs(col - i)) {
                return false;
            }

            if (row == path.get(i)) {
                return false;
            }
        }
        return true;
    }
}
