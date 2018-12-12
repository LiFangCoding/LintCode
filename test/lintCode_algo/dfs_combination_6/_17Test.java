package lintCode_algo.dfs_combination_6;

import org.junit.jupiter.api.Test;

class _17Test {
    _17.sol0 sol0 = new _17.sol0();
    _17.sol1 sol1 = new _17.sol1();

    @Test
    void subsets() {
        int[] input = new int[0];
        System.out.println(sol0.subsets(input));
        System.out.println(sol1.subsets(input));

    }
}