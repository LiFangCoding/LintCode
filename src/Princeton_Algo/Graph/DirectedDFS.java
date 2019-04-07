package Princeton_Algo.Graph;

public class DirectedDFS {
    private boolean[] marked;

    // constructor marks vertices reachable from s
    public DirectedDFS(Digraph G, int s) {
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    private void dfs(Digraph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    public boolean visited(int v) {
        return marked[v];
    }
}
