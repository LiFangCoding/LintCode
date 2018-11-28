package LintCode.Algorithm.BFS_4;

import common.DirectedGraphNode;

import java.util.*;

public class TopologicalSorting {
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        Map<DirectedGraphNode, Integer> indegree = new HashMap<>();

        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode nbr : node.neighbors) {
                if (indegree.containsKey(nbr)) {
                    indegree.put(nbr, indegree.get(nbr) + 1);
                } else {
                    indegree.put(nbr, 1);
                }
            }
        }

        return bfsTS(graph, indegree);
    }

    //Important: TS no need for visited mask since it cannot go back the indegree 0 vertex.
    //TS q add the node not integer since we need neighbors.
    private ArrayList<DirectedGraphNode> bfsTS(ArrayList<DirectedGraphNode> graph, Map<DirectedGraphNode, Integer> indegree) {
        Queue<DirectedGraphNode> q = new LinkedList<>();
        ArrayList<DirectedGraphNode> ans = new ArrayList<>();
        //Important: Need iterate all nodes in graph not the indegree. Indegree map can be not all.
        //cannot use for (DirectedGraphNode node : indegree.keySet())
        for (DirectedGraphNode node : graph) {
            if (!indegree.containsKey(node)) {
                q.add(node);
            }
        }

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                DirectedGraphNode cur = q.remove();
                ans.add(cur);

                for (DirectedGraphNode neigh : cur.neighbors) {
                    indegree.put(neigh, indegree.get(neigh) - 1);
                    if (indegree.get(neigh) == 0) {
                        q.add(neigh);
                    }
                }
            }
        }

        return ans;
    }
}
