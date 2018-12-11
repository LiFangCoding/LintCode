package lintCode_algo.dfs_5;

import common.TreeNode;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * A single node tree is a BST
 * Have you met this question in a real interview?
 * Example
 * An example:
 *
 *   2
 *  / \
 * 1   4
 *    / \
 *   3   5
 * The above binary tree is serialized as {2,1,4,#,#,3,5} (in level order).
 */
public class _95 {
    public boolean isValidBST(TreeNode root) {
        // write your code here
        return searchBST(root).isBST;
    }

    class RT {
        int min;
        int max;
        boolean isBST;
        public RT(int min, int max, boolean isBST) {
            this.min = min;
            this.max = max;
            this.isBST = isBST;
        }
    }

    private RT searchBST(TreeNode node) {
        if (node == null) {
            return new RT(Integer.min, null, true);
        }

        RT left = searchBST(node.left);
        RT right = searchBST(node.right);

        if (!left.isBST || !right.isBST) {
            return new RT(null, null, false);
        }

        TreeNode leftmin = left.min == null ? Integer.MIN_VALUE : left.min.val;
        TreeNode leftmax = left.max == null ? Integer.MIN_VALUE : left.max.val;

        TreeNode rightmin = right.min == null ? Integer.MAX_VALUE : right.max.val;
        TreeNode max = right.min == null ? Integer.MAX_VALUE : right.min.val;

        return new RT();
    }
}
