/*
 * @lc app=leetcode.cn id=707 lang=java
 *
 * [707] 设计链表
 */

// @lc code=start

import java.nio.channels.NonWritableChannelException;
import java.time.temporal.Temporal;

class MyLinkedList {

    int size;

    ListNode listNode;

    // MyLinkedList() 初始化 MyLinkedList 对象。
    public MyLinkedList() {
        size = -1;
        listNode = new ListNode(0);

    }

    // int get(int index) 获取链表中下标为 index 的节点的值。如果下标无效，则返回 -1 。
    public int get(int index) {
        if (index < 0 || index > size) {
            return  -1;
        }
        ListNode tempNode = listNode;

        while (index > 0) {
            tempNode = tempNode.next;
            index--;
        }

        return tempNode.next.val;
    }

    //void addAtHead(int val) 将一个值为 val 的节点插入到链表中第一个元素之前。在插入完成后，新节点会成为链表的第一个节点。
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    // void addAtTail(int val) 将一个值为 val 的节点追加到链表中作为链表的最后一个元素。
    public void addAtTail(int val) {
        addAtIndex(size + 1, val);
    }

    // void addAtIndex(int index, int val) 将一个值为 val 的节点插入到链表中下标为 index 的节点之前。如果 index 等于链表的长度，那么该节点会被追加到链表的末尾。如果 index 比长度更大，该节点将 不会插入 到链表中。
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > (size + 1)) {
            return;
        }
        ListNode tempNode = listNode;

        while (index > 0) {
            tempNode= tempNode.next;
            index--;
        }

        ListNode addNode = new ListNode(val);

        addNode.next = tempNode.next;
        tempNode.next = addNode;

        this.size++;
    }

    // void deleteAtIndex(int index) 如果下标有效，则删除链表中下标为 index 的节点。
    public void deleteAtIndex(int index) {
        if (index < 0 || index > size) {
            return;
        }
        ListNode tempNode = listNode;

        while (index > 0) {
            tempNode = tempNode.next;
            index--;
        }
        tempNode.next = tempNode.next.next;
        this.size--;
    }

}

//class ListNode {
//
//    int val;
//    ListNode next;
//    ListNode() {}
//    ListNode(int val) { this.val = val; }
//    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//}


/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
// @lc code=end

