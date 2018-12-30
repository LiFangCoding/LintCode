package lintCode_algo._5_dfs;

import common.TreeNode;

/**
 * Given a non-empty binary search tree and a target value, find the value in the BST that is
 * closest to the target.
 *
 * <p>Example Given root = {1}, target = 4.428571, return 1.
 *
 * <p>Notice Given target value is a floating point. You are guaranteed to have only one unique
 * value in the BST that is closest to the target.
 */
public class _900 {
    private int closestValueIter(TreeNode root, double target) {
        if (root == null) {
            return 0;
        }

        TreeNode iter = root;
        TreeNode upper = iter;
        TreeNode lower = iter;

        while (iter != null) {
            if (iter.val > target) {
                upper = iter;
                iter = iter.left;
            } else if (iter.val < target) {
                lower = iter;
                iter = iter.right;
            } else {
                return iter.val;
            }
        }

        if (Math.abs(upper.val - target) > Math.abs(target - lower.val)) {
            return lower.val;
        }
        return upper.val;
    }

    public int closestValue(TreeNode root, double target) {
        // write your code here
        // root  == null
        // base case
        if (root == null) {
            return 0;
        }
        if (target < root.val) {
            if (root.left != null) {
                int left = closestValue(root.left, target);
                if (Math.abs(left - target) < Math.abs(root.val - target)) {
                    return left;
                }
            }
        } else if (target > root.val) {
            if (root.right != null) {
                int right = closestValue(root.right, target);
                if (Math.abs(right - target) < Math.abs(root.val - target)) {
                    return right;
                }
            }
        }

        return root.val;
    }
}
