package lintCode_algo.data_structure_8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class _494Test {
    _494 sol = new _494();

    @Test
    public void valid() {
        sol.push(1);
        sol.pop();
        sol.push(2);
        assertEquals(false, sol.isEmpty());

        assertEquals(2, sol.top());
        sol.pop();
        assertEquals(true, sol.isEmpty());
    }
}