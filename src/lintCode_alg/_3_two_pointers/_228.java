package lintCode_alg._3_two_pointers;

import common.ListNode;

/**
 * Find the middle node of a linked list.
 * <p>
 * Example
 * Example 1:
 * Input:  1->2->3
 * Output: 2
 * <p>
 * Explanation:
 * return the value of the middle node.
 * <p>
 * Example 2:
 * Input:  1->2
 * Output: 1
 * <p>
 * Explanation:
 * If the length of list is  even return the value of center left one.
 * Challenge
 * If the linked list is in a data stream, can you find the middle without iterating the linked list again?
 */
public class _228 {
    // 1 -> 2 -> 3.  2.
    // 1 -> 2.  1
    // T: O(n)
    public ListNode middleNode(ListNode head) {
        // write your code here
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode slow = dummy, fast = dummy;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}
