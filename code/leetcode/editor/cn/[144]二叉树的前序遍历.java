//给你二叉树的根节点 root ，返回它节点值的 前序 遍历。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,null,2,3]
//输出：[1,2,3]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
// 
// 
//输入：root = [1,2]
//输出：[1,2]
// 
//
// 示例 5： 
// 
// 
//输入：root = [1,null,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
//
// Related Topics 栈 树 深度优先搜索 二叉树 👍 1083 👎 0


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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        TreeNode flag = new TreeNode(); // 因为Deque不能想其中 push 一个null的对象，所有设置一个标志位对象

        Deque<TreeNode> deque = new ArrayDeque<>();

        deque.push(root);
        while (!deque.isEmpty()) {
            TreeNode peek = deque.peek();
            if (peek != flag) {
                deque.pop();

                if (peek.right != null)     // 右节点
                    deque.push(peek.right);

                if (peek.left != null)      // 左节点
                    deque.push(peek.left);

                deque.push(peek);       // 中节点
                deque.push(flag);
            } else {
                deque.pop(); // 弹出null指针

                TreeNode pop = deque.pop();
                result.add(pop.val);
            }
        }

//        Deque<TreeNode> deque = new ArrayDeque<>();
//
//        if (root != null)
//            deque.push(root);
//
//        while (!deque.isEmpty()) {
//            TreeNode pop = deque.pop();
//            result.add(pop.val);
//            if (pop.right != null) {
//                deque.push(pop.right);
//            }
//            if (pop.left != null) {
//                deque.push(pop.left);
//            }
//        }

//        recur(root, result);
        return  result;
    }

//    private void recur(TreeNode node, List<Integer> res) {
//        if (node == null) {
//            return;
//        }
//        res.add(node.val);
//        recur(node.left, res);
//        recur(node.right, res);
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
