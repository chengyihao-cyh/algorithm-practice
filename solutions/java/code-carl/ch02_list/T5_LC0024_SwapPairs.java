/**
 * Practice template for:
 * - LeetCode 24. Swap Nodes in Pairs
 *   https://leetcode.cn/problems/swap-nodes-in-pairs/
 */
public class T5_LC0024_SwapPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(-1, head);
        ListNode curr = dummyHead;
        while (curr.next != null && curr.next.next != null) {
            ListNode pre = curr.next;
            ListNode post = curr.next.next;
            pre.next = post.next;
            post.next = pre;
            curr.next = post;
            curr = pre;
        }
        return dummyHead.next;
    }
}
