package lintCode_alg._9_data_structure_advanced;

import common.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * Merge two sorted (ascending) lists of interval and return it as a new sorted list. The new sorted list should be made by splicing together the intervals of the two lists and sorted in ascending order.
 * <p>
 * The intervals in the given list do not overlap.
 * The intervals in different lists may overlap.
 * Have you met this question in a real interview?
 * Example
 * Given list1 = [(1,2),(3,4)] and list2 = [(2,3),(5,6)], return [(1,4),(5,6)].
 */
public class _839 {
    public List<Interval> mergeTwoInterval(List<Interval> list1, List<Interval> list2) {
        List<Interval> res = new ArrayList<>();

        int i1 = 0;
        int len1 = list1.size();
        int i2 = 0;
        int len2 = list2.size();

        // while the i1, i2 not end.
        while (i1 < len1 || i2 < len2) {
            if (i1 < len1 && i2 < len2) {
                if (list1.get(i1).start < list2.get(i2).start) {
                    merge(res, list1.get(i1++));
                } else {
                    merge(res, list2.get(i2++));
                }
            } else if (i1 < len1) {
                merge(res, list1.get(i1++));
            } else {
                merge(res, list2.get(i2++));
            }
        }

        return res;
    }

    private void merge(List<Interval> res, Interval inter) {
        if (res == null || res.size() == 0) {
            res.add(inter);
        }

        int size = res.size();
        Interval last = res.get(size - 1);

        //last start always less than inter start.
        if (inter.start > last.end) {
            res.add(inter);
        } else if (inter.start <= last.end) {
            last.end = Math.max(inter.end, last.end);
        }
    }
}

