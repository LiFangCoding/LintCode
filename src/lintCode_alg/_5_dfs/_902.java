package lintCode_alg._5_dfs;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 *
 * <p>Example Given root = {1,#,2}, k = 2, return 2.
 *
 * <p>Challenge What if the BST is modified (insert/delete operations) often and you need to find
 * the kth smallest frequently? How would you optimize the kthSmallest routine?
 *
 * <p>Notice You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 */
public class _902 {
    Map<TreeNode, Integer> map = new HashMap<>();

    public int kthSmallest(TreeNode root, int k) {
        // write your code here
        count(root);
        return search(root, k);
    }

    // cannot map.get(null)
    private int search(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }

        int left = root.left == null ? 0 : map.get(root.left);

        if (left >= k) {
            return search(root.left, k);
        } else if (left == k - 1) {
            return root.val;
        } else {
            return search(root.right, k - left - 1);
        }
    }

    private int count(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = count(node.left);
        int right = count(node.right);
        map.put(node, left + right + 1);
        return left + right + 1;
    }

    public int kthSmallest_inorderStack(TreeNode root, int k) {
        // write your code here
        if (root == null) {
            return 0;
        }
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        putleft(root.left, s);

        while (!s.isEmpty() && k != 0) {
            TreeNode cur = s.pop();
            k--;
            if (k == 0) {
                return cur.val;
            }
            if (cur.right != null) {
                s.add(cur.right);
                putleft(cur.right.left, s);
            }
        }

        return 0;
    }

    private void putleft(TreeNode node, Stack<TreeNode> s) {
        while (node != null) {
            s.add(node);
            node = node.left;
        }
    }
}
