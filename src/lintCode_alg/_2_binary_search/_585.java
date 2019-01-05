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
        int start = 0;
        int end = len - 1;

        // Do not consider 3 points in direction. It will be hard. Just compare mid with mid + 1.
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid + 1] > nums[mid]) {
                start = mid;
            } else if (nums[mid] > nums[mid + 1] && nums[mid - 1] > nums[mid]) {
                end = mid;
            } else if (isTop(nums, mid)) {
                return nums[mid];
            }
        }

        if (isTop(nums, start)) {
            return nums[start];
        }

        if (isTop(nums, end)) {
            return nums[end];
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
