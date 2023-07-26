/*
 * @lc app=leetcode.cn id=24 lang=java
 *
 * [24] 两两交换链表中的节点
 */

// @lc code=start

import javax.xml.transform.Templates;

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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode right = head.next;
        ListNode left = head;
        ListNode rightTemp = null;
        ListNode leftTemp = null;

        head = head.next;

        while (right != null && left != null) {
            rightTemp = right.next;

            right.next = left;
            left.next = rightTemp;
            
            if (leftTemp != null) {
                leftTemp.next = right;
            }

            leftTemp = left;
            left = rightTemp;

            if (left != null) {
                right = left.next;
            }
        }
        
        return head;
    }
}
// @lc code=end

