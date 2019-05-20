package lintCode_alg._5_dfs;

import common.NodeClass.TreeNode;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key. The right
 * subtree of a node contains only nodes with keys greater than the node's key. Both the left and
 * right subtrees must also be binary search trees. A single node tree is a BST Have you met this
 * question in a real interview? Example An example:
 *
 * 2 / \ 1 4 / \ 3 5 The above binary tree is serialized as {2,1,4,#,#,3,5} (in level order).
 */
public class _95 {

    public static class sol1 {

        public boolean isValidBST(TreeNode root) {
//            return divConq(root, Long.MIN_VALUE, Long.MAX_VALUE);
            return getRes(root).isBST;
        }

        /**
         * check each node is in the min ~ max value.
         */
        private boolean divConq(TreeNode root, long min, long max) {
            if (root == null) {
                return true;
            }
            if (root.val <= min || root.val >= max) {
                return false;
            }
            return divConq(root.left, min, root.val) && divConq(root.right, root.val, max);
        }

        public Result getRes(TreeNode node) {
            if (node == null) {
                return new Result(true, Integer.MIN_VALUE, Integer.MAX_VALUE);
            }

            Result left = getRes(node.left);
            Result right = getRes(node.right);

            if (!left.isBST || !right.isBST) {
                return new Result(false, 0, 0);
            }

            boolean isBST = (node.val > left.max) && (node.val < right.min);
            return new Result(isBST, right.max, left.min);
        }

        class Result {
            boolean isBST;
            int max;
            int min;

            public Result(boolean isBST, int max, int min) {
                this.isBST = isBST;
                this.max = max;
                this.min = min;
            }
        }
    }
}
