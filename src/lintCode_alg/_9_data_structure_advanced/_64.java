package lintCode_alg._9_data_structure_advanced;

/**
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * <p>
 * You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B. The number of elements initialized in A and B are m and n respectively.
 * <p>
 * Have you met this question in a real interview?
 * Example
 * A = [1, 2, 3, empty, empty], B = [4, 5]
 * <p>
 * After merge, A will be filled as [1, 2, 3, 4, 5]
 */
public class _64 {
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // merge from end to start
        int cur = m + n - 1;
        int i = m - 1;
        int j = n - 1;

        // put from tail to head
        while (i >= 0 && j >= 0) {
            if (A[i] > B[j]) {
                A[cur--] = A[i--];
            } else {
                A[cur--] = B[j--];
            }
        }

        //if A has remaining elements, keep it. B has left elements, fill in A
        while (j >= 0) {
            A[cur--] = B[j--];
        }
    }
}
