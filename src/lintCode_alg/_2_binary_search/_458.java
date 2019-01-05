package lintCode_alg._2_binary_search;

public class _458 {
    public int lastPosition(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int len = nums.length;
        int lo = 0;
        int hi = len - 1;

        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] <= target) {
                lo = mid;
            } else {
                hi = mid;
            }
        }

        if (nums[hi] == target) {
            return hi;
        } else if (nums[lo] == target) {
            return lo;
        }

        return -1;
    }
}
