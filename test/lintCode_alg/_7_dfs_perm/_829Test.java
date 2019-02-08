package lintCode_alg._7_dfs_perm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class _829Test {
    _829 sol = new _829();

    @Test
    void wordPatternMatch() {
        assertTrue(sol.wordPatternMatch("abab", "redblueredblue"));
        assertFalse(sol.wordPatternMatch("aabb", "xyzabcxzyabc"));
    }
}