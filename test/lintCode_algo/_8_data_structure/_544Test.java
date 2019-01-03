package lintCode_algo._8_data_structure;

import lintCode_algo._8_data_structure._544.sol1_PQ;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class _544Test {
    @Test
    void test1() {
        int[] nums = {3, 10, 1000, -99, 4, 100};
        sol1_PQ sol1 = new sol1_PQ();
        int[] expected = {1000, 100, 10};
        assertArrayEquals(expected, sol1.topk(nums, 3));
    }
}