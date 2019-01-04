package lintCode_algo._9_data_structure_advanced;

/**
 * iven an array of integers, find a contiguous subarray which has the largest sum.
 * <p>
 * The subarray should contain at least one number.
 * <p>
 * Have you met this question in a real interview?
 * Example
 * Given the array [−2,2,−3,4,−1,2,1,−5,3], the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 * <p>
 * Challenge
 * Can you do it in time complexity O(n)?
 */
public class _41 {
    // pay attention to the val of res.
    // nums = [-1]
    public int maxSubArray(int[] nums) {
        int res = nums[0];

        int sum = 0;
        int minSum = 0;

        for (int num : nums) {
            sum += num;
            res = Math.max(sum - minSum, res);
            minSum = Math.min(minSum, sum);
        }

        return res;
    }
}
