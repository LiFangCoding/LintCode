package lintCode_alg._8_data_structure;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
 * <p>
 * Have you met this question in a real interview?
 * Example
 * MovingAverage m = new MovingAverage(3);
 * m.next(1) = 1 // return 1.00000
 * m.next(10) = (1 + 10) / 2 // return 5.50000
 * m.next(3) = (1 + 10 + 3) / 3 // return 4.66667
 * m.next(5) = (10 + 3 + 5) / 3 // return 6.00000
 */
public class _642 {
    class MovingAverage {
        private Queue<Integer> queue;
        private int size;
        private double sum;

        /*
         * @param size: An integer
         */
        public MovingAverage(int size) {
            // do intialization if necessary
            queue = new LinkedList<>();
            this.size = size;
        }

        /*
         * @param val: An integer
         * @return:
         */
        public double next(int val) {
            // write your code here
            int cursize = queue.size();
            if (cursize == size) {
                sum -= queue.remove();
            }
            sum += val;
            queue.add(val);
            return sum / queue.size();
        }
    }
}
