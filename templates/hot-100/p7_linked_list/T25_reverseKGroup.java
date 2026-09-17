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
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        ListNode end = dummy;

        while (true) {
            // 分段
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            // 准备
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            // 翻转 sub接入
            pre.next = reverse(start);
            start.next = next;
            // 重置
            pre = start;
            end = pre;
        }
        return dummy.next;
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
