package lintCode_alg._2_binary_search;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class _460Test {
    _460 sol = new _460();

    @Test
    void kClosestNumbers() {
        int[] A = {1, 4, 6, 8};

        System.out.println(Arrays.toString(sol.kClosestNumbers(A, 3, 3)));
    }
}