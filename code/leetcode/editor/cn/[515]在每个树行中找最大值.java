//给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。 
//
// 
//
// 示例1： 
//
// 
//
// 
//输入: root = [1,3,2,5,3,null,9]
//输出: [1,3,9]
// 
//
// 示例2： 
//
// 
//输入: root = [1,2,3]
//输出: [1,3]
// 
//
// 
//
// 提示： 
//
// 
// 二叉树的节点个数的范围是 [0,10⁴] 
// 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
//
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 325 👎 0


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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        resuc(root, 0, result);

//        if (root == null) return result;
//
//        Deque<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//
//        while (!queue.isEmpty()) {
//            queue.offer(null);
//            int maxTemp = queue.peek().val;
//            while (queue.peek() != null) {
//                TreeNode poll = queue.poll();
//                if (maxTemp < poll.val) {
//                    maxTemp = poll.val;
//                }
//
//                if (poll.left != null)
//                    queue.offer(poll.left);
//                if (poll.right != null)
//                    queue.offer(poll.right);
//            }
//            result.add(maxTemp);
//            queue.poll();
//        }
        return result;
    }

    private void resuc(TreeNode root, int leave, List<Integer> result) {
        if (root == null) return;
        leave++;
        if (result.size() < leave) {
            result.add(Integer.MIN_VALUE);
        }

        if (root.val > result.get(leave - 1)) {
            result.set(leave - 1, root.val);
        }

        resuc(root.left, leave, result);
        resuc(root.right, leave, result);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
