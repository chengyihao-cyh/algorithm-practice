/**
 * Practice template for:
 * - 25. Reverse Nodes in k-Group
 *   https://leetcode.cn/problems/reverse-nodes-in-k-group/
 */
/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2025/11/06 17:56
 * @comment
 */
public class T25_reverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead = new ListNode(-1, head);
        ListNode pre = dummyHead, end = dummyHead;
        while (true) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }

            ListNode oldHead = pre.next;
            ListNode next = end.next;
            end.next = null;

            pre.next = reverse(oldHead);
            oldHead.next = next;

            pre = oldHead;
            end = oldHead;
        }
        return dummyHead.next;
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
