/**
 * Practice template for:
 * - LeetCode 19. Remove Nth Node From End of List
 *   https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
 */
public class T6_LC0019_RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(-1, head);
        ListNode slow = dummyHead, fast = dummyHead;
        while (n-- > 0) {
            fast = fast.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummyHead.next;
    }
}
