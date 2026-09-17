/**
 * Practice template for:
 * - LeetCode 160. Intersection of Two Linked Lists
 *   https://leetcode.cn/problems/intersection-of-two-linked-lists/
 */
public class T7_LC0160_GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;
        ListNode ptrA = headA, ptrB = headB;

        while (ptrA != null) {
            lenA++;
            ptrA = ptrA.next;
        }
        ptrA = headA;

        while (ptrB != null) {
            lenB++;
            ptrB = ptrB.next;
        }
        ptrB = headB;

        if (lenB > lenA) {
            int tmp = lenB;
            lenB = lenA;
            lenA = tmp;
            ListNode tmpN = ptrB;
            ptrB = ptrA;
            ptrA = tmpN;
        }

        int gap = lenA - lenB;
        while (gap-- > 0) {
            ptrA = ptrA.next;
        }

        while (ptrA != null && ptrB != null) {
            if (ptrA == ptrB) {
                return ptrA;
            }
            ptrA = ptrA.next;
            ptrB = ptrB.next;
        }
        return null;
    }
}
