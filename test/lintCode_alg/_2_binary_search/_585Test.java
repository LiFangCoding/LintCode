package lintCode_alg._2_binary_search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class _585Test {
    _585 sol = new _585();

    @Test
    void mountainSequence() {
        int[] nums = {3, 5, 3};
        assertEquals(5, sol.mountainSequence(nums));
    }
}