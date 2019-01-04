package common;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public String printList() {
        String s = "";
        ListNode cur = this;
        while (cur != null) {
            s += cur.val;
            cur = cur.next;
        }
        return s;
    }
}
