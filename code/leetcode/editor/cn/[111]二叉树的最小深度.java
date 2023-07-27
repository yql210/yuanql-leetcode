//给定一个二叉树，找出其最小深度。 
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明：叶子节点是指没有子节点的节点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：root = [2,null,3,null,4,null,5,null,6]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数的范围在 [0, 10⁵] 内 
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1038 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Deque;
import java.util.LinkedList;

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
    private int result = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {

//        // 迭代法：层序遍历
//        if (root == null) return 0;
//        int leave = 0;
//        Deque<TreeNode> queue = new LinkedList<>();
//
//        queue.offer(root);
//
//        while (!queue.isEmpty()) {
//            queue.offer(null);
//            leave++;
//            while (queue.peek() != null) {
//                TreeNode poll = queue.poll();
//                if (poll.left != null)
//                    queue.offer(poll.left);
//                if (poll.right != null)
//                    queue.offer(poll.right);
//                if (poll.right == null && poll.left == null)
//                    return leave;
//            }
//            queue.poll();
//        }
//        return leave;

        // 递归法
        if (root == null) return 0;
        recursion(root, 0);
        return result;
    }

    private void recursion(TreeNode root, int leave) {
        if (root == null) return;
        leave++;
        if (root.left == null && root.right == null && result > leave) {
            result = leave;
            return;
        }
        recursion(root.left, leave);
        recursion(root.right, leave);

    }
}
//leetcode submit region end(Prohibit modification and deletion)
