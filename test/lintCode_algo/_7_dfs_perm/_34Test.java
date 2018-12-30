package lintCode_algo._7_dfs_perm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class _34Test {
    _34 sol = new _34();

    @Test
    void totalNQueens() {

        assertEquals(2, sol.totalNQueens(4));
    }
}