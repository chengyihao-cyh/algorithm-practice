/**
 * Practice template for:
 * - LeetCode 206. Reverse Linked List
 *   https://leetcode.cn/problems/reverse-linked-list/
 */
public class T4_LC0206_ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode curr = null;
        ListNode post = head;
        while (post != null) {
            ListNode tmp = post.next;
            post.next = curr;
            curr = post;
            post = tmp;
        }
        return curr;
    }
}
