//给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历） 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[15,7],[9,20],[3]]
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
// Related Topics 树 广度优先搜索 二叉树 👍 698 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;

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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Deque<TreeNode> deque = new LinkedList<>();

        deque.add(root);

        while (!deque.isEmpty()) {
            deque.addLast(null);
            List<Integer> tem = new ArrayList<>();
            while (deque.peek() != null) {
                TreeNode poll = deque.poll();
                tem.add(poll.val);
                if (poll.left != null)
                    deque.addLast(poll.left);
                if (poll.right != null)
                    deque.addLast(poll.right);
            }
            deque.poll();
            result.add(tem);
        }
        Collections.reverse(result);  // 本题与102.二叉树的层序遍历的区别就是添加了此内容，其他没用任何改变
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
