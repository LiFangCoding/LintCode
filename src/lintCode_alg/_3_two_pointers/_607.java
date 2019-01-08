package lintCode_alg._3_two_pointers;

import java.util.HashMap;
import java.util.Map;

/**
 * Design and implement a TwoSum class. It should support the following operations: add and find.
 * <p>
 * add - Add the number to an internal data structure.
 * find - Find if there exists any pair of numbers which sum is equal to the value.
 */
public class _607 {

    Map<Integer, Integer> map = new HashMap<>();

    //T: O(1)
    public void add(int num) {
        // write your code here
        map.put(num, map.getOrDefault(num, 0) + 1);
    }

    /**
     * @param val: An integer
     * @return: Find if there exists any pair of numbers which sum is equal to the value.
     */
    // T: O(n)
    // S: O(n)
    public boolean find(int val) {
        // write your code here
        for (int num : map.keySet()) {
            int target = val - num;
            if (target == num) {
                //Important: map.get(key) can return null.
                if (map.getOrDefault(target, 0) > 1) {
                    return true;
                }
            } else {
                if (map.getOrDefault(target, 0) > 0) {
                    return true;
                }
            }
        }

        return false;
    }
}
