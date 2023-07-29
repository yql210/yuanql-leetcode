//给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和
// targetSum 。如果存在，返回 true ；否则，返回 false 。 
//
// 叶子节点 是指没有子节点的节点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
//输出：true
//解释：等于目标和的根节点到叶节点路径如上图所示。
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,2,3], targetSum = 5
//输出：false
//解释：树中存在两条根节点到叶子节点的路径：
//(1 --> 2): 和为 3
//(1 --> 3): 和为 4
//不存在 sum = 5 的根节点到叶子节点的路径。 
//
// 示例 3： 
//
// 
//输入：root = [], targetSum = 0
//输出：false
//解释：由于树是空的，所以不存在根节点到叶子节点的路径。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [0, 5000] 内 
// -1000 <= Node.val <= 1000 
// -1000 <= targetSum <= 1000 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1216 👎 0


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
    private boolean FLAG = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // 递归遍历
//        if (root == null) return false;
//        recursion(root, targetSum, 0);
//        return FLAG;

        // 迭代遍历
        if (root == null) return false;

        Deque<TreeNode> stack = new LinkedList<>();
        Deque<Integer> sumInt = new LinkedList<>();
        int sum = 0;

        stack.push(root);
        sumInt.push(0);

        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            sum = sumInt.pop() + pop.val;
            if (pop.left == null && pop.right == null && sum == targetSum) {
                    return true;
            }

            if (pop.right != null) {
                stack.push(pop.right);
                sumInt.push(sum);
            }

            if (pop.left != null) {
                stack.push(pop.left);
                sumInt.push(sum);
            }
        }

        return false;
    }

//    private void recursion(TreeNode root, int targetSum, int sum) { // 递归遍历
//        if (root.left == null && root.right == null) {
//            sum = sum + root.val;
//            if (targetSum == sum) {
//                FLAG = true;
//            }
//            return;
//        }
//        if (root.left != null){
//            // 虽然没用直接使用回溯，但是回溯的思想体现在了 sum + root.val 中
//            recursion(root.left, targetSum, sum + root.val);
//        }
//
//        if (root.right != null){
//            recursion(root.right, targetSum, sum + root.val);
//        }
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
