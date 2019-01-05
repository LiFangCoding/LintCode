package lintCode_alg._2_binary_search;

/**
 * Given a target number, a non-negative integer k and an integer array A sorted in ascending order, find the k closest numbers to target in A, sorted in ascending order by the difference between the number and target. Otherwise, sorted in ascending order by number if the difference is same.
 * <p>
 * The value k is a non-negative integer and will always be smaller than the length of the sorted array.
 * Length of the given array is positive and will not exceed 10^4
 * Absolute value of elements in the array and x will not exceed 10^4
 * Have you met this question in a real interview?
 * Example
 * Given A = [1, 2, 3], target = 2 and k = 3, return [2, 1, 3].
 * <p>
 * Given A = [1, 4, 6, 8], target = 3 and k = 3, return [4, 1, 6].
 * <p>
 * Challenge
 * O(logn + k) time complexity.
 */
public class _460 {
    public int[] kClosestNumbers(int[] A, int target, int k) {
        // write your code here
        int[] res = new int[k];
        int idx = 0;
        // corner case
        if (k == 0) {
            return res;
        }

        int mostNearIdx = mostNearIdx(A, target);
        res[idx++] = A[mostNearIdx];

        int i = mostNearIdx - 1;
        int j = mostNearIdx + 1;

        while (i >= 0 || j <= A.length - 1) {
            if (idx == k) {
                break;
            }

            if (i >= 0 && j <= A.length - 1) {
                if (dist(A, i, target) <= dist(A, j, target)) {
                    res[idx++] = A[i--];
                } else {
                    res[idx++] = A[j++];
                }
            } else if (i >= 0) {
                res[idx++] = A[i--];
            } else {
                res[idx++] = A[j++];
            }
        }

        return res;
    }

    private int dist(int[] A, int index, int target) {
        return Math.abs(A[index] - target);
    }

    private int mostNearIdx(int[] A, int target) {
        int lo = 0;
        int hi = A.length - 1;

        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;

            if (A[mid] == target) {
                return mid;
            } else if (A[mid] < target) {
                lo = mid;
            } else {
                hi = mid;
            }
        }

        return dist(A, hi, target) >= dist(A, lo, target) ? lo : hi;
    }
}
