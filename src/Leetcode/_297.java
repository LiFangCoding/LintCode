package Leetcode;

import common.TreeNode;

import java.util.*;

public class _297 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // BFS order to do it
        if(root == null) return "";

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i  = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if (temp == null) {
                    sb.append("null");
                    sb.append(",");
                    continue;
                    // important one, continue
                }
                else {
                    sb.append(temp.val);
                    sb.append(",");
                }
                queue.offer(temp.left);
                queue.offer(temp.right);
            }
        }

        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        //deserialize ()// data as  root
        if (data == null || data.length() == 0) {
            return null;
        }

        String[] str = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(str[0]));

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int index = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.remove();
                String leftVal = str[index++];
                String rightVal = str[index++];

                if (!leftVal.equals("null")) {
                    int val = Integer.parseInt(leftVal);
                    temp.left = new TreeNode(val);
                    queue.add(temp.left);
                }

                if (!rightVal.equals("null")) {
                    int val = Integer.parseInt(rightVal);
                    temp.right = new TreeNode(val);
                    queue.add(temp.right);
                }
            }
        }

        return root;
    }

    public static void main(String[] args) {
        _297 sol = new _297();
        String s = "1,2,3,null,null,4,5";
        sol.deserialize(s);
    }
}
