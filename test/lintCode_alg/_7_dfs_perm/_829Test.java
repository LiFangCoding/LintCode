package lintCode_alg._7_dfs_perm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class _829Test {
    _829 sol = new _829();

    @Test
    void wordPatternMatch() {
        assertEquals(true, sol.wordPatternMatch("abab", "redblueredblue"));
        assertEquals(false, sol.wordPatternMatch("aabb", "xyzabcxzyabc"));
    }
}