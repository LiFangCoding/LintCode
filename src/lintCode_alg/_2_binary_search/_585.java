package lintCode_alg._2_binary_search;

/**
 * Given a mountain sequence of n integers which increase firstly and then decrease, find the mountain top.
 * <p>
 * Have you met this question in a real interview?
 * Example
 * Given nums = [1, 2, 4, 8, 6, 3] return 8
 * Given nums = [10, 9, 8, 7], return 10
 */
public class _585 {
    public int mountainSequence(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int len = nums.length;
        int lo = 0;
        int hi = len - 1;

        // Do not consider 3 points in direction. It will be hard. Just compare mid with mid + 1.
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid + 1] > nums[mid]) {
                lo = mid;
            } else if (nums[mid] > nums[mid + 1] && nums[mid - 1] > nums[mid]) {
                hi = mid;
            } else if (isTop(nums, mid)) {
                return nums[mid];
            }
        }

        if (isTop(nums, lo)) {
            return nums[lo];
        }

        if (isTop(nums, hi)) {
            return nums[hi];
        }

        return -1;
    }

    // coner case. Just len = 1.
    private boolean isTop(int[] nums, int i) {
        if (i == 0) {
            return true;
        }

        if (i == nums.length - 1) {
            return true;
        }

        return nums[i] > nums[i - 1] && nums[i] > nums[i + 1];
    }
}
