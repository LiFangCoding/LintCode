package lintCode_alg._9_data_structure_advanced;

import java.util.Arrays;

/**
 * Given two arrays, write a function to compute their intersection.
 * <p>
 * Each element in the result must be unique.
 * The result can be in any order.
 * Have you met this question in a real interview?
 * Example
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 * <p>
 * Challenge
 * Can you implement it in three different algorithms?
 */
public class _547 {
    public static class Sol1_sortAndMerge {
        //T: O(nlogn) + O(mlogm) + O(min(m, n))
        public int[] intersection(int[] nums1, int[] nums2) {
            // write your code here
            Arrays.sort(nums1);
            Arrays.sort(nums2);

            int i = 0, j = 0;
            int[] temp = new int[nums1.length];
            int index = 0;
            while (i < nums1.length && j < nums2.length) {
                //Intersesion no duplicate
                if (nums1[i] == nums2[j]) {
                    int sameVal = nums1[i];
                    if (index == 0) {
                        temp[index++] = sameVal;
                    } else if (temp[index - 1] != nums1[i]) {
                        temp[index++] = nums1[i];
                    }
                    i++;
                    j++;
                } else if (nums1[i] < nums2[j]) {
                    i++;
                } else {
                    j++;
                }
            }

            int[] result = new int[index];
            for (int k = 0; k < index; k++) {
                result[k] = temp[k];
            }

            return result;
        }
    }
}
