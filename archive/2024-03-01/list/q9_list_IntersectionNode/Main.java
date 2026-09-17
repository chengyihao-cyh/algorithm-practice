package org.learn2024spring.list.q9_list_IntersectionNode;

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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int lenA = 0, lenB = 0;
        ListNode currA = headA, currB = headB;
        while (currA != null) {
            lenA++;
            currA = currA.next;
        }
        while (currB != null) {
            lenB++;
            currB = currB.next;
        }
        currA = headA;
        currB = headB;

//        if (lenA > lenB) {
//            for (int i = 0; i < lenA - lenB; i++)
//                currA = currA.next;
//        } else {
//            for (int i = 0; i < lenB - lenA; i++)
//                currB = currB.next;
//        }

        // 相比于用if判断哪个长，移动哪个，不如先判断AB哪个长，选择较长的那个作为A。只需在A较短时swap AB的长度和头结点
        if (lenA < lenB) {
            int tmp = lenA;
            lenA = lenB;
            lenB = tmp;
            ListNode tmpNode = currA;
            currA = currB;
            currB = tmpNode;
        }

        int gap = lenA - lenB;

        while (gap-- > 0){
            currA = currA.next;
        }

        while (currA != null && currB != null) {
            if (currA == currB)
                return currA;
            currA = currA.next;
            currB = currB.next;
        }

        return null;
    }
}
