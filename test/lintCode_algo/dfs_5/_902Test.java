package lintCode_algo.dfs_5;

import common.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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