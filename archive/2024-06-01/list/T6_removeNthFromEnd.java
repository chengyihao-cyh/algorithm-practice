package org.review2024summer.list;

public class T6_removeNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(-1, head);
        ListNode slow = dummyHead;
        ListNode fast = dummyHead;
        while (n-- > 0) {
            fast = fast.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummyHead.next;
    }
}
