package org.rereview2024summer.list;

public class T2_removeElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1, head);
        ListNode curr = dummyHead;
        while (curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return dummyHead.next;
    }
}
