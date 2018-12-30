package lintCode_algo._6_dfs_combination;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class _136Test {
    _136 sol = new _136();

    @Test
    void partition() {
        List<List<String>> res = sol.partition("aab");
        ArrayList<String> sol1 = new ArrayList<>();
        sol1.add("aa");
        sol1.add("b");

        ArrayList<String> sol2 = new ArrayList<>();
        sol2.add("a");
        sol2.add("a");
        sol2.add("b");

        List<List<String>> expected = new ArrayList<>();
        expected.add(sol2);
        expected.add(sol1);

        assertEquals(expected, res);
    }
}