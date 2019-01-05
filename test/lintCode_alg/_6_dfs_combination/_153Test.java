package lintCode_alg._6_dfs_combination;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class _153Test {
    _153 sol = new _153();

    @Test
    void combinationSum2() {
        int[] input = {10, 1, 6, 7, 2, 1, 5};
        String expected = "[[1, 1, 6], [1, 2, 5], [1, 7], [2, 6]]";
        assertEquals(expected, sol.combinationSum2(input, 8).toString());
    }
}