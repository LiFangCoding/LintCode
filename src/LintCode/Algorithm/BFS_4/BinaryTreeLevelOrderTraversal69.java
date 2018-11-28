package LintCode.Algorithm.BFS_4;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal69 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // write your code here
        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        bfs(root, ans);
        return ans;
    }

    private void bfs(TreeNode s, List<List<Integer>> ans) {
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

            ans.add(level);
        }
    }
}
