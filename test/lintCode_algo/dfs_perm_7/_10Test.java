package lintCode_algo.dfs_perm_7;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class _10Test {
    _10 sol = new _10();

    @Test
    void stringPermutation2() {
        String s = "abb";
        List<String> exp = new ArrayList<>();
        exp.add("abb");
        exp.add("bab");
        exp.add("bba");

        assertEquals(exp, sol.stringPermutation2(s));
    }
}