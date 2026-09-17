package org.review2025autumn.ch02_list;

public class T8_detectCycle {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode idx1 = head, idx2 = slow;
                while (idx1 != idx2) {
                    idx1 = idx1.next;
                    idx2 = idx2.next;
                }
                return idx1;
            }
        }
        return null;
    }
}
