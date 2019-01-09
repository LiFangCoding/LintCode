package lintCode_alg._9_data_structure_advanced;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class _547Test {
    _547.Sol1_sortAndMerge sol1 = new _547.Sol1_sortAndMerge();
    int[] nums1 = {1, 2, 2, 1};
    int[] nums2 = {2, 2};

    @Test
    void sol1() {
        int[] expected = {2};
        assertArrayEquals(expected, sol1.intersection(nums1, nums2));
    }
}