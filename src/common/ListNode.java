package common;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public String printList() {
        StringBuilder s = new StringBuilder();
        ListNode cur = this;
        while (cur != null) {
            s.append(cur.val);
            cur = cur.next;
        }
        return s.toString();
    }
}
