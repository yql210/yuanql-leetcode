//给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,null,2,3]
//输出：[3,2,1]
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
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
//
// Related Topics 栈 树 深度优先搜索 二叉树 👍 1053 👎 0


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
    public List<Integer> postorderTraversal(TreeNode root) {
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

                deque.push(peek);       // 中节点
                deque.push(flag);

                if (peek.right != null)     // 右节点
                    deque.push(peek.right);

                if (peek.left != null)      // 左节点
                    deque.push(peek.left);

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
//            if (pop.left != null) {
//                deque.push(pop.left);
//            }
//            if (pop.right != null) {
//                deque.push(pop.right);
//            }
//        }
////        recur(root, result);
//        Collections.reverse(result);
        return  result;
    }
//    private void recur(TreeNode node, List<Integer> res) {
//        if (node == null) {
//            return;
//        }
//        recur(node.left, res);
//        recur(node.right, res);
//        res.add(node.val);
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
