package lintCode_alg._1_hack_Alg;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

class _415Test {
    _415 sol = new _415();

    @Test
    void isPalindrome() {
        assertFalse(sol.isPalindrome("1a2"));
    }
}