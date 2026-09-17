package org.learn2024spring.list.q7_list_exchange;

public class Main {
    public static void main(String[] args) {

    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

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

// 多指针记录
class Solution1 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(-1, head);
        ListNode curr = dummyHead;
        while (curr.next != null && curr.next.next != null){
            ListNode pre = curr.next;
            ListNode mid = curr.next.next;
            ListNode post = curr.next.next.next;
            curr.next = mid;
            mid.next = pre;
            pre.next = post;
            curr = pre;
        }
        return dummyHead.next;
    }
}

