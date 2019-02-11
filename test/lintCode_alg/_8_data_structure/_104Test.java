package lintCode_alg._8_data_structure;

import common.NodeClass.ListNode;
import lintCode_alg._8_data_structure._104.Sol1_DivideConquer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class _104Test {
    List<ListNode> res = new ArrayList<>();
    ListNode expected = new ListNode(-1);

    @BeforeEach
    void setUp() {
        ListNode n1 = new ListNode(2);
        n1.next = new ListNode(4);
        ListNode n2 = null;
        ListNode n3 = new ListNode(-1);

        res.add(n1);
        res.add(n2);
        res.add(n3);

        expected.next = n1;
    }

    @Test
    void sol1_divideConquer() {
        Sol1_DivideConquer sol1_divideConquer = new Sol1_DivideConquer();
        assertEquals(expected.printList(), sol1_divideConquer.mergeKLists(res).printList());
    }
}