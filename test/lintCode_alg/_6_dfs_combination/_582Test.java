package lintCode_alg._6_dfs_combination;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class _582Test {
    _582 sol = new _582();

    @Test
    void wordBreak() {
        String s = "lintcode";
        Set<String> dict = new HashSet<>();
        dict.add("de");
        dict.add("ding");
        dict.add("co");
        dict.add("code");
        dict.add("lint");

        List<String> expected = new ArrayList<>();
        expected.add("lint code");
        expected.add("lint co de");
        System.out.println(sol.wordBreak(s, dict));

    }
}