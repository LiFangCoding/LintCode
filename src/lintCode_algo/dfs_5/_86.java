package lintCode_algo.dfs_5;

import common.TreeNode;

import java.util.Stack;

/**
 * Design an iterator over a binary search tree with the following rules:
 *
 * <p>Elements are visited in ascending order (i.e. an in-order traversal) next() and hasNext()
 * queries run in O(1) time in average. Example For the following binary search tree, in-order
 * traversal by using iterator is [1, 6, 10, 11, 12]
 *
 * <p>10 / \ 1 11 \ \ 6 12 Challenge Extra memory usage O(h), h is the height of the tree.
 *
 * <p>Super Star: Extra memory usage O(1)
 */
public class _86 {
    public static class BSTIterator {
        Stack<TreeNode> s;

        public BSTIterator(TreeNode root) {
            // do intialization if necessary
            s = new Stack<>();
            putleft(root);
        }

        private void putleft(TreeNode node) {
            while (node != null) {
                s.push(node);
                node = node.left;
            }
        }

        /**
         * @return: True if there has next node, or false
         */
        public boolean hasNext() {
            // write your code here
            return !s.isEmpty();
        }

        /**
         * @return: return next node
         */
        public TreeNode next() {
            // write your code here
            if (!hasNext()) {
                return null;
            }

            TreeNode cur = s.pop();
            putleft(cur.right);
            return cur;
        }
    }

    // TODO
    public static class BSTIteratorlessMemory {
        // use O(1) memory. Morris

    }
}
