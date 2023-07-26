/*
 * @lc app=leetcode.cn id=203 lang=java
 *
 * [203] 移除链表元素
 */

// @lc code=start
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
class Solution {
    public ListNode removeElements(ListNode head, int val) {

        // while(head != null && head.val == val) {
        //     head = head.next;
        // }
        // if (head == null) {
        //     return head;
        // }

        // ListNode flag = head;

        // while(head.next != null) {
        //     if (head.next.val == val) {
        //         head.next = head.next.next;
        //     } else {
        //         head = head.next;
        //     }
        // }

        // return flag;


        // 迭代

        if (head == null) {
            return null;
        }
        head.next = removeElements(head.next, val);
        if (head.val == val) {
            return head.next;
        } else{
            return head;
        }

    }
}
// @lc code=end

