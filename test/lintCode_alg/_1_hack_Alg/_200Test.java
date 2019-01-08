package lintCode_alg._1_hack_Alg;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class _200Test {
    _200 sol = new _200();

    @Test
    void longestPalindrome() {
        assertEquals("cdzdc", sol.longestPalindrome("abcdzdcab"));
    }
}