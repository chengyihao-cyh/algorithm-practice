/**
 * Practice template for:
 * - 21. Merge Two Sorted Lists
 *   https://leetcode.cn/problems/merge-two-sorted-lists/
 */
/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2025/11/06 17:56
 * @comment
 */
public class T21_mergeTwoLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode(-1, null);
        ListNode curr = dummyHead;
        ListNode l1 = list1, l2 = list2;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                // l1节点加入
                curr.next = l1;
                l1 = l1.next;
            } else {
                // l2节点加入
                curr.next = l2;
                l2 = l2.next;
            }
            // 结果链表新增元素 curr前移
            curr = curr.next;
        }

        if (l1 == null) {
            curr.next = l2;
        } else {
            curr.next = l1;
        }

        return dummyHead.next;
    }

}
