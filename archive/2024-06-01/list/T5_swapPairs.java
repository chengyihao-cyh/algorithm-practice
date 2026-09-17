package org.review2024summer.list;

public class T5_swapPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(-1, head);
        ListNode curr = dummyHead;
        while (curr.next != null && curr.next.next != null) {
            ListNode pre = curr.next;
            ListNode mid = curr.next.next;
            ListNode post = curr.next.next.next;
            curr.next = mid;
            mid.next = pre;
            pre.next = post;
            curr = pre;
        }
        return dummyHead.next;
    }
}
