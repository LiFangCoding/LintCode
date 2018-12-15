package lintCode_algo.dfs_5;

import common.TreeNode;

/**
 * Given a binary tree, find the subtree with minimum sum. Return the root of the subtree.
 *
 * <p>Example Given a binary tree:
 *
 * <p>1 / \ -5 2 / \ / \ 0 2 -4 -5 return the node 1.
 */
public class _596 {

    TreeNode minNode = null;
    int minSum = Integer.MAX_VALUE;

    public TreeNode findSubtree(TreeNode root) {
        // write your code here
        ResultType res = findSum(root);
        return res.minNode;
    }

    private ResultType findSum(TreeNode root) {
        if (root == null) {
            // important: the cursum shoule be 0. So the val is correct.
            return new ResultType(0, Integer.MAX_VALUE, null);
        }

        ResultType left = findSum(root.left);
        ResultType right = findSum(root.right);

        int curSum = left.sum + right.sum + root.val;
        if (left.minSum < right.minSum) {
            if (left.minSum < curSum) {
                return new ResultType(curSum, left.minSum, left.minNode);
            } else {
                return new ResultType(curSum, curSum, root);
            }
        } else {
            if (right.minSum < curSum) {
                return new ResultType(curSum, right.minSum, right.minNode);
            } else {
                return new ResultType(curSum, curSum, root);
            }
        }
    }

    private int getSumAndCpr(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = getSumAndCpr(node.left);
        int right = getSumAndCpr(node.right);
        int sum = left + right + node.val;
        if (sum < minSum) {
            minSum = sum;
            minNode = node;
        }

        return sum;
    }

    class ResultType {
        int sum;
        int minSum;
        TreeNode minNode;

        public ResultType(int cur, int min, TreeNode node) {
            sum = cur;
            minSum = min;
            minNode = node;
        }
    }
}
