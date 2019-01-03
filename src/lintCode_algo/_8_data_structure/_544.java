package lintCode_algo._8_data_structure;

import java.util.PriorityQueue;

/**
 * Description
 * Given an integer array, find the top k largest numbers in it.
 * <p>
 * Have you met this question in a real interview?
 * Example
 * Given [3,10,1000,-99,4,100] and k = 3.
 * Return [1000, 100, 10].
 */
public class _544 {
    public static class sol1_PQ {
        public int[] topk(int[] nums, int k) {
            // To get the k largest. Use the min pq. Since it will remove the smallest one.
            if (nums == null || nums.length < k) {
                return new int[]{};
            }
            PriorityQueue<Integer> pq = new PriorityQueue<>(k);
            for (int num : nums) {
                pq.add(num);
                if (pq.size() > k) {
                    pq.remove();
                }
            }

            int[] res = new int[k];
            int i = k - 1;
            while (!pq.isEmpty()) {
                res[i--] = pq.remove();
            }

            return res;
        }
    }

    //TODO
    public class sol1_QuickSelect {

    }
}
