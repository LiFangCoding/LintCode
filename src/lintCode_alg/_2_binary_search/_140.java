package lintCode_alg._2_binary_search;

/**
 * Calculate the an % b where a, b and n are all 32bit positive integers.
 * <p>
 * Have you met this question in a real interview?
 * Example
 * For 231 % 3 = 2
 * <p>
 * For 1001000 % 1000 = 0
 * <p>
 * Challenge
 * O(logn)
 */
public class _140 {
    //TODO
    //(ab)%c = (a%c)(b%c)%c
    public int fastPower(int a, int b, int n) {
        if (a == 1) {
            return 1 % b;
        }

        if (n == 0) {
            return 1 % b;
        }

        // long type since overflow.
        long product = fastPower(a, b, n / 2);
        product = (product * product) % b;
        if (n % 2 == 1) {
            product = (product * a) % b;
        }
        return (int) product;
    }
}
