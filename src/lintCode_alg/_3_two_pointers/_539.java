package lintCode_alg._3_two_pointers;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * <p>
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 * Have you met this question in a real interview?
 * Example
 * Given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 */
public class _539 {
    //TODO
    public static class sol_elegant {
        public void moveZeroes(int[] nums) {
            // write your code here
            if (nums == null || nums.length == 0) {
                return;
            }

            int len = nums.length;
            // This is to say left is the left part of array that is not 0.
            int left = 0;
            int right;

            for (right = 0; right < len; right++) {
                if (nums[right] != 0) {
                    swap(nums, left, right);
                    right--;
                    left++;
                }
            }
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    public static class sol_my_verbose {
        public void moveZeroes(int[] nums) {
            // write your code here
            if (nums == null || nums.length == 0) {
                return;
            }

            int left = 0;
            int right;

            while (true) {
                // find index is 0.
                while (left < nums.length) {
                    if (nums[left] != 0) {
                        left++;
                    } else {
                        break;
                    }
                }

                if (left == nums.length) {
                    break;
                }

                // find index after 0 that is not 0
                right = left + 1;
                while (right < nums.length) {
                    if (nums[right] == 0) {
                        right++;
                    } else {
                        break;
                    }
                }

                if (right == nums.length) {
                    break;
                }

                swap(nums, left, right);
            }
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

}
