//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。 
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
// 
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
//
// Related Topics 递归 链表 数学 👍 10597 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode();
        ListNode ans_temp = ans;
        boolean flag = false;
        int temp = 0;
        int temp_l1 = 0;
        int temp_l2 = 0;

        while (l1 != null || l2 != null) {
            if (l1 != null) {
                temp_l1 = l1.val;
                l1 = l1.next;
            } else temp_l1 = 0;

            if (l2 != null) {
                temp_l2 = l2.val;
                l2 = l2.next;
            } else temp_l2 = 0;


            if (flag) {
                temp = temp_l1 + temp_l2 + 1;
            } else {
                temp = temp_l1 + temp_l2;
            }

            if (temp > 9) {flag = true;}
            else {flag = false;}

            ans_temp.next = new ListNode(temp % 10);

            ans_temp = ans_temp.next;
        }
        if (flag) {ans_temp.next = new ListNode(1);}
        return ans.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
