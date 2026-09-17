/**
 * Practice template for:
 * - LeetCode 142. Linked List Cycle II
 *   https://leetcode.cn/problems/linked-list-cycle-ii/
 */
public class T8_LC0142_DetectCycle {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode idx1 = head, idx2 = slow;
                while (idx1 != idx2) {
                    idx1 = idx1.next;
                    idx2 = idx2.next;
                }
                return idx1;
            }
        }
        return null;
    }
}
