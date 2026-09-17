package org.review2025spring.ch02_list;

public class T7_getIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ptrA = headA;
        ListNode ptrB = headB;
        int lenA = 0, lenB = 0;
        while (ptrA != null) {
            lenA++;
            ptrA = ptrA.next;
        }
        while (ptrB != null) {
            lenB++;
            ptrB = ptrB.next;
        }
        if (lenB > lenA) {
            ListNode tmp = new ListNode();
            tmp = headA;
            headA = headB;
            headB = tmp;
        }
        ptrA = headA;
        ptrB = headB;
        int gap = Math.abs(lenA - lenB);
        while (gap-- > 0) {
            ptrA = ptrA.next;
        }
        while (ptrA != null) {
            if (ptrA == ptrB)
                return ptrA;
            ptrA = ptrA.next;
            ptrB = ptrB.next;
        }
        return null;
    }
}
