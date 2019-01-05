package lintCode_alg._4_bfs.Optional;

import java.util.*;

/**
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of
 * nodes), write a function to check whether these edges make up a valid tree.
 *
 * <p>Example Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
 *
 * <p>Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
 *
 * <p>Notice You can assume that no duplicate edges will appear in edges. Since all edges are
 * undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 */
public class _178 {
  public boolean validTree(int n, int[][] edges) {
    if (n == 0) {
      return false;
    }

    // important. Make sure no circle if all is connected.
    if (edges.length != n - 1) {
      return false;
    }

    ArrayList<Integer>[] graph = new ArrayList[n];
    for (int i = 0; i < graph.length; i++) {
      graph[i] = new ArrayList<>();
    }
    for (int[] edge : edges) {
      int v0 = edge[0];
      int v1 = edge[1];
      graph[v0].add(v1);
      graph[v1].add(v0);
    }

    return bfsConnectedNum(graph, 0) == n;
  }

  private int bfsConnectedNum(ArrayList<Integer>[] graph, int s) {
    Queue<Integer> q = new LinkedList();
    Set<Integer> marked = new HashSet<>();

    q.add(s);
    marked.add(s);

    while (!q.isEmpty()) {
      Integer cur = q.remove();
      for (int nbr : graph[cur]) {
        if (!marked.contains(nbr)) {
          q.add(nbr);
          marked.add(nbr);
        }
      }
    }
    return marked.size();
  }
}
