package leetcode_contest.contest122;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a binary tree, return the vertical order traversal of its nodes values.
 * <p>
 * For each node at position (X, Y), its left and right children respectively will be at positions (X-1, Y-1) and (X+1, Y-1).
 * <p>
 * Running a vertical line from X = -infinity to X = +infinity, whenever the vertical line touches some nodes, we report the values of the nodes in order from top to bottom (decreasing Y coordinates).
 * <p>
 * If two nodes have the same position, then the value of the node that is reported first is the value that is smaller.
 * <p>
 * Return an list of non-empty reports in order of X coordinate.  Every report will have a list of values of nodes.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: [3,9,20,null,null,15,7]
 * Output: [[9],[3,15],[20],[7]]
 * Explanation:
 * Without loss of generality, we can assume the root node is at position (0, 0):
 * Then, the node with value 9 occurs at position (-1, -1);
 * The nodes with values 3 and 15 occur at positions (0, 0) and (0, -2);
 * The node with value 20 occurs at position (1, -1);
 * The node with value 7 occurs at position (2, -2).
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: [1,2,3,4,5,6,7]
 * Output: [[4],[2],[1,5,6],[3],[7]]
 * Explanation:
 * The node with value 5 and the node with value 6 have the same position according to the given scheme.
 * However, in the report "[1,5,6]", the node value of 5 comes first since 5 is smaller than 6.
 */
public class _987 {
    List<Location> locations;

    public static void main(String[] args) {
        _987 sol = new _987();

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(5);

        System.out.println(sol.verticalTraversal(root));
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        locations = new ArrayList<>();
        dfsAllPaths(root, 0, 0);
        Collections.sort(locations);

        res.add(new ArrayList<>());
        int prevx = locations.get(0).x;

        // Or compare the ith x with the i - 1th x. Do the add or not operation.
        for (Location loc : locations) {
            if (prevx != loc.x) {
                res.add(new ArrayList<>());
                prevx = loc.x;
            }

            res.get(res.size() - 1).add(loc.val);
        }

        return res;
    }

    private void dfsAllPaths(TreeNode root, int x, int y) {
        if (root == null) {
            return;
        }

        locations.add(new Location(root.val, x, y));

        dfsAllPaths(root.left, x - 1, y + 1);
        dfsAllPaths(root.right, x + 1, y + 1);
    }

    public class Location implements Comparable<Location> {
        int x;
        int y;
        int val;

        public Location(int val, int x, int y) {
            this.val = val;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Location that) {
            if (this.x != that.x) {
                return Integer.compare(this.x, that.x);
            } else if (this.y != that.y) {
                return Integer.compare(this.y, that.y);
            } else {
                return Integer.compare(this.val, that.val);
            }
        }
    }
}
