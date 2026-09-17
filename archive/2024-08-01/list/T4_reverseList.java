package org.rereview2024summer.list;

public class T4_reverseList {
    public ListNode reverseList(ListNode head) {
        ListNode curr = null;
        ListNode pre = head;

        while (pre != null) {
            ListNode post = pre.next;
            pre.next = curr;
            curr = pre;
            pre = post;
        }

        return curr;
    }
}
