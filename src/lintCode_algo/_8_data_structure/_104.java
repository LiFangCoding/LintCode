package lintCode_algo._8_data_structure;

import common.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Merge k sorted linked lists and return it as one sorted list.
 * <p>
 * Analyze and describe its complexity.
 * <p>
 * Have you met this question in a real interview?
 * Example
 * Given lists:
 * <p>
 * [
 * 2->4->null,
 * null,
 * -1->null
 * ],
 * return -1->2->4->null.
 */
public class _104 {
    //Time: O(l*n*logn)
    public static class Sol1_DivideConquer {
        public ListNode mergeKLists(List<ListNode> lists) {
            // write your code here
            if (lists == null || lists.size() == 0) {
                return null;
            }
            int end = lists.size() - 1;
            return mergeK(lists, 0, end);
        }

        private ListNode mergeK(List<ListNode> lists, int start, int end) {
            if (start == end) {
                return lists.get(start);
            }

            if (start > end) {
                return null;
            }

            int mid = start + (end - start) / 2;
            ListNode left = mergeK(lists, start, mid);
            ListNode right = mergeK(lists, mid + 1, end);

            return merge2(left, right);
        }

        private ListNode merge2(ListNode n1, ListNode n2) {
            ListNode dummy = new ListNode(0);
            ListNode cur = dummy;

            while (n1 != null || n2 != null) {
                if (n1 != null && n2 != null) {
                    if (n1.val < n2.val) {
                        cur.next = n1;
                        n1 = n1.next;
                    } else {
                        cur.next = n2;
                        n2 = n2.next;
                    }
                    cur = cur.next;
                } else if (n1 != null) {
                    cur.next = n1;
                    break;
                } else {
                    cur.next = n2;
                    break;
                }
            }

            return dummy.next;
        }
    }

    public static class sol2_Heap {
        public ListNode mergeKLists(List<ListNode> lists) {
            // write your code here
            if (lists == null || lists.size() == 0) {
                return null;
            }

            Queue<ListNode> pq = new PriorityQueue<>(lists.size(), (a, b) -> a.val - b.val);

            for (ListNode node : lists) {
                // node will not be null.
                if (node != null) {
                    pq.add(node);
                }
            }

            ListNode dummy = new ListNode(0);
            ListNode cur = dummy;

            while (!pq.isEmpty()) {
                ListNode node = pq.remove();
                if (node.next != null) {
                    pq.add(node.next);
                    node.next = null;
                }

                cur.next = node;
                cur = cur.next;
            }

            return dummy.next;
        }
    }

    public static class sol3_merge2by2 {
        public ListNode mergeKLists(List<ListNode> lists) {
            if (lists == null || lists.size() == 0) {
                return null;
            }

            while (lists.size() > 1) {
                List<ListNode> new_lists = new ArrayList<ListNode>();
                for (int i = 0; i + 1 < lists.size(); i += 2) {
                    ListNode merged_list = merge2(lists.get(i), lists.get(i + 1));
                    new_lists.add(merged_list);
                }
                if (lists.size() % 2 == 1) {
                    new_lists.add(lists.get(lists.size() - 1));
                }
                lists = new_lists;
            }

            return lists.get(0);
        }

        private ListNode merge2(ListNode n1, ListNode n2) {
            ListNode dummy = new ListNode(0);
            ListNode cur = dummy;

            while (n1 != null || n2 != null) {
                if (n1 != null && n2 != null) {
                    if (n1.val < n2.val) {
                        cur.next = n1;
                        n1 = n1.next;
                    } else {
                        cur.next = n2;
                        n2 = n2.next;
                    }
                    cur = cur.next;
                } else if (n1 != null) {
                    cur.next = n1;
                    break;
                } else {
                    cur.next = n2;
                    break;
                }
            }

            return dummy.next;
        }
    }

}
