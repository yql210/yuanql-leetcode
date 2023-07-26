//给你一个二叉树的根节点 root ， 检查它是否轴对称。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,2,3,4,4,3]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,2,2,null,3,null,3]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 1000] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你可以运用递归和迭代两种方法解决这个问题吗？ 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 2479 👎 0


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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

//        // ============递归遍历===================
//        recursion(root.left, root.right);

        // ============迭代法===================
        TreeNode flagNode = new TreeNode();
        Deque<TreeNode> leftNode = new LinkedList<>();
        Deque<TreeNode> rightNode = new LinkedList<>();

        leftNode.offer(root.left);
        rightNode.offer(root.right);

        while (!leftNode.isEmpty() && !rightNode.isEmpty()) {
            leftNode.offer(flagNode);
            rightNode.offer(flagNode);

            while (leftNode.peek() != flagNode && rightNode.peek() != flagNode) {
                TreeNode leftTem = leftNode.poll();
                TreeNode rightTem = rightNode.poll();

                if (leftTem == null && rightTem == null) continue;
                else if (leftTem == null) return false;
                else if (rightTem == null) return false;
                else if (leftTem.val != rightTem.val) return false;

                leftNode.offer(leftTem.left);
                leftNode.offer(leftTem.right);
                rightNode.offer(rightTem.right);
                rightNode.offer(rightTem.left);

            }
            leftNode.poll();
            rightNode.poll();
        }
        return true;
    }

//    private void recursion(TreeNode leftNode, TreeNode rightNode) { // ============递归遍历===================
//        if (leftNode == null && rightNode == null) return;
//
//        if (leftNode == null || rightNode == null || leftNode.val != rightNode.val) {
//            FLAG = false;
//            return;
//        }
//
//        recursion(leftNode.left, rightNode.right);
//        recursion(leftNode.right, rightNode.left);
//
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
