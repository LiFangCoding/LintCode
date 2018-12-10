package lintCode_algo.dfs_5;
import common.TreeNode;

import java.util.*;

/**
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 *
 * Example
 * Given root = {1,#,2}, k = 2, return 2.
 *
 * Challenge
 * What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
 *
 * Notice
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 */
public class _902 {
    public int kthSmallest(TreeNode root, int k) {
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
