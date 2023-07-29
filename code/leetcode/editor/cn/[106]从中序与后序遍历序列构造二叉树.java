//给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并
//返回这颗 二叉树 。 
//
// 
//
// 示例 1: 
// 
// 
//输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
//输出：[3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入：inorder = [-1], postorder = [-1]
//输出：[-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= inorder.length <= 3000 
// postorder.length == inorder.length 
// -3000 <= inorder[i], postorder[i] <= 3000 
// inorder 和 postorder 都由 不同 的值组成 
// postorder 中每一个值都在 inorder 中 
// inorder 保证是树的中序遍历 
// postorder 保证是树的后序遍历 
// 
//
// Related Topics 树 数组 哈希表 分治 二叉树 👍 1057 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        return recursion(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode recursion(int[] inorder, int inStart, int inEnd, int[] postorder, int poStart, int poEnd) {
        if (inEnd < inStart) return null;
        TreeNode head = new TreeNode();

        int i = postorder[poEnd];

        head.val = i;

        int index = findIndex(inorder, i, inStart, inEnd);

        TreeNode leftRecursion = recursion(inorder, inStart, (index - 1), postorder, poStart, (poStart + index - inStart - 1));
        TreeNode rightRecursion = recursion(inorder,(index + 1), inEnd, postorder, (poStart + index - inStart), poEnd - 1);

        head.left = leftRecursion;
        head.right = rightRecursion;

        return head;
    }

    private int findIndex(int[] list, int target, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (list[i] == target)
                return i;
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
