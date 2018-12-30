package lintCode_algo._5_dfs;

import common.TreeNode;

/**
 * Given a binary tree, determine if it is height-balanced.
 *
 * <p>For this problem, a height-balanced binary tree is defined as a binary tree in which the depth
 * of the two subtrees of every node never differ by more than 1.
 */
public class _93 {
    public boolean isBalanced(TreeNode root) {
        // write your code here
        return getHandB(root).isB;
    }

    private Rt getHandB(TreeNode node) {
        if (node == null) {
            return new Rt(0, true);
        }

        Rt left = getHandB(node.left);
        Rt right = getHandB(node.right);

        if (!left.isB || !right.isB || Math.abs(left.h - right.h) > 1) {
            return new Rt(-1, false);
        }

        return new Rt(Math.max(left.h, right.h) + 1, true);
    }

    class Rt {
        int h;
        boolean isB;

        public Rt(int h, boolean isB) {
            this.h = h;
            this.isB = isB;
        }
    }
}
