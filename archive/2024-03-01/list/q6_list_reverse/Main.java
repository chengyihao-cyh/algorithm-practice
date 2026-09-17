package org.learn2024spring.list.q6_list_reverse;

public class Main {
    public static void main(String[] args) {

    }
}

class ListNode {
    int val;
    ListNode next;
    public ListNode (){
    }
    public ListNode (ListNode next){
        this.next = next;
    }
    public ListNode (int val){
        this.val = val;
    }
    public ListNode (int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}

// 双指针
class Solution1 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = head;
        ListNode curr = head.next;
        // 先移动pre到curr 再移动curr到tmp
        while (curr != null) {
            ListNode tmp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = tmp;
        }
        return pre;
    }
}

// 递归法
class Solution2 {
    public ListNode reverseList(ListNode head) {
        return reverse(head, null);
    }

    public ListNode reverse(ListNode curr, ListNode pre) {
        if (curr == null){
            return pre;
        }
        ListNode tmp = curr.next;
        curr.next = pre;
        return reverse(tmp, curr);
    }
}