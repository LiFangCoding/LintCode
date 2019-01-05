package lintCode_alg._2_binary_search;

/**
 * There is an integer array which has the following features:
 * <p>
 * The numbers in adjacent positions are different.
 * A[0] < A[1] && A[A.length - 2] > A[A.length - 1].
 * We define a position P is a peak if:
 * <p>
 * A[P] > A[P-1] && A[P] > A[P+1]
 * Find a peak element in this array. Return the index of the peak.
 * <p>
 * It's guaranteed the array has at least one peak.
 * The array may contain multiple peeks, find any of them.
 * The array has at least 3 numbers in it.
 * Have you met this question in a real interview?
 * Example
 * Given [1, 2, 1, 3, 4, 5, 7, 6]
 * <p>
 * Return index 1 (which is number 2) or 6 (which is number 7)
 * <p>
 * Challenge
 * Time complexity O(logN)
 */
public class _75 {
    public static class Sol1_binraySearchMid {
        public int findPeak(int[] A) {
            // Search except the first and last.
            // So the point always has left and right.
            int start = 1;
            int end = A.length - 2;

            while (start + 1 < end) {
                int mid = start + (end - start) / 2;
                if (A[mid] > A[mid + 1]) {
                    end = mid;
                } else if (A[mid] < A[mid + 1]) {
                    start = mid;
                }
            }

            if (isPeak(A, start)) {
                return start;
            }

            if (isPeak(A, end)) {
                return end;
            }

            return -1;
        }

        private boolean isPeak(int[] A, int i) {
            return A[i] > A[i - 1] && A[i] > A[i + 1];
        }
    }

    public static class Sol2_BinarysearchAll {
        public int findPeak(int[] A) {
            int start = 0;
            int end = A.length - 1;

            while (start + 1 < end) {
                int mid = start + (end - start) / 2;
                if (A[mid] > A[mid + 1]) {
                    end = mid;
                } else if (A[mid] < A[mid + 1]) {
                    start = mid;
                }
            }

            if (isPeak(A, start)) {
                return start;
            }

            if (isPeak(A, end)) {
                return end;
            }

            return -1;
        }

        private boolean isPeak(int[] A, int i) {
            if (i - 1 >= 0 && i + 1 <= A.length - 1) {
                if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
                    return true;
                }
            }

            return false;
        }
    }

}
