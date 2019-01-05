package lintCode_alg._2_binary_search;

public class _458 {
    public int lastPosition(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int len = nums.length;
        int start = 0;
        int end = len - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (nums[end] == target) {
            return end;
        } else if (nums[start] == target) {
            return start;
        }

        return -1;
    }
}
