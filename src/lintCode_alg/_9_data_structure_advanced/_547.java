package lintCode_alg._9_data_structure_advanced;

import java.util.*;

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
        // S: O(size of intersection)
        public int[] intersection(int[] left, int[] right) {
            // write your code here
            if (left == null || right == null) {
                return null;
            }

            List<Integer> resList = new ArrayList<>();

            Arrays.sort(left);
            Arrays.sort(right);

            int i = 0, j = 0;
            while (i < left.length && j < right.length) {
                //Intersesion no duplicate. So for example, if left index is duplication val, no need to compare it.
                if (i != 0 && left[i] == left[i - 1]) {
                    i++;
                    continue;
                }

                if (j != 0 && right[j] == right[j - 1]) {
                    j++;
                    continue;
                }

                if (left[i] == right[j]) {
                    resList.add(left[i]);
                    i++;
                    j++;
                } else if (left[i] < right[j]) {
                    i++;
                } else {
                    j++;
                }
            }

            return resList.stream().mapToInt(x -> x).toArray();
        }
    }

    //T: O(max{left, right})
    //S: O(size of interception)
    public static class Sol2_hashMap {
        public int[] intersection(int[] left, int[] right) {
            if (left == null || right == null) {
                return null;
            }

            List<Integer> res = new ArrayList<>();

            Set<Integer> set = new HashSet<>();
            for (int i : left) {
                set.add(i);
            }

            for (int i : right) {
                if (set.contains(i)) {
                    res.add(i);
                    set.remove(i);
                }
            }

            return res.stream().mapToInt(x -> x).toArray();
        }
    }

    //T: O((n + m) * logn), n choose the small size.
    public static class sol3_binary_search {
        public int[] intersection(int[] left, int[] right) {
            if (left == null || right == null) {
                return null;
            }

            if (left.length > right.length) {
                int[] temp = left;
                left = right;
                right = temp;
            }

            Set<Integer> set = new HashSet<>();

            Arrays.sort(left);
            for (int i : right) {
                if (find(i, left)) {
                    set.add(i);
                }
            }

            int[] res = new int[set.size()];
            int index = 0;
            for (int i : set) {
                res[index++] = i;
            }

            return res;
        }

        private boolean find(int target, int[] A) {
            //Imporatnt: Consider corner ase if A is empty.
            if (A == null || A.length == 0) {
                return false;
            }

            int start = 0;
            int end = A.length - 1;

            while (start + 1 < end) {
                int mid = start + (end - start) / 2;
                if (A[mid] == target) {
                    return true;
                } else if (A[mid] < target) {
                    start = mid;
                } else {
                    end = mid;
                }
            }

            return A[start] == target || A[end] == target;
        }
    }


}
