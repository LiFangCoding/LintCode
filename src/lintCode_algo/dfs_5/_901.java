package lintCode_algo.dfs_5;
import common.TreeNode;

import java.util.*;

//TODO: HARD copy
public class _901 {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Stack<TreeNode> next = new Stack<TreeNode>();
        Stack<TreeNode> prev = new Stack<TreeNode>();
        TreeNode node = root;

        // find the nodes closest to target
        while (node != null) {
            if (node.val < target) {
                prev.push(node);
                node = node.right;
            } else {
                next.push(node);
                node = node.left;
            }
        }

        List<Integer> ret = new LinkedList<Integer>();

        while (ret.size() < k) {
            double distp = prev.isEmpty() ? Integer.MAX_VALUE : Math.abs(prev.peek().val - target);
            double distn = next.isEmpty() ? Integer.MAX_VALUE : Math.abs(next.peek().val - target);

            // compare and find the closest node, and move the corresponding stack.
            if (distp < distn) {
                ret.add(0, prev.peek().val);
                goPrev(prev);
            } else {
                ret.add(next.peek().val);
                goNext(next);
            }
        }

        return ret;
    }

    private void goNext(Stack<TreeNode> st) {
        TreeNode r = st.pop().right;

        while (r != null) {
            st.push(r);
            r = r.left;
        }
    }

    private void goPrev(Stack<TreeNode> st) {
        TreeNode l = st.pop().left;

        while (l != null) {
            st.push(l);
            l = l.right;
        }
    }
}
