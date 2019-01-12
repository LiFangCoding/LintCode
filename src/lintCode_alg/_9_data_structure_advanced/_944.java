package lintCode_alg._9_data_structure_advanced;

import java.util.Arrays;

/*
Given an n x n matrix of positive and negative integers, find the submatrix with the largest possible sum.

Have you met this question in a real interview?
Example
Given matrix =
[
[1,3,-1],
[2,3,-2],
[-1,-2,-3]
]
return 9.
Explanation:
the submatrix with the largest possible sum is:
[
[1,3],
[2,3]
]
 */
public class _944 {
    int n, m;

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, -1}, {2, 3, -2}, {-1, -2, -3}};

        _944 sol = new _944();
        System.out.println("res is " + sol.maxSubmatrix(matrix));

        int[][] prefixsum = sol.getPrefixColSum(matrix);
        System.out.println("prefix sum is \n  " + Arrays.deepToString(prefixsum));
    }

    ;

    /**
     * @param matrix: the given matrix
     * @return: the largest possible sum
     */
    // T: O(n ^ 3)
    public int maxSubmatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        if (matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }

        n = matrix.length;
        m = matrix[0].length;

        int[][] prefixColSum = getPrefixColSum(matrix);

        int max = Integer.MIN_VALUE;
        for (int up = 0; up < n; up++) {
            for (int down = up; down < n; down++) {
                //T: O(1)
                int[] arr = compression(matrix, up, down, prefixColSum);
                // T: O(n)
                max = Math.max(max, maximumSubarray(arr));
            }
        }

        return max;
    }

    private int maximumSubarray(int[] arr) {
        int min = 0, max = Integer.MIN_VALUE, sum = 0;

        for (int i = 0; i < m; i++) {
            sum += arr[i];
            max = Math.max(max, sum - min);
            min = Math.min(min, sum);
        }

        return max;
    }

    private int[] compression(int[][] matrix, int up, int down, int[][] prefixColSum) {
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = prefixColSum[down + 1][i] - prefixColSum[up][i];
        }

        return arr;
    }

    private int[][] getPrefixColSum(int[][] matrix) {
        int[][] sum = new int[n + 1][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sum[i + 1][j] = sum[i][j] + matrix[i][j];
            }
        }

        return sum;
    }
}
