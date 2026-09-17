package org.review2025autumn.ch02_list;

import java.nio.file.Path;

public class T2_removeElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode curr = dummyHead;
        while (curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return dummyHead.next;
    }
}
