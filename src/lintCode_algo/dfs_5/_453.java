package lintCode_algo.dfs_5;

import common.TreeNode;

/**
 * Flatten a binary tree to a fake "linked list" in pre-order traversal.
 *
 * <p>Here we use the right pointer in TreeNode as the next pointer in ListNode.
 *
 * <p>Example 1 \ 1 2 / \ \ 2 5 => 3 / \ \ \ 3 4 6 4 \ 5 \ 6 Challenge Do it in-place without any
 * extra memory.
 *
 * <p>Notice Don't forget to mark the left child of each node to null. Or you will get Time Limit
 * Exceeded or Memory Limit Exceeded.
 */
public class _453 {
    public void flatten(TreeNode root) {
        // write your code here
        flat(root);
    }

    // Important: return last.
    private TreeNode flat(TreeNode node) {
        if (node == null) {
            return null;
        }

        TreeNode leftlast = flat(node.left);
        TreeNode rightlast = flat(node.right);

        if (leftlast != null) {
            leftlast.left = null;
            leftlast.right = node.right;
            node.right = node.left;
            node.left = null;
        }

        // since if leftlast is null, the root.right = right directly. No need to change.
        if (rightlast != null) {
            return rightlast;
        }

        if (leftlast != null) {
            return leftlast;
        }
        return node;
    }

    // TODO: use stack to do.

}
