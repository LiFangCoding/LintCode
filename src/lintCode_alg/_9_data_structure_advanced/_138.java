package lintCode_alg._9_data_structure_advanced;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an integer array, find a subarray where the sum of numbers is zero. Your code should return the index of the first number and the index of the last number.
 * <p>
 * There is at least one subarray that it's sum equals to zero.
 * <p>
 * Have you met this question in a real interview?
 * Example
 * Given [-3, 1, 2, -3, 4], return [0, 2] or [1, 3].
 */
public class _138 {
    public List<Integer> subarraySum(int[] nums) {
        // sum -> index
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == 0) {
                res.add(0);
                res.add(i);
                break;
            }
            if (map.containsKey(sum)) {
                // index start from i + 1
                res.add(map.get(sum) + 1);
                res.add(i);
                break;
            } else {
                map.put(sum, i);
            }
        }

        return res;
    }
}
