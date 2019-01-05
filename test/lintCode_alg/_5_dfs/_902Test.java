package lintCode_alg._5_dfs;

import common.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class _902Test {
    _902 sol;

    @BeforeEach
    void setUp() {
        sol = new _902();
    }

    @Test
    void kthSmallest() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        assertEquals(sol.kthSmallest(root, 1), 1);
    }
}