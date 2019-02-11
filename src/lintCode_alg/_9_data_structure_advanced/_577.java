package lintCode_alg._9_data_structure_advanced;

import common.NodeClass.Interval;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Merge K sorted interval lists into one sorted interval list. You need to merge overlapping intervals too.
 * <p>
 * Have you met this question in a real interview?
 * Example
 * Given
 * <p>
 * [
 * [(1,3),(4,7),(6,8)],
 * [(1,2),(9,10)]
 * ]
 * Return
 * <p>
 * [(1,3),(4,8),(9,10)]
 */
public class _577 {
    private List<Interval> mergeTwoInterval(List<Interval> list1, List<Interval> list2) {
        // write your code here
        if (list1 == null || list1.isEmpty()) {
            return list2;
        }

        if (list2 == null || list2.isEmpty()) {
            return list1;
        }

        List<Interval> merge = new ArrayList<>();
        Interval last = null;

        int i = 0, j = 0;
        while (i < list1.size() && j < list2.size()) {
            Interval cur;
            if (list1.get(i).start <= list2.get(j).start) {
                cur = list1.get(i);
                i++;
            } else {
                cur = list2.get(j);
                j++;
            }

            if (last == null || last.end < cur.start) {
                merge.add(cur);
                last = cur;
            } else {
                last.end = Math.max(last.end, cur.end);
            }
        }

        while (i < list1.size()) {
            Interval cur = list1.get(i);
            i++;

            if (last == null || last.end < cur.start) {
                merge.add(cur);
                last = cur;
            } else {
                last.end = Math.max(last.end, cur.end);
            }
        }

        while (j < list2.size()) {
            Interval cur = list2.get(j);
            j++;

            if (last == null || last.end < cur.start) {
                merge.add(cur);
                last = cur;
            } else {
                last.end = Math.max(last.end, cur.end);
            }
        }

        return merge;
    }

    class Element implements Comparable<Element> {
        int i, j;
        Interval interval;

        Element(int i, int j, Interval interval) {
            this.i = i;
            this.j = j;
            this.interval = interval;
        }

        @Override
        public int compareTo(Element o) {
            return this.interval.start - o.interval.start;
        }
    }

    public class Sol_minHeap {
        public List<Interval> mergeKSortedIntervalLists(List<List<Interval>> intervals) {
            if (intervals == null || intervals.isEmpty()) {
                return new ArrayList<>();
            }

            // return mergeHelper_v1_minHeap(intervals);
            // return mergeHelper_v2_Divide_Conquer(intervals, 0, intervals.size() - 1);
            return mergeHelper_v1_minHeap(intervals);
        }

        private List<Interval> mergeHelper_v1_minHeap(List<List<Interval>> intervals) {
            PriorityQueue<Element> minHeap = new PriorityQueue<>();
            for (int i = 0; i < intervals.size(); i++) {
                List<Interval> list = intervals.get(i);
                if (list != null && !list.isEmpty()) {
                    minHeap.offer(new Element(i, 0, list.get(0)));
                }
            }

            List<Interval> merge = new ArrayList<>();
            Interval last = null;

            while (!minHeap.isEmpty()) {
                Element cur = minHeap.poll();
                if (last == null || last.end < cur.interval.start) {
                    merge.add(cur.interval);
                    last = cur.interval;
                } else {
                    last.end = Math.max(last.end, cur.interval.end);
                }

                if (cur.j + 1 < intervals.get(cur.i).size()) {
                    cur.j++;
                    cur.interval = intervals.get(cur.i).get(cur.j);
                    minHeap.offer(cur);
                }
            }

            return merge;
        }
    }

    public class Sol_Divide_Conquer {
        public List<Interval> mergeKSortedIntervalLists(List<List<Interval>> intervals) {
            if (intervals == null || intervals.isEmpty()) {
                return new ArrayList<>();
            }

            // return mergeHelper_v1_minHeap(intervals);
            // return mergeHelper_v2_Divide_Conquer(intervals, 0, intervals.size() - 1);
            return mergeHelper_v2_Divide_Conquer(intervals, 0, intervals.size() - 1);
        }

        private List<Interval> mergeHelper_v2_Divide_Conquer(List<List<Interval>> intervals, int low, int high) {
            if (low >= high) {
                return intervals.get(low);
            }

            int mid = low + (high - low) / 2;
            List<Interval> left = mergeHelper_v2_Divide_Conquer(intervals, low, mid);
            List<Interval> right = mergeHelper_v2_Divide_Conquer(intervals, mid + 1, high);
            return mergeTwoInterval(left, right);
        }
    }

    public class Sol_Non_Recursive {
        public List<Interval> mergeKSortedIntervalLists(List<List<Interval>> intervals) {
            if (intervals == null || intervals.isEmpty()) {
                return new ArrayList<>();
            }

            // return mergeHelper_v1_minHeap(intervals);
            // return mergeHelper_v2_Divide_Conquer(intervals, 0, intervals.size() - 1);
            return mergeHelper_v3_Non_Recursive(intervals);
        }

        private List<Interval> mergeHelper_v3_Non_Recursive(List<List<Interval>> intervals) {
            while (intervals.size() > 1) {
                List<List<Interval>> tmp = new ArrayList<>();
                for (int i = 0; i < intervals.size() && i + 1 < intervals.size(); i += 2) {
                    List<Interval> merge = mergeTwoInterval(intervals.get(i), intervals.get(i + 1));
                    tmp.add(merge);
                }

                if (intervals.size() % 2 == 1) {
                    tmp.add(intervals.get(intervals.size() - 1));
                }

                intervals = tmp;
            }
            return intervals.get(0);
        }
    }
}
