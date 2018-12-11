package lintCode_algo.bfs_4.Optional;
import common.UndirectedGraphNode;

import  java.util.*;

public class _531 {
    public int sixDegrees(List<UndirectedGraphNode> graph, UndirectedGraphNode s, UndirectedGraphNode t) {
        // write your code here
        if (s == null || t == null) {
            return -1;
        }
        return bfsSteps(s, t);
    }

    private int bfsSteps(UndirectedGraphNode s, UndirectedGraphNode t) {
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        Set<UndirectedGraphNode> marked = new HashSet<>();

        q.add(s);
        marked.add(s);
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                UndirectedGraphNode cur = q.remove();
                if (cur.label == t.label) {
                    return step;
                }

                for (UndirectedGraphNode nbr : cur.nbrs) {
                    if (!marked.contains(nbr)) {
                        if (nbr.label == t.label) {
                            return step + 1;
                        }
                        q.add(nbr);
                        marked.add(nbr);
                    }
                }
            }
            step++;
        }

        return -1;
    }
}
