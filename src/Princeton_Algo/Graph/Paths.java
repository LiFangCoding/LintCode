package Princeton_Algo.Graph;

import edu.princeton.cs.algs4.StdOut;

public class Paths {
    // find paths in G from source s
    Paths(Graph G, int s) {

    }

    public static void main(String[] args) {
        Paths paths = new Paths(G, s);
        for (int v = 0; v < G.V(); v++) {
            //Print all vertices connected to s.
            if (paths.hasPathTo(v)) {
                StdOut.println(v);
            }
        }
    }

    // is there a path from s to v?
    boolean hasPathTo(int v) {

    }

    // path from s to v; null if no such path
    Iterable<Integer> pathTo(int v) {

    }
}
