package org.review2025springAgain.ch02_list;

public class T6_removeNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode curr = dummy, pre = dummy;
        while (n-- > 0) {
            pre = pre.next;
        }
        while (pre.next != null) {
            pre = pre.next;
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return dummy.next;
    }
}
