package org.learn2024spring.list.q5_list_design;

public class Main {
    public static void main(String[] args) {
         // Your MyLinkedList object will be instantiated and called as such:
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2);    // 链表变为 1->2->3
        int i1 = myLinkedList.get(1);              // 返回 2
        myLinkedList.deleteAtIndex(1);    // 现在，链表变为 1->3
        int i2 = myLinkedList.get(1);              // 返回 3

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

class MyLinkedList {
    ListNode head;
    int size;

    // 带哑结点
    public MyLinkedList (){
        this.head = new ListNode(-1);
        this.size = 0;
    }

    // get从0开始
    // 注意：下标0的结点是原始头结点 不是虚拟头结点！！ 虚拟头结点认为是-1
    public int get (int idx) {
        // 先判定越界！！
        // 边界：idx >= size 初始时size=0 idx要是为0 找的是第一个元素 不存在
        if (idx < 0 || idx >= size) {
            return -1;
        }

        ListNode curr = this.head;
        // 此时curr指向被get的前驱结点
        for (int i = 0; i < idx; i++){
            curr = curr.next;
        }
        // 因此返回curr.next.val
        return curr.next.val;
    }


    // 如果index大于链表的长度，则返回空
    // 如果index小于0，则在头部插入节点
    public void addAtIndex (int idx, int val){
        // 边界：idx > size 初始时size=0 最多只能在0插入
        if (idx > size){
            return;
        }
        if (idx < 0) {
            idx = 0;
        }

        // 此时curr指向要操作节点的前驱
        // 因此 i < idx
        ListNode curr  = this.head;
        for (int i = 0; i < idx; i++){
            curr = curr.next;
        }
        ListNode newNode = new ListNode(val, curr.next);
        curr.next = newNode;

        // 别忘了维护size的值
        this.size++;
    }

    public void addAtHead (int val) {
        addAtIndex(0, val);
    }

    public void addAtTail (int val) {
        addAtIndex(this.size, val);
    }

    public void deleteAtIndex (int idx) {
        if (idx < 0 || idx >= this.size) {
            return;
        }
        ListNode curr = this.head;
        for (int i = 0; i < idx; i++) {
            curr = curr.next;
        }
        curr.next = curr.next.next;
        // 别忘了维护size的值
        this.size--;
    }


}





































