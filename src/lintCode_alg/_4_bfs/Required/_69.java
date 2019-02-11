package lintCode_alg._4_bfs.Required;

import common.NodeClass.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to
 * right, level by level).
 *
 * <p>Have you met this question in a real interview? Example Given binary tree {3,9,20,#,#,15,7},
 *
 * <p>3 / \ 9 20 / \ 15 7
 *
 * <p>return its level order traversal as:
 *
 * <p>[ [3], [9,20], [15,7] ] Challenge Challenge 1: Using only 1 queue to implement it.
 *
 * <p>Challenge 2: Use BFS algorithm to do it.
 */
public class _69 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        bfs(root, res);
        return res;
    }

    private void bfs(TreeNode s, List<List<Integer>> res) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(s);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                level.add(cur.val);

                if (cur.left != null) {
                    q.offer(cur.left);
                }

                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }

            res.add(level);
        }
    }
}
