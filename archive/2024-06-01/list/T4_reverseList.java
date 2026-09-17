package org.review2024summer.list;

public class T4_reverseList {
    public ListNode reverseList(ListNode head) {
        ListNode dummyHead = null;
        ListNode curr = dummyHead;
        ListNode pre = head;

        while (pre != null) {
            ListNode post = pre.next;
            pre.next  = curr;
            curr = pre;
            pre = post;
        }

        return curr;
    }
}
