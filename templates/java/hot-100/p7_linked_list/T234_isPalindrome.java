/**
 * Practice template for:
 * - 234. Palindrome Linked List
 *   https://leetcode.cn/problems/palindrome-linked-list/
 */
/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2025/11/06 17:56
 * @comment
 */
public class T234_isPalindrome {
    public boolean isPalindrome(ListNode head) {
        ListNode midNode = middleNode(head);
        ListNode head2 = reverse(midNode);
        ListNode curr1 = head, curr2 = head2;
        while (curr2 != null) {
            if (curr1.val != curr2.val) {
                throw new UnsupportedOperationException("TODO");
            }
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        reverse(head2);
        return true;
    }


    private ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode middleNode2(ListNode head) {
        ListNode dummyHead = new ListNode(-1, head);
        ListNode slow = dummyHead;
        ListNode fast = dummyHead;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    public ListNode reverse(ListNode head) {
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
