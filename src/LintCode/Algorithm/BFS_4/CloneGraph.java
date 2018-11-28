package LintCode.Algorithm.BFS_4;

import common.UndirectedGraphNode;

import java.util.*;

public class CloneGraph {
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
