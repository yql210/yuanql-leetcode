//给你 root1 和 root2 这两棵二叉搜索树。请你返回一个列表，其中包含 两棵树 中的所有整数并按 升序 排序。. 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root1 = [2,1,4], root2 = [1,0,3]
//输出：[0,1,1,2,3,4]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root1 = [1,null,8], root2 = [8,1]
//输出：[1,1,8,8]
// 
//
// 
//
// 提示： 
//
// 
// 每棵树的节点数在 [0, 5000] 范围内 
// -10⁵ <= Node.val <= 10⁵ 
// 
//
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 排序 👍 171 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
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

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        recursion(root1, list1);
        recursion(root2, list2);
//        System.out.println("list1 = " + list1);
//        System.out.println("list2 = " + list2);

        List<Integer> result = new ArrayList<>(list1.size() + list2.size());

        int index1 = 0, index2 = 0;

        for (int i = 0; i < list1.size() + list2.size(); i++) {
            if (index1 >= list1.size()) {
                result.add(list2.get(index2));
                index2++;
            } else if (index2 >= list2.size()) {
                result.add(list1.get(index1));
                index1++;
            } else if (list1.get(index1) < list2.get(index2)) {
                result.add(list1.get(index1));
                index1++;
            } else {
                result.add(list2.get(index2));
                index2++;
            }
        }

        return result;
    }

    private void recursion(TreeNode root, List<Integer> list) {
        if (root == null) return;

        recursion(root.left, list);
        list.add(root.val);
        recursion(root.right, list);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
