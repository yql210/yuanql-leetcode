//给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1644 👎 0


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

    private int maxLeave = 0;
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        recus(root, 0);
//        Deque<TreeNode> queue = new LinkedList<>();
//
//        queue.offer(root);
//
//        while (!queue.isEmpty()) {
//            queue.add(null);
//            while (queue.peek() != null) {
//                TreeNode poll = queue.poll();
//                if (poll.left != null)
//                    queue.offer(poll.left);
//                if (poll.right != null)
//                    queue.offer(poll.right);
//            }
//            queue.poll();
//            maxLeave++;
//        }
        return maxLeave;
    }

    private void recus(TreeNode root, int depth) {
        if (root == null) return;
        depth++;

        if (maxLeave < depth) {
            maxLeave = depth;
        }
        recus(root.left, depth);
        recus(root.right, depth);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
