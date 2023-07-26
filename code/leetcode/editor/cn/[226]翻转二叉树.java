//给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [4,2,7,1,3,6,9]
//输出：[4,7,2,9,6,3,1]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [2,1,3]
//输出：[2,3,1]
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
// 树中节点数目范围在 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1640 👎 0


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
    public TreeNode invertTree(TreeNode root) {
//        //================深度优先搜索：递归遍历========================
//        recursion(root);  // 深度优先搜索：递归遍历

//        //================广度优先搜索：迭代遍历========================
//        if (root == null) return root;
//        Deque<TreeNode> queue = new LinkedList<>();
//
//        queue.offer(root);
//
//        while (!queue.isEmpty()) {
//            queue.offer(null);
//
//            while (queue.peek() != null) {
//                TreeNode poll = queue.poll();
//                if (poll.left != null)
//                    queue.offer(poll.left);
//                if (poll.right != null)
//                    queue.offer(poll.right);
//                swap(poll);
//            }
//            queue.poll();
//        }

        //================深度优先搜索：迭代遍历========================
        if (root == null) return root;

        Deque<TreeNode> stack = new LinkedList<>();

        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();

            if (pop.left != null)
                stack.push(pop.left);
            if (pop.right != null)
                stack.push(pop.right);

            swap(pop);
        }

        return root;
    }

    private void swap(TreeNode root) {  //================迭代遍历========================
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
//    private void recursion(TreeNode root) { //================深度优先搜索：递归遍历========================
//        if (root == null) return;
//
//        recursion(root.left);
//        recursion(root.right);
//
//        TreeNode temp = root.left;
//        root.left = root.right;
//        root.right = temp;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
