package lintCode_alg._9_data_structure_advanced;

import common.NodeClass.Interval;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class _839_Test {
    _839 sol = new _839();

    @Test
    void mergeTwoInterval() {
        List<Interval> list1 = new ArrayList<>();
        list1.add(new Interval(1, 2));
        list1.add(new Interval(3, 4));

        List<Interval> list2 = new ArrayList<>();
        list2.add(new Interval(2, 3));
        list2.add(new Interval(5, 6));

        System.out.println(sol.mergeTwoInterval(list1, list2));
    }
}