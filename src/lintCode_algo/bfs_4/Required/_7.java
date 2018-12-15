package lintCode_algo.bfs_4.Required;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Design an algorithm and write code to serialize and deserialize a binary tree. Writing the tree
 * to a file is called 'serialization' and reading back from the file to reconstruct the exact same
 * binary tree is 'deserialization'.
 *
 * <p>Example An example of testdata: Binary tree {3,9,20,#,#,15,7}, denote the following structure:
 *
 * <p>3 / \ 9 20 / \ 15 7 Our data serialization use bfs traversal. This is just for when you got
 * wrong answer and want to debug the input.
 *
 * <p>You can use other method to do serializaiton and deserialization.
 *
 * <p>Notice There is no limit of how you deserialize or serialize a binary tree, lintCode_algo will
 * take your output of serialize as the input of deserialize, it won't check the result of
 * serialize.serialize
 */
public class _7 {
    public static void main(String[] args) {
        _7 sol = new _7();
        String s = "{1,2,#}";
        sol.deserialize(s);
    }

    public String serialize(TreeNode root) {
        // write your code here
        if (root == null) {
            return "";
        }

        return bfsSerial(root);
    }

    private String bfsSerial(TreeNode s) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        Queue<TreeNode> q = new LinkedList<>();
        q.add(s);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.remove();
                if (cur == null) {
                    sb.append(",#");
                } else {
                    sb.append(",");
                    sb.append(cur.val);
                    q.add(cur.left);
                    q.add(cur.right);
                }
            }
        }

        sb.deleteCharAt(1);
        sb.append("}");
        return sb.toString();
    }

    /**
     * This method will be invoked second, the argument data is what exactly you serialized at method
     * "serialize", that means the data is not given by system, it's given by your own serialize
     * method. So the format of data is designed by yourself, and deserialize it here as you serialize
     * it in "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
        if (data == null || data.length() < 2) {
            return null;
        }

        String[] vals = data.substring(1, data.length() - 1).split(",");
        if (vals.length == 0) {
            return null;
        }

        TreeNode ans = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(ans);

        for (int i = 1; i < vals.length; i++) {
            TreeNode cur = q.remove();
            if (!vals[i].equals("#")) {
                cur.left = new TreeNode(Integer.parseInt(vals[i]));
                q.offer(cur.left);
            }

            i++;

            if (!vals[i].equals("#")) {
                cur.right = new TreeNode(Integer.parseInt(vals[i]));
                q.add(cur.right);
            }
        }

        return ans;
    }
}
