//给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。 
//
// 叶子节点 是指没有子节点的节点。 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,3,null,5]
//输出：["1->2->5","1->3"]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：["1"]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// Related Topics 树 深度优先搜索 字符串 回溯 二叉树 👍 991 👎 0


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
//    private List<String> result = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        // 递归
//        String a = root.val + "";
//
//        if (root.left == null && root.right == null) {
//            result.add(a);
//            return result;
//        }
//        recursion(root.left, a);
//        recursion(root.right, a);
//
//        return result;

        // 递归 + 回溯
//        if (root == null) return new ArrayList<>();
//        List<String> result = new ArrayList<>();
//        List<Integer> path = new ArrayList<>();
//        recall(root, path, result);
//        return result;

        // 迭代
        if (root == null) return new ArrayList<>();
        List<String> result = new ArrayList<>();
        Deque<Object> stack = new LinkedList<>();

        stack.push(root);
        stack.push(root.val + "");

        while (!stack.isEmpty()) {
            String path = (String) stack.pop();
            TreeNode node = (TreeNode) stack.pop();
            // 若找到叶子节点
            if (node.left == null && node.right == null) {
                result.add(path);
            }
            //右子节点不为空
            if (node.right != null) {
                stack.push(node.right);
                stack.push(path + "->" + node.right.val);
            }
            //左子节点不为空
            if (node.left != null) {
                stack.push(node.left);
                stack.push(path + "->" + node.left.val);
            }
        }

        return result;
    }

//    private void recall(TreeNode root, List<Integer> path, List<String> result) {// 递归 + 回溯
//        path.add(root.val);
//        if (root.left == null && root.right == null) {
//            StringBuilder stringBuilder = new StringBuilder();
//            for (int i = 0; i < path.size() - 1; i++) {
//                stringBuilder.append(path.get(i)).append("->");
//            }
//            stringBuilder.append(path.get(path.size() - 1));
//            result.add(stringBuilder.toString());
//            return;
//        }
//
//        if (root.left != null) {
//            recall(root.left, path, result);
//            path.remove(path.size() - 1);
//        }
//        if (root.right != null) {
//            recall(root.right, path, result);
//            path.remove(path.size() - 1);
//        }
//
//    }

//    private void recursion(TreeNode root, String st){// 递归
//        if (root == null) return;
//        if (root.left == null && root.right == null) {
//            result.add(st + "->" + root.val);
//            return;
//        }
//        recursion(root.left, st + "->" + root.val);
//        recursion(root.right, st + "->" + root.val);
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
