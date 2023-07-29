//给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。 
//
// 叶子节点 是指没有子节点的节点。 
//
// 
// 
// 
// 
// 
//
// 示例 1： 
// 
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//输出：[[5,4,11,2],[5,8,4,5]]
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,2,3], targetSum = 5
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1,2], targetSum = 0
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点总数在范围 [0, 5000] 内 
// -1000 <= Node.val <= 1000 
// -1000 <= targetSum <= 1000 
// 
//
// Related Topics 树 深度优先搜索 回溯 二叉树 👍 1008 👎 0


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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

//        // 递归
//        List<List<Integer>> result = new ArrayList<>();
//        if (root == null) return result;
//        recursion(root, targetSum, 0, new ArrayList<>(), result);
//
//        return result;

        // 迭代
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Deque<TreeNode> stack =  new LinkedList<>();
        Deque<List<Integer>> listStack =  new LinkedList<>();
        Deque<Integer> sumStack =  new LinkedList<>();

        stack.push(root);
        sumStack.push(0);
        listStack.push(new ArrayList<>());

        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            List<Integer> list = listStack.pop();
            list.add(pop.val);
            Integer sum = sumStack.pop() + pop.val;

            if (sum == targetSum && pop.left == null && pop.right == null) {
                result.add(new ArrayList<>(list));
            }

            if (pop.right != null){
                stack.push(pop.right);
                sumStack.push(sum);
                listStack.push(new ArrayList<>(list));
            }
            if (pop.left != null){
                stack.push(pop.left);
                sumStack.push(sum);
                listStack.push(new ArrayList<>(list));
            }

        }

        return result;
    }

//    private void recursion(TreeNode root, int targetSum, int sum, List<Integer> path, List<List<Integer>> result) {
//        // 参数说明：root：二叉树的节点；targetSum：需要对比的数值；sum：遍历过的路径和；path：遍历过的路径数据；result：返回的最终结果集
//
//        if (root.left == null && root.right == null) {
//            sum += root.val;
//            path.add(root.val);
//            if (sum == targetSum){
//                result.add(new ArrayList<>(path));
//            }
//            sum -= root.val;
//            path.remove(path.size() - 1);
//            return;
//        }
//
//        path.add(root.val);
//        if (root.left != null){
//            recursion(root.left, targetSum, sum + root.val, path, result);
//        }
//
//        if (root.right != null){
//            recursion(root.right, targetSum, sum + root.val, path, result);
//        }
//        path.remove(path.size() - 1);
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

