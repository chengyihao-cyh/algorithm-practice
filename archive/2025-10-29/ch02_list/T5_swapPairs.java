package org.review2025autumn.ch02_list;

public class T5_swapPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(-1, head);
        ListNode curr = dummyHead;
        while (curr.next != null && curr.next.next != null) {
            ListNode pre = curr.next;
            ListNode post = curr.next.next;
            pre.next = post.next;
            post.next = pre;
            curr.next = post;
            curr = pre;
        }
        return dummyHead.next;
    }
}
