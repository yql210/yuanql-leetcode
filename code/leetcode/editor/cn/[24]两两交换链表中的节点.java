//给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
// 
//
// 示例 2： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 100] 内 
// 0 <= Node.val <= 100 
// 
//
// Related Topics 递归 链表 👍 1880 👎 0


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
    public ListNode swapPairs(ListNode head) {
        ListNode headNode = new ListNode();
        headNode.next = head;

        ListNode left = head, // 此处用于指向交换两节点的左节点
                right = null; // 此处用于指向交换两节点的右节点，
                            // 为什么赋值为null，而不是 left.next ： 不确定left是否为null，如果left为null，取left.next将会报空指针错误
        ListNode start = headNode,  // 此处为指向左节点的前一个节点
                end = null; // 此处为被右节点指向的后一个节点

        while (left != null && left.next != null) {
            right = left.next;
            end = right.next;

            start.next = right;
            right.next = left;
            left.next = end;

            start = left;
            left = end;
        }

        return headNode.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
