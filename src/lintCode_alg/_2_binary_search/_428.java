package lintCode_alg._2_binary_search;

/**
 * Implement pow(x, n).
 * <p>
 * You don't need to care about the precision of your answer, it's acceptable if the expected answer and your answer 's difference is smaller than 1e-3.
 * <p>
 * Have you met this question in a real interview?
 * Example
 * Pow(2.1, 3) = 9.261
 * Pow(0, 1) = 0
 * Pow(1, 0) = 1
 * Challenge
 * O(logn) time
 */
public class _428 {
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }

        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            //int min: -2147483648
            //int max: 2147483647, so -min is out of max bound.
            if (n == Integer.MIN_VALUE) {
                return myPow(x, n + 1) * (1 / x);
            } else {
                return 1 / myPow(x, -n);
            }
        }

        double half = myPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return x * half * half;
        }
    }
}
