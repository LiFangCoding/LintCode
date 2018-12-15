package lintCode_algo.dfs_5;

import common.TreeNode;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * <p>Assume a BST is defined as follows:
 *
 * <p>The left subtree of a node contains only nodes with keys less than the node's key. The right
 * subtree of a node contains only nodes with keys greater than the node's key. Both the left and
 * right subtrees must also be binary search trees. A single node tree is a BST Have you met this
 * question in a real interview? Example An example:
 *
 * <p>2 / \ 1 4 / \ 3 5 The above binary tree is serialized as {2,1,4,#,#,3,5} (in level order).
 */
public class _95 {

    public static class sol1 {
        public boolean isValidBST(TreeNode root) {
            // write your code here
            return divConq(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        private boolean divConq(TreeNode root, long min, long max) {
            if (root == null) {
                return true;
            }
            if (root.val <= min || root.val >= max) {
                return false;
            }
            return divConq(root.left, min, root.val) && divConq(root.right, root.val, max);
        }
    }
}
