package org.learn2024spring.list.q8_list_remove_n;

public class Main {
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

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(-1, head);
        ListNode slow = dummyHead;
        ListNode fast = dummyHead;
        // fast先走n步
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        // fast和slow一起向前
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummyHead.next;
    }
}