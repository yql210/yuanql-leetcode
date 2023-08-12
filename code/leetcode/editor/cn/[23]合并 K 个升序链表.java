//给你一个链表数组，每个链表都已经按升序排列。 
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
//
// Related Topics 链表 分治 堆（优先队列） 归并排序 👍 2523 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.PriorityQueue;

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
    public ListNode mergeKLists(ListNode[] lists) {
//        ListNode head = new ListNode();
//        ListNode node = head;
//
//        int index = -1;
//        int tempNum = Integer.MAX_VALUE;
//
//        for (;;){
//            index = -1;
//            tempNum = Integer.MAX_VALUE;
//            for (int i = 0; i <lists.length; i++) {
//                if (lists[i] != null && lists[i].val < tempNum) {
//                    tempNum = lists[i].val;
//                    index = i;
//                }
//            }
//            if (index == -1) break;
//            node.next = lists[index];
//            node = node.next;
//            lists[index] = lists[index].next;
//        }
//        return head.next;

        PriorityQueue<Integer[]> queue = new PriorityQueue<>((o1, o2) -> o1[0].compareTo(o2[0]));
        ListNode head = new ListNode();
        ListNode node = head;


        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null)
                queue.offer(new Integer[]{lists[i].val, i});
        }

        while (!queue.isEmpty()) {
            Integer[] poll = queue.poll();

            node.next = lists[poll[1]];
            node = node.next;
            lists[poll[1]] = lists[poll[1]].next;

            if (lists[poll[1]] != null) {
                queue.offer(new Integer[]{lists[poll[1]].val, poll[1]});
            }
        }

        return head.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
