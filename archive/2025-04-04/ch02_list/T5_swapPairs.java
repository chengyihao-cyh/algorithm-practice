package org.review2025spring.ch02_list;

public class T5_swapPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        ListNode curr = dummy;
        ListNode pre, mid, post;
        while (curr.next != null && curr.next.next != null) {
            pre = curr.next;
            mid = pre.next;
            post = mid.next;
            curr.next = mid;
            mid.next = pre;
            pre.next = post;
            curr = pre;
        }
        return dummy.next;
    }
}
