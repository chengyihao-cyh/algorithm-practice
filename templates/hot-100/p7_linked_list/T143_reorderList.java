/**
 * Practice template for:
 * - 143. Reorder List
 *   https://leetcode.cn/problems/reorder-list/
 */
public class T143_reorderList {

    public void reorderList(ListNode head) {
        if (head.next == null) {
            return;
        }
        ListNode mid = getMid(head);
        ListNode head2 = reverse(mid);
        head = merge(head, head2);
    }

    public ListNode getMid(ListNode head) {
        ListNode slow = head, fast = head, pre = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // pre 负责将 mid 与前一个节点断开联系
        // 例如 1->2->3 =>
        // 1->null && 2->3->null
        pre.next = null;
        return slow;
    }

    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode post = curr.next;
            curr.next = pre;
            pre = curr;
            curr = post;
        }
        return pre;
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode curr = dummyHead;
        ListNode idx1 = head1;
        ListNode idx2 = head2;
        while (idx1 != null) {
            curr.next = idx1;
            idx1 = idx1.next;
            curr = curr.next;
            curr.next = idx2;
            idx2 = idx2.next;
            curr = curr.next;
        }
        return dummyHead.next;
    }

    class MT {
        public void reorderList(ListNode head) {
            ListNode dummyHead = new ListNode(-1, head);
            ListNode curr = dummyHead;
            int len = 0;
            while (curr.next != null) {
                len++;
                curr = curr.next;
            }
            int gap = len / 2;
            ListNode left = dummyHead, right = dummyHead;
            while (gap-- > 0) {
                right = right.next;
            }

            right.next = reverse(right.next);
            left = dummyHead.next;
            while (right.next != null) {
                ListNode delNode = delNode(right);
                insertNode(left, delNode);
                left = left.next.next;
            }


            head = dummyHead.next;
        }

        public ListNode reverse(ListNode head) {
            ListNode pre = null;
            ListNode curr = head;
            while (curr != null) {
                ListNode next = curr.next;
                curr.next = pre;
                pre = curr;
                curr = next;
            }
            return pre;
        }

        public ListNode delNode(ListNode curr) {
            ListNode delNode = curr.next;
            curr.next = curr.next.next;
            delNode.next = null;
            return delNode;
        }

        public ListNode insertNode(ListNode curr, ListNode node) {
            ListNode post = curr.next;
            curr.next = node;
            node.next = post;
            return node;
        }
    }


}
