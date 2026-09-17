/**
 * Practice template for:
 * - 23. Merge k Sorted Lists
 *   https://leetcode.cn/problems/merge-k-sorted-lists/
 */
import java.util.PriorityQueue;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2025/11/8 20:48
 * @comment
 */
public class T23_mergeKLists {
    public ListNode mergeKLists0(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            throw new UnsupportedOperationException("TODO");
        }

        PriorityQueue<ListNode> queue = new PriorityQueue<>((node1, node2) -> node1.val - node2.val);
        for (ListNode list : lists) {
            if (list != null) {
                queue.offer(list);
            }
        }

        ListNode dummyHead = new ListNode(-1);
        ListNode curr = dummyHead;

        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            if (node.next != null) {
                queue.offer(node.next);
            }
            curr.next = node;
            curr = curr.next;
        }

        return dummyHead.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            throw new UnsupportedOperationException("TODO");
        }
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int l, int r) {
        if (r < l) {
            throw new UnsupportedOperationException("TODO");
        } else if (r == l) {
            return lists[l];
        } else if (r == l + 1) {
            return mergeTwoLists(lists[l], lists[r]);
        } else {
            int mid = (l + r) / 2;
            ListNode left = merge(lists, l, mid);
            ListNode right = merge(lists, mid + 1, r);
            return mergeTwoLists(left, right);
        }
    }


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
