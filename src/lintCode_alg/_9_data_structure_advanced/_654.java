package lintCode_alg._9_data_structure_advanced;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two Sparse Matrix A and B, return the result of AB.
 * <p>
 * You may assume that A's column number is equal to B's row number.
 */
//TODO
public class _654 {
    // Time (n^2 * (1 + n)) = O(n^2 + n^3)
    //Space O(1)
    public int[][] multiply(int[][] A, int[][] B) {
        // write your code here
        // A(n, t) * B(t, m) = C(n, m)
        int n = A.length;
        int t = A[0].length;
        int m = B[0].length;
        int[][] C = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int sum = 0;
                for (int k = 0; k < t; k++) {
                    sum += A[i][k] * B[k][j];
                }
                C[i][j] = sum;
            }
        }

        return C;
    }

    // Time O(n^2 * (1 + a * n) = O(n^2 + a * n^3)
    //Space O(1)
    public int[][] multiply2(int[][] A, int[][] B) {
        // write your code here
        // A(n, t) * B(t, m) = C(n, m)
        int n = A.length;
        int t = A[0].length;
        int m = B[0].length;
        int[][] C = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < t; k++) {
                if (A[i][k] == 0) {
                    continue;
                }
                for (int j = 0; j < m; j++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        return C;
    }

    //方法三（最优）：进一步改进，考虑A与B的稀疏性
    //Time O(n^2 * (1 + a * b * n)) = O(n^2 + a * b * n^3)
    //Space O(b * n^2)
    public int[][] multiply3(int[][] A, int[][] B) {
        // write your code here
        // A(n, t) * B(t, m) = C(n, m)
        int n = A.length;
        int t = A[0].length;
        int m = B[0].length;
        int[][] C = new int[n][m];

        List<List<Integer>> B_nonZero_colIndices = new ArrayList<>();
        for (int k = 0; k < t; k++) {
            List<Integer> colIndices = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                if (B[k][j] != 0) {
                    colIndices.add(j);
                }
            }
            B_nonZero_colIndices.add(colIndices);
        }

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < t; k++) {
                if (A[i][k] == 0) {
                    continue;
                }
                for (int colIndex : B_nonZero_colIndices.get(k)) {
                    C[i][colIndex] += A[i][k] * B[k][colIndex];
                }
            }
        }

        return C;
    }
}


