package org.learn2024spring.list.q4_list_remove;

public class Main {
    public static void main(String[] args) {

    }
}


 // Definition for singly-linked list.
 class ListNode {
     int val;
     ListNode next;
     ListNode() {
     }
     ListNode(int val) {
         this.val = val;
     }
     ListNode(int val, ListNode next) {
         this.val = val;
         this.next = next;
     }
 }

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1, head);
        ListNode curr = dummyHead;

        // curr指向被删元素的前驱 当 curr.next != null 停止
        while (curr.next != null){
            if (curr.next.val == val){
                curr.next = curr.next.next;
            } else {
                // 仅当下一个元素不是被删除的元素时才向后移动
                curr = curr.next;
            }
        }
        return dummyHead.next;
    }
}