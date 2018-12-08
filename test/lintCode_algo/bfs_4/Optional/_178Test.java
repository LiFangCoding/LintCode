package lintCode_algo.bfs_4.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _178Test {
    _178 sol;
    @BeforeEach
    void setUp() {
       sol = new _178();
    }

    @Test
    void validTreeFalse() {
        int n = 3;
        int[][] edges = {{0,1}, {0,2}, {1, 2}};
        assertFalse(sol.validTree(n, edges));
    }

    @Test
    void validTree() {
        int n = 5;
        int[][] edges = {{0,1}, {0,2}, {0, 3}, {1, 4}};
        assertTrue(sol.validTree(n, edges));
    }
}