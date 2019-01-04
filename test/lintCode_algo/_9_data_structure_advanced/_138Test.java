package lintCode_algo._9_data_structure_advanced;

import org.junit.jupiter.api.Test;

class _138Test {
    _138 sol = new _138();
    int[] nums = {-3, 1, 2, -3, 4};

    @Test
    void subarraySum() {
        System.out.println(sol.subarraySum(nums));
    }
}