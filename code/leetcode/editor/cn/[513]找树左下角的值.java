//给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。 
//
// 假设二叉树中至少有一个节点。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: root = [2,1,3]
//输出: 1
// 
//
// 示例 2: 
//
// 
//
// 
//输入: [1,2,3,4,null,5,6,null,null,7]
//输出: 7
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [1,10⁴] 
// 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 502 👎 0


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
    public int findBottomLeftValue(TreeNode root) {
//        // 递归遍历
//        return recursion(root, 0)[0];

        // 迭代遍历（层序遍历）
        Deque<TreeNode> queue = new LinkedList<>();
        int result = root.val;

        queue.offer(root);

        while (!queue.isEmpty()) {
            queue.offer(null);
            result = queue.peek().val;
            while (queue.peek() != null) {
                TreeNode poll = queue.poll();
                if (poll.left != null)
                    queue.offer(poll.left);
                if (poll.right != null)
                    queue.offer(poll.right);
            }

            queue.poll();
        }

        return result;
    }

//    private int[] recursion(TreeNode root, int depth) { // 递归遍历
//        depth++;
//        if (root ==  null) return new int[]{0,-1, depth};
//        // 第一位：记录真实数据； 第二位：标志位，判断第一位的真实数据是否注入进来；第三位：此次数据注入的时候，其所在的深度
//
//        int[] recursionLeft = recursion(root.left, depth);
//        int[] recursionRight = recursion(root.right, depth);
//
//        if (recursionLeft[2] < recursionRight[2]) {
//            return recursionRight;
//        } else {
//            if (recursionLeft[1] == -1) {
//                recursionLeft[0] = root.val;
//                recursionLeft[1] = 1;
//            }
//            return recursionLeft;
//        }
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
