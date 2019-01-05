package lintCode_alg._2_binary_search;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * <p>
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * <p>
 * You may assume no duplicate exists in the array.
 * <p>
 * Have you met this question in a real interview?
 * Example
 * For [4, 5, 1, 2, 3] and target=1, return 2.
 * <p>
 * For [4, 5, 1, 2, 3] and target=0, return -1.
 * <p>
 * Challenge
 * O(logN) time
 */
public class _62 {
    public int search(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        }

        int start = 0;
        int end = A.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            //Important: return the index.
            if (target == A[mid]) {
                return mid;
            }

            if (target == A[end]) {
                return end;
            }

            //mid on left part
            if (A[mid] > A[end]) {
                // target is on left.
                if (target > A[end] && target <= A[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                if (target > A[mid] && target <= A[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }

        if (A[start] == target) {
            return start;
        }

        if (A[end] == target) {
            return end;
        }

        return -1;
    }
}
