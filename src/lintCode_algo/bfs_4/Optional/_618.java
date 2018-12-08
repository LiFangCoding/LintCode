package lintCode_algo.bfs_4.Optional;
import common.UndirectedGraphNode;

import java.util.*;

/**
 * Given a undirected graph, a node and a target, return the nearest node to given node which value of it is target, return NULL if you can't find.
 *
 * There is a mapping store the nodes' values in the given parameters.
 *
 * It's guaranteed there is only one available solution
 *
 * Have you met this question in a real interview?
 * Example
 * 2------3  5
 *  \     |  |
 *   \    |  |
 *    \   |  |
 *     \  |  |
 *       1 --4
 * Give a node 1, target is 50
 *
 * there a hash named values which is [3,4,10,50,50], represent:
 * Value of node 1 is 3
 * Value of node 2 is 4
 * Value of node 3 is 10
 * Value of node 4 is 50
 * Value of node 5 is 50
 *
 * Return node 4
 */
public class _618 {
    public UndirectedGraphNode searchNode(ArrayList<UndirectedGraphNode> graph,
                                          Map<UndirectedGraphNode, Integer> values,
                                          UndirectedGraphNode node,
                                          int target) {
        // write your code here
        if (node == null) {
            return null;
        }

        return bfs(node, values, target);
    }

    private UndirectedGraphNode bfs(UndirectedGraphNode s, Map<UndirectedGraphNode, Integer> map, int target) {
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        Set<UndirectedGraphNode> marked = new HashSet<>();

        q.add(s);
        marked.add(s);

        while (!q.isEmpty()) {
            // no need use size to level by level.
            UndirectedGraphNode cur = q.remove();
            if (map.get(cur) == target) {
                return cur;
            }

            for (UndirectedGraphNode nbr : cur.neighbors) {
                if (!marked.contains(nbr)) {
                    q.add(nbr);
                    marked.add(nbr);
                }
            }
        }
        return null;
    }
}
