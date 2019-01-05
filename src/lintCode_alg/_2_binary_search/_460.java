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
        int[] res = new int[k];
        int idx = 0;

        int nearestIdx = nearestIdx(A, target);
        // The left, right index can be mostNear and its left or right.
        int left = nearestIdx;
        int right = nearestIdx + 1;

        while (left >= 0 || right <= A.length - 1) {
            if (idx == k) {
                break;
            }

            if (left >= 0 && right <= A.length - 1) {
                if (isLeftSmall(A, left, right, target)) {
                    res[idx++] = A[left--];
                } else {
                    res[idx++] = A[right++];
                }
            } else if (left >= 0) {
                res[idx++] = A[left--];
            } else {
                res[idx++] = A[right++];
            }
        }

        return res;
    }

    private boolean isLeftSmall(int[] A, int left, int right, int target) {
        return Math.abs(A[left] - target) <= Math.abs(A[right] - target);
    }

    private int nearestIdx(int[] A, int target) {
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

        if (isLeftSmall(A, lo, hi, target)) {
            return lo;
        }

        return hi;
    }
}
