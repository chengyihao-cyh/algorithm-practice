package org.rereview2024summer.list;

public class T7_getIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode currA = headA;
        ListNode currB = headB;
        int lenA = 0, lenB = 0;

        while (currA != null) {
            currA = currA.next;
            lenA++;
        }
        while (currB != null) {
            currB = currB.next;
            lenB++;
        }

        currA = headA;
        currB = headB;
        if (lenB > lenA) {
            int tmp = lenA;
            lenA = lenB;
            lenB = tmp;
            currA = headB;
            currB = headA;
        }

        int gap = lenA - lenB;
        while (gap-- > 0) {
            currA = currA.next;
        }
        while (currA != null && currB != null) {
            if (currA == currB)
                return currA;
            currA = currA.next;
            currB = currB.next;
        }

        return null;
    }
}
