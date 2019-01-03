package lintCode_algo._8_data_structure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class _4Test {

    @Test
    void nthUglyNumber() {
        _4.sol_linear sol_linear = new _4.sol_linear();
        assertEquals(10, sol_linear.nthUglyNumber(9));

        _4.sol_pqAndSet sol_pqAndSet = new _4.sol_pqAndSet();
        assertEquals(10, sol_pqAndSet.nthUglyNumber(9));

    }
}