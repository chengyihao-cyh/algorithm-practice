package org.review2025springAgain.ch02_list;

public class T7_getIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode idxA = headA, idxB = headB;
        int lenA = 0, lenB = 0;

        while (idxA != null) {
            idxA = idxA.next;
            lenA++;
        }
        while (idxB != null) {
            idxB = idxB.next;
            lenB++;
        }
        if (lenB > lenA) {
            ListNode tmp = headA;
            headA = headB;
            headB = tmp;
        }
        idxA = headA;
        idxB = headB;
        for (int i = 0; i < Math.abs(lenA - lenB); i++) {
            idxA = idxA.next;
        }
        while (idxA != null) {
            if (idxA == idxB)
                return idxA;
            idxA = idxA.next;
            idxB = idxB.next;
        }
        return null;
    }
}
