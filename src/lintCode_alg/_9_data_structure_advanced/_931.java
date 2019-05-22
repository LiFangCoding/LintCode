package lintCode_alg._9_data_structure_advanced;

/**
 * There are k sorted arrays nums. Find the median of the given k sorted arrays.
 * <p>
 * Example
 * Given nums = [[1],[2],[3]], return 2.00.
 * <p>
 * Notice
 * The length of the given arrays may not equal to each other.
 * The elements of the given arrays are all positive number.
 * Return 0 if there are no elements in the array.
 */

/**
 * 基于二分答案的 findKth 解法
 * 假设有 k 个数组，每个数组平均长度为 n
 * 时间复杂度 O(log(Range) * klogn) 因为log(Range)最大为32，所以可以当作常量
 * 空间复杂度 O(1)
 *
 * 如果输入数据存在负数，该解法依旧不会出错。
 * calMiddle()函数避免在计算mid的时候溢出。
 * 但是二分答案的解法仅限于输入数据为整型，浮点型无法运用二分答案的方法。
 */
public class _931 {
    public double findMedian(int[][] nums) {
        // write your code here
        int n = getElementNum(nums);
        if (n == 0) {
            return 0.0;
        }

        if ((n & 1) == 1) {
            return (double) findKth(nums, n / 2 + 1);
        } else {
            int left = findKth(nums, n / 2);
            int right = findKth(nums, n / 2 + 1);
            return ((double) left + (double) right) / 2;
        }
    }

    // O(log(range) * klogn)
    private int findKth(int[][] arrs, int k) {

        int start = Integer.MIN_VALUE;
        int end = Integer.MAX_VALUE;

        while (start + 1 < end) {
            int mid = calMiddle(start, end);
            if (countNotLargeInAll(arrs, mid) >= k) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (countNotLargeInAll(arrs, start) >= k) {
            return start;
        }

        return end;
    }

    private int getElementNum(int[][] arrs) {
        int n = 0;
        for (int[] arr : arrs) {
            if (arr == null) {
                continue;
            }

            n += arr.length;
        }

        return n;
    }

    private int calMiddle(int start, int end) {
        if (start > 0 || end < 0) {
            // 同号
            return start + ((end - start) >> 1);
        } else {
            // 异号
            return (start + end) >> 1;
        }
    }

    // O(log n) * k
    private int countNotLargeInAll(int[][] arrs, int target) {
        int count = 0;
        for (int[] arr : arrs) {
            count += countNotLargeInArray(arr, target);
        }
        return count;
    }

    //binary _11_searching O(logn)
    private int countNotLargeInArray(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int start = 0, end = arr.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (arr[start] > target) {
            return start;
        }

        if (arr[end] > target) {
            return end;
        }

        return arr.length;
    }
}
