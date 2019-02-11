package leetcode_contest.contest122;

import common.NodeClass.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.
 * <p>
 * Return the intersection of these two interval lists.
 * <p>
 * (Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.  The intersection of two closed intervals is a set of real numbers that is either empty, or can be represented as a closed interval.  For example, the intersection of [1, 3] and [2, 4] is [2, 3].)
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
 * Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
 * Reminder: The inputs and the desired output are lists of Interval objects, and not arrays or lists.
 * <p>
 * <p>
 * Note:
 * <p>
 * 0 <= A.length < 1000
 * 0 <= B.length < 1000
 * 0 <= A[i].start, A[i].end, B[i].start, B[i].end < 10^9
 */
public class _986 {
    public Interval[] intervalIntersection(Interval[] A, Interval[] B) {
        if (A == null || B == null || A.length == 0 || B.length == 0) {
            return new Interval[0];
        }

        int left = 0;
        int right = 0;
        int lenA = A.length;
        int lenB = B.length;
        List<Interval> res = new ArrayList<>();

        while (left < lenA && right < lenB) {
            Interval leftInter = A[left];
            Interval rightInter = B[right];

            Interval intersec = findInter(leftInter, rightInter);
            if (intersec != null) {
                res.add(intersec);
            }

            if (leftInter.end > rightInter.end) {
                right++;
            } else {
                left++;
            }
        }

        Interval[] resArray = new Interval[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resArray[i] = res.get(i);
        }

        return resArray;
    }

    private Interval findInter(Interval l, Interval r) {
        int left = Math.max(l.start, r.start);
        int right = Math.min(l.end, r.end);

        if (left > right) {
            return null;
        } else {
            return new Interval(left, right);
        }
    }
}
