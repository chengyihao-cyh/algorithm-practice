package org.review2025springAgain.ch02_list;

public class T4_reverseList {
    public ListNode reverseList(ListNode head) {
        ListNode curr = null;
        ListNode pre = head;
        ListNode post;
        while (pre != null) {
            post = pre.next;
            pre.next = curr;
            curr = pre;
            pre = post;
        }
        return curr;
    }
}