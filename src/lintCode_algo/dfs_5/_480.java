package lintCode_algo.dfs_5;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return all root-to-leaf paths.
 *
 * <p>Example Given the following binary tree:
 *
 * <p>1 / \ 2 3 \ 5 All root-to-leaf paths are:
 *
 * <p>[ "1->2->5", "1->3" ]
 */
public class _480 {
    public List<String> binaryTreePaths(TreeNode root) {
        // write your code here
        List<String> res = new ArrayList<>();
        traverse(root, "", res);

        // return findPaths(node);
        return res;
    }

    private List<String> findPaths(TreeNode node) {
        List<String> paths = new ArrayList<>();
        if (node == null) {
            return paths;
        }

        if (node.left == null && node.right == null) {
            paths.add("" + node.val);
            return paths;
        }

        List<String> leftPaths = binaryTreePaths(node.left);
        List<String> rightPaths = binaryTreePaths(node.right);

        for (String path : leftPaths) {
            paths.add(node.val + "->" + path);
        }
        for (String path : rightPaths) {
            paths.add(node.val + "->" + path);
        }

        return paths;
    }

    private void traverse(TreeNode node, String path, List<String> paths) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            paths.add(path + node.val);
            return;
        }

        traverse(node.left, path + node.val + "->", paths);
        traverse(node.right, path + node.val + "->", paths);
    }
}
