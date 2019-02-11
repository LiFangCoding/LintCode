package lintCode_alg._5_dfs;

import common.NodeClass.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class _578Test {
    _578 sol = new _578();

    @Test
    void lowestCommonAncestor3() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(-1);

        assertEquals(sol.lowestCommonAncestor3(root, root, root.left), root);
    }

}