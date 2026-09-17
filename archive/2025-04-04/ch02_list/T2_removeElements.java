package org.review2025spring.ch02_list;

public class T2_removeElements {
    public ListNode removeElements(ListNode head, int val) {
        head = new ListNode(-1, head);
        ListNode curr = head;
        while (curr.next != null) {
            if (curr.next.val == val) {
                ListNode del = curr.next;
                curr.next = del.next;
                del.next = null;
            } else {
                curr = curr.next;
            }
        }
        return head.next;
    }
}
