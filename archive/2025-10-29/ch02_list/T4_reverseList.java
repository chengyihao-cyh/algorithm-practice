package org.review2025autumn.ch02_list;

public class T4_reverseList {
    public ListNode reverseList(ListNode head) {
        ListNode curr = null;
        ListNode post = head;
        while (post != null) {
            ListNode tmp = post.next;
            post.next = curr;
            curr = post;
            post = tmp;
        }
        return curr;
    }
}
