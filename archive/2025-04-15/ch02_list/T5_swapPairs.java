package org.review2025springAgain.ch02_list;

public class T5_swapPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        ListNode pre, mid, post;
        ListNode curr = dummy;
        while (curr.next != null && curr.next.next != null) {
            post = curr.next;
            mid = curr.next.next;
            pre = curr.next.next.next;
            curr.next = mid;
            mid.next = post;
            post.next = pre;
            curr = post;
        }
        return dummy.next;
    }
}
