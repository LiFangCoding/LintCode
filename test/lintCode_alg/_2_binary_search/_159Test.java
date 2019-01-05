package lintCode_alg._2_binary_search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class _159Test {
    _159 sol = new _159();

    @Test
    void findMin() {
        int[] nums = {4, 5, 6, 7, 8, 1, 2};

        assertEquals(1, sol.findMin(nums));
    }
}