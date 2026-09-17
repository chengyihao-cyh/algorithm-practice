/**
 * Practice template for:
 * - 2. Add Two Numbers
 *   https://leetcode.cn/problems/add-two-numbers/
 */
/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2025/11/7 16:54
 * @comment
 */
public class T2_addTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead1 = new ListNode(-1, l1);
        ListNode dummyHead2 = new ListNode(-1, l2);
        ListNode curr1 = dummyHead1, curr2 = dummyHead2;
        int carry = 0;  // 进位数

        // 长度相等序列相加
        while (curr1.next != null && curr2.next != null) {
            int currSum = curr1.next.val + curr2.next.val + carry;
            curr1.next.val = currSum % 10;
            carry = currSum / 10;
            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        // 错开了 保持curr1拿到多的那段较长
        if (curr1.next == null) {
            curr1.next = curr2.next;
        }

        // 还有进位数字
        while (curr1.next != null && carry != 0) {
            int currSum = curr1.next.val + carry;
            curr1.next.val = currSum % 10;
            carry = currSum / 10;
            curr1 = curr1.next;
        }
        // 进位到最后的节点（最高位）了 必须得创建新节点了
        if (carry != 0) {
            curr1.next = new ListNode(carry);
        }

        return dummyHead1.next;
    }

}
