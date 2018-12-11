package common;

import java.util.ArrayList;

public class DirectedGraphNode {
    public int label;
    public ArrayList<DirectedGraphNode> nbrs;

    DirectedGraphNode(int x) {
        label = x;
        nbrs = new ArrayList<>();
    }
}
