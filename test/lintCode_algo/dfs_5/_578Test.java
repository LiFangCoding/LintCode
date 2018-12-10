package lintCode_algo.dfs_5;

import common.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _578Test {
    _578 sol = new _578();

    @Test
    void lowestCommonAncestor3() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(-1);

        assertEquals(sol.lowestCommonAncestor3(root, root, root.left), root);
    }

}