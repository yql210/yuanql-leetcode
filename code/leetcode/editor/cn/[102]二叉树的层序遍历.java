//给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[3],[9,20],[15,7]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：[[1]]
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 2000] 内 
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics 树 广度优先搜索 二叉树 👍 1736 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return result;
        }

        recur(root, 0);

//        Deque<TreeNode> deque = new LinkedList<>(); // 此处使用的是队列的思想
//
//        deque.addFirst(root);
//
//        while (!deque.isEmpty()) {
//            deque.addLast(null);
//            List<Integer> temp = new ArrayList<>();
//            while (deque.peek()!= null) {  // peek == peekFirst
//                TreeNode poll = deque.poll();  // poll == pollFirst
//                temp.add(poll.val);
//
//                if (poll.left != null)
//                    deque.addLast(poll.left);
//
//                if (poll.right != null)
//                    deque.addLast(poll.right);
//            }
//            deque.poll();
//            result.add(temp);
//        }

        return result;
    }

    private void recur(TreeNode node, Integer depth) {
        if (node == null) return;
        depth++;

        if (depth > result.size()) {
            List<Integer> temp = new ArrayList<>();
            result.add(temp);
        }

        result.get(depth - 1).add(node.val);

        recur(node.left, depth);
        recur(node.right, depth);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
