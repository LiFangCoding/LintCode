package lintCode_alg._7_dfs_perm;

import java.util.ArrayList;
import java.util.List;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 * <p>
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * <p>
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
 * <p>
 * Example
 * There exist two distinct solutions to the 4-queens puzzle:
 * <p>
 * [
 * // Solution 1
 * [".Q..",
 * "...Q",
 * "Q...",
 * "..Q."
 * ],
 * // Solution 2
 * ["..Q.",
 * "Q...",
 * "...Q",
 * ".Q.."
 * ]
 * ]
 * Challenge
 * Can you do it without recursion?
 */
public class _33 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();

        search(0, n, new ArrayList<>(), res);
        return res;
    }

    // start is the row.
    private void search(int start, int n, List<Integer> cols, List<List<String>> res) {
        if (start == n) {
            res.add(solStringList(cols));
        } else {
            for (int col = 0; col < n; col++) {
                if (isValid(start, col, cols)) {
                    cols.add(col);
                    search(start + 1, n, cols, res);
                    cols.remove(cols.size() - 1);
                }
            }
        }
    }

    private boolean isValid(int start, int col, List<Integer> cols) {
        for (int i = 0; i < cols.size(); i++) {
            if (col == cols.get(i)) {
                return false;
            }

            if (Math.abs(start - i) == Math.abs(col - cols.get(i))) {
                return false;
            }
        }
        return true;
    }

    private List<String> solStringList(List<Integer> cols) {
        List<String> res = new ArrayList<>();

        if (cols.size() == 0) {
            return res;
        }

        int len = cols.size();

        for (int col : cols) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < len; i++) {
                if (i == col) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            res.add(sb.toString());
        }

        return res;
    }
}
