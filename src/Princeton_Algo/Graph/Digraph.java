package Princeton_Algo.Graph;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

public class Digraph {
    private final int V;
    private final Bag<Integer>[] adj;

    public Digraph(int V) {
        this.V = V;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }
    }

    Digraph(In in) {

    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    Iterable<Integer> adj(int v) {
        return adj[v];
    }

    int V() {

    }

    int E() {

    }

    Digraph reverse() {

    }

    String toString() {

    }


}
