package lintCode_alg._9_data_structure_advanced;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class _64Test {
    _64 sol = new _64();

    @Test
    void mergeSortedArray() {
        int[] A = {1, 2, 3, 6, 0, 0};
        int[] B = {4, 5};
        sol.mergeSortedArray(A, 4, B, 2);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, A);
    }
}