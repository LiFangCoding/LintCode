package lintCode_alg._8_data_structure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _494Test {
    _494 sol = new _494();

    @Test
    public void valid() {
        sol.push(1);
        sol.pop();
        sol.push(2);
        assertFalse(sol.isEmpty());

        assertEquals(2, sol.top());
        sol.pop();
        assertTrue(sol.isEmpty());
    }
}