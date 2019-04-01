package Princeton_Algo.Graph;

//Connected components
public class CC {
    private boolean[] marked;
    // id[v] = id of component containing v
    private int[] id;
    private int count;

    // find connectd components in G
    public CC(Graph G) {
        marked = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) {
                dfs(G, v);
                count++;
            }
        }
    }

    // number of connected components
    public int count() {
        return count;
    }

    public int id(int v) {
        return id[v];
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        id[v] = count;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    //are v and w connected?
    boolean connected(int v, int w) {
        return id[v] == id[w];
    }
}
