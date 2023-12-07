package top.yuanql.funplus;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: top.yuanql.funplus
 * @BelongsClassName: two
 * @Author: yuanql
 * @CreateTime: 2023-10-13  19:12
 * @Description:
 * @Version: 1.0
 */


public class two {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param root TreeNode类
     * @return int整型
     */

    int result = Integer.MAX_VALUE;

    public int minDifference (TreeNode root) {
        // write code here



        fun(root.left, root.val);
        fun(root.right, root.val);
        return result;

    }

    public void fun(TreeNode root, int up) {
        if (root == null) return;
        result = Math.min(result, Math.abs(root.val - up));

        fun(root.left, root.val);
        fun(root.right, root.val);
    }

}




class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}

