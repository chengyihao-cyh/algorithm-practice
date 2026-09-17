/**
 * Practice template for:
 * - LeetCode 203. Remove Linked List Elements
 *   https://leetcode.cn/problems/remove-linked-list-elements/
 */
import java.nio.file.Path;

public class T2_LC0203_RemoveElements {
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
