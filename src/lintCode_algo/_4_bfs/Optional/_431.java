package lintCode_algo._4_bfs.Optional;

import common.UndirectedGraphNode;

import java.util.*;

public class _431 {
    public List<List<Integer>> connectedSet(List<UndirectedGraphNode> nodes) {
        // write your code here
        List<List<Integer>> ans = new ArrayList<>();
        if (nodes == null || nodes.size() == 0) {
            return ans;
        }

        Set<UndirectedGraphNode> marked = new HashSet<>();
        for (UndirectedGraphNode node : nodes) {
            if (!marked.contains(node)) {
                List<Integer> cc = bfsCC(node, marked);
                Collections.sort(cc);
                ans.add(cc);
            }
        }
        return ans;
    }

    // CC is for connected component
    private List<Integer> bfsCC(UndirectedGraphNode s, Set<UndirectedGraphNode> marked) {
        // Important: list of node or list of node value.
        List<Integer> cc = new ArrayList<>();
        Queue<UndirectedGraphNode> q = new LinkedList<>();

        q.add(s);
        marked.add(s);

        while (!q.isEmpty()) {
            UndirectedGraphNode cur = q.remove();
            cc.add(cur.label);

            for (UndirectedGraphNode nbr : cur.nbrs) {
                if (!marked.contains(nbr)) {
                    q.add(nbr);
                    marked.add(nbr);
                }
            }
        }
        return cc;
    }
}
