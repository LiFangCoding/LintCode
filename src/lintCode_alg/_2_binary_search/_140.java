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
        if (n == 0) {
            return 1 % b;
        }

        if (a == 1) {
            return 1 % b;
        }

        long product = fastPower(a, b, n / 2);
        long res = (product * product) % b;

        if (n % 2 == 1) {
            res = (res * (a % b)) % b;
        }


        return (int) res;
    }
}
