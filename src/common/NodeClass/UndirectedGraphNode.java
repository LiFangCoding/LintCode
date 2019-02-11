package common.NodeClass;

import java.util.ArrayList;

public class UndirectedGraphNode {
    public int label;
    public ArrayList<UndirectedGraphNode> nbrs;

    public UndirectedGraphNode(int x) {
        label = x;
        nbrs = new ArrayList<>();
    }
}
