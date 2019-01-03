package lintCode_algo._8_data_structure;

import java.util.*;

/**
 * Ugly number is a number that only have factors 2, 3 and 5.
 * <p>
 * Design an algorithm to find the nth ugly number. The first 10 ugly numbers are 1, 2, 3, 4, 5, 6, 8, 9, 10, 12...
 * <p>
 * Note that 1 is typically treated as an ugly number.
 * <p>
 * Have you met this question in a real interview?
 * Example
 * If n=9, return 10.
 * <p>
 * Challenge
 * O(n log n) or O(n) time.
 */
public class _4 {

    public static class sol_linear {
        //Time complexity: O(n)
        //Space: O(n)
        public int nthUglyNumber(int n) {
            // write your code here
            List<Integer> res = new ArrayList<>();
            //avoid magic number. Put in an array.
            int[] factors = {2, 3, 5};

            res.add(1);
            int idx0 = 0;
            int idx1 = 0;
            int idx2 = 0;

            while (res.size() < n) {
                // find next ugly number large by 2, 3, 5.
                int last = res.get(res.size() - 1);
                while (res.get(idx0) * factors[0] <= last) {
                    idx0++;
                }
                int uglyfactor0 = res.get(idx0) * factors[0];

                while (res.get(idx1) * factors[1] <= last) {
                    idx1++;
                }
                int uglyfactor1 = res.get(idx1) * factors[1];

                while (res.get(idx2) * factors[2] <= last) {
                    idx2++;
                }
                int uglyfactor2 = res.get(idx2) * factors[2];

                int nextUgly = Math.min(Math.min(uglyfactor0, uglyfactor1), uglyfactor2);

                res.add(nextUgly);
            }

            return res.get(n - 1);
        }
    }

    public static class sol_pqAndSet {
        //Time complexity: O(nlogn)
        //Space: O(n)
        // Important: cannot use the int value. Since will have overflow here.
        public int nthUglyNumber(int n) {
            PriorityQueue<Long> pq = new PriorityQueue();
            Set<Long> set = new HashSet<>();

            //avoid magic number. Put in an array.
            Long[] factors = {Long.valueOf(2), Long.valueOf(3), Long.valueOf(5)};
            int count = 1;
            pq.add(Long.valueOf(1));
            set.add(Long.valueOf(1));
            Long res = null;

            //here set is not ordered. So cannot determine the nth value when pq size is n.
            // The pq remove int value is in order.
            for (int i = 1; i <= n; i++) {
                long smallest = pq.remove();
                if (i == n) {
                    res = smallest;
                    break;
                }
                for (long factor : factors) {
                    long ugly = smallest * factor;
                    if (!set.contains(ugly)) {
                        pq.add(ugly);
                        set.add(ugly);
                    }
                }
            }
            return res.intValue();
        }
    }

}
