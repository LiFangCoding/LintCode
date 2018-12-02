package lintCode_algo.dfs_5;
import common.TreeNode;

/**
 *Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
 *
 * Example
 * Given root = {1}, target = 4.428571, return 1.
 *
 * Notice
 * Given target value is a floating point.
 * You are guaranteed to have only one unique value in the BST that is closest to the target.
 */
public class _900 {
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

    private int closestValueNoRecursion(TreeNode root, double target) {
        if (root == null){
            return 0;
        }

        TreeNode upper = root;
        TreeNode lower = root;

        while (root != null){
            if (root.val > target){
                upper = root;
                root = root.left;
            }else if (root.val < target){
                lower = root;
                root = root.right;
            }else {
                return root.val;
            }
        }

        if (Math.abs(upper.val - target) > Math.abs(target - lower.val)){
            return lower.val;
        }
        return upper.val;
    }
}
