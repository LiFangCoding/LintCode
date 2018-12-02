package LintCode_Algo.BFS_4;

import common.UndirectedGraphNode;

import java.util.*;

/**
 * Description
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 *
 * How we serialize an undirected graph:
 *
 * Nodes are labeled uniquely.
 *
 * We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
 *
 * As an example, consider the serialized graph {0,1,2#1,2#2,2}.
 *
 * The graph has a total of three nodes, and therefore contains three parts as separated by #.
 *
 * First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
 * Second node is labeled as 1. Connect node 1 to node 2.
 * Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
 * Visually, the graph looks like the following:
 *
 *    1
 *   / \
 *  /   \
 * 0 --- 2
 *      / \
 *      \_/
 * Have you met this question in a real interview?
 * Example
 * return a deep copied graph.
 */
public class _137 {
    //      从1个点找到所有点
    // 复制所有的点
    // 复制所有的边
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode s) {
        // write your code here
        if (s == null) {
            return null;
        }

        List<UndirectedGraphNode> nodes = bfsGetNodes(s);
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();

        //copy and map nodes
        for (UndirectedGraphNode node : nodes) {
            UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
            map.put(node, newNode);
        }

        //copy Links
        for (UndirectedGraphNode node : nodes) {
            UndirectedGraphNode newNode = map.get(node);

            List<UndirectedGraphNode> neighs = node.neighbors;
            for (UndirectedGraphNode neigh : neighs) {
                UndirectedGraphNode newNeigh = map.get(neigh);
                newNode.neighbors.add(newNeigh);
            }
        }

        return map.get(s);
    }

    //[1,0,2]
    private List<UndirectedGraphNode> bfsGetNodes(UndirectedGraphNode s) {
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        List<UndirectedGraphNode> ans = new ArrayList<>();
        Set<UndirectedGraphNode> v = new HashSet<>();

        q.add(s);
        v.add(s);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                UndirectedGraphNode cur = q.remove();

                ans.add(cur);
                for (UndirectedGraphNode neigh : cur.neighbors) {
                    if (!v.contains(neigh)) {
                        q.add(neigh);
                        v.add(neigh);
                    }
                }
            }
        }

        return ans;
    }
}
