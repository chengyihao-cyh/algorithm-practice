package org.review2024summer.list;

public class T8_detectCycle {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode idx1 = head;
                ListNode idx2 = fast;
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
