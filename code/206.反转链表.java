/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

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
    public ListNode reverseList(ListNode head) {
        ListNode right = head;
        ListNode left = null;
        ListNode temp = null;

        while(right != null) {
            temp = right;
            right = right.next;
            temp.next = left;
            left = temp;
        }

        return left;
    }
}
// @lc code=end

