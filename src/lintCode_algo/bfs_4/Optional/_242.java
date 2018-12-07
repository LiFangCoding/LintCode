package lintCode_algo.bfs_4.Optional;
import common.ListNode;
import common.TreeNode;

import java.util.*;
/**
 * Given a binary tree, design an algorithm which creates a linked list of all the nodes at each depth (e.g., if you have a tree with depth D, you'll have D linked lists).
 *
 * Example
 * Given binary tree:
 *
 *     1
 *    / \
 *   2   3
 *  /
 * 4
 * return
 *
 * [
 *   1->null,
 *   2->3->null,
 *   4->null
 * ]
 */
public class _242 {
    public List<ListNode> binaryTreeToLists(TreeNode root) {
        // Write your code here
        List<ListNode> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        return bfs(root);
    }

    public List<ListNode> bfs(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<ListNode> ans = new ArrayList<>();

        while (!q.isEmpty()) {
            int size = q.size();
            //two lines important. else dummy together. Put outside of for loop. Set the glocal now.
            ListNode dummy = new ListNode(0);
            ListNode iter = dummy;
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.remove();
                iter.next = new ListNode(cur.val);
                iter = iter.next;

                if (cur.left != null) {
                    q.add(cur.left);
                }
                if (cur.right != null) {
                    q.add(cur.right);
                }
            }
            ans.add(dummy.next);
        }
        return ans;
    }
}
