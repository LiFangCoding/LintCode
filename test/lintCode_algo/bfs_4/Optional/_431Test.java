package lintCode_algo.bfs_4.Optional;

import common.UndirectedGraphNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class _431Test {
    _431 sol;
    @BeforeEach
    void setUp() {
        sol = new _431();
    }

    @Test
    void connectedSet() {
        UndirectedGraphNode A = new UndirectedGraphNode(1);
        UndirectedGraphNode B = new UndirectedGraphNode(2);
        UndirectedGraphNode C = new UndirectedGraphNode(3);
        UndirectedGraphNode D = new UndirectedGraphNode(4);
        UndirectedGraphNode E = new UndirectedGraphNode(5);
        List<UndirectedGraphNode> nodes = new ArrayList<>(Arrays.asList(A, B, C, D, E));

        A.neighbors.add(B);
        A.neighbors.add(D);
        B.neighbors.add(D);
        B.neighbors.add(A);
        D.neighbors.add(A);
        D.neighbors.add(B);

        C.neighbors.add(E);
        E.neighbors.add(C);

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> comp1 = new ArrayList<>();
        comp1.add(1);
        comp1.add(2);
        comp1.add(4);

        List<Integer> comp2 = new ArrayList<>();
        comp2.add(3);
        comp2.add(5);
        res.add(comp1);
        res.add(comp2);

        assertEquals(res, sol.connectedSet(nodes));
    }

    @Test
    void sort() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(5);

        Collections.sort(list);
        System.out.println(list);
    }
}