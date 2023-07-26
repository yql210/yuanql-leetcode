//给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,null,2,3]
//输出：[1,3,2]
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
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
//
// Related Topics 栈 树 深度优先搜索 二叉树 👍 1857 👎 0


//leetcode submit region begin(Prohibit modification and deletion)


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
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
    public List<Integer> inorderTraversal(TreeNode root) {
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

                deque.push(peek);       // 中节点
                deque.push(flag);

                if (peek.left != null)      // 左节点
                    deque.push(peek.left);
            } else {
                deque.pop(); // 弹出null指针

                TreeNode pop = deque.pop();
                result.add(pop.val);
            }
        }


//        if (root == null) {
//            return result;
//        }
//
//        Deque<TreeNode> deque = new ArrayDeque<>();
//
//        while (root != null || !deque.isEmpty()) {
//            if (root != null) {
//                deque.push(root);
//                root = root.left;
//            } else {
//                TreeNode pop = deque.pop();
//                result.add(pop.val);
//                root = pop.right;
//            }
//        }

//        recur(root, result);
        return  result;
    }

//    private void recur(TreeNode node, List<Integer> res) {
//        if (node == null) {
//            return;
//        }
//        recur(node.left, res);
//        res.add(node.val);
//        recur(node.right, res);
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
