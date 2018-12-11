package lintCode_algo.bfs_4.Required;

import common.DirectedGraphNode;

import java.util.*;

/**
 * Description
 * Given an directed graph, a topological order of the graph nodes is defined as follow:
 *
 * For each directed edge A -> B in graph, A must before B in the order list.
 * The first node in the order can be any node in the graph with no nodes direct to it.
 * Find any topological order for the given graph.
 *
 * You can assume that there is at least one topological order in the graph.
 *
 * Have you met this question in a real interview?
 * Clarification
 * Learn more about representation of graphs
 *
 * Example
 * For graph as follow:
 *
 * picture
 *
 * The topological order can be:
 *
 * [0, 1, 2, 3, 4, 5]
 * [0, 2, 3, 1, 5, 4]
 * ...
 * Challenge
 * Can you do it in both BFS and DFS?
 */
public class _127_BFS {
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        Map<DirectedGraphNode, Integer> indegree = new HashMap<>();

        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode nbr : node.nbrs) {
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
    //TS q add the node not integer since we need nbrs.
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

                for (DirectedGraphNode neigh : cur.nbrs) {
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
