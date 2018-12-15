package lintCode_algo.bfs_4.Required;

import common.UndirectedGraphNode;

import java.util.*;

/**
 * Description Clone an undirected graph. Each node in the graph contains a label and a list of its
 * nbrs.
 *
 * <p>How we serialize an undirected graph:
 *
 * <p>Nodes are labeled uniquely.
 *
 * <p>We use # as a separator for each node, and , as a separator for node label and each neighbor
 * of the node.
 *
 * <p>As an example, consider the serialized graph {0,1,2#1,2#2,2}.
 *
 * <p>The graph has a total of three nodes, and therefore contains three parts as separated by #.
 *
 * <p>First node is labeled as 0. Connect node 0 to both nodes 1 and 2. Second node is labeled as 1.
 * Connect node 1 to node 2. Third node is labeled as 2. Connect node 2 to node 2 (itself), thus
 * forming a self-cycle. Visually, the graph looks like the following:
 *
 * <p>1 / \ / \ 0 --- 2 / \ \_/ Have you met this question in a real interview? Example return a
 * deep copied graph.
 */
public class _137 {
    //      从1个点找到所有点
    // 复制所有的点
    // 复制所有的边
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode s) {
        if (s == null) {
            return null;
        }

        List<UndirectedGraphNode> nodes = bfsGetNodes(s);
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();

        // copy and map nodes
        for (UndirectedGraphNode node : nodes) {
            UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
            map.put(node, newNode);
        }

        // copy Links
        for (UndirectedGraphNode node : nodes) {
            UndirectedGraphNode newNode = map.get(node);

            List<UndirectedGraphNode> neighs = node.nbrs;
            for (UndirectedGraphNode neigh : neighs) {
                UndirectedGraphNode newNeigh = map.get(neigh);
                newNode.nbrs.add(newNeigh);
            }
        }

        return map.get(s);
    }

    // [1,0,2]
    private List<UndirectedGraphNode> bfsGetNodes(UndirectedGraphNode s) {
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        List<UndirectedGraphNode> res = new ArrayList<>();
        Set<UndirectedGraphNode> marked = new HashSet<>();

        q.add(s);
        marked.add(s);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                UndirectedGraphNode cur = q.remove();

                res.add(cur);
                for (UndirectedGraphNode neigh : cur.nbrs) {
                    if (!marked.contains(neigh)) {
                        q.add(neigh);
                        marked.add(neigh);
                    }
                }
            }
        }

        return res;
    }
}
