package org.learn2024spring.list.q10_list_circle;

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

class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast!= null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode idx1 = fast;
                ListNode idx2 = head;
                while (idx1 != idx2) {
                    idx1 = idx1.next;
                    idx2 = idx2.next;
                }
                return idx1;
            }
        }
        return null;
    }
}
