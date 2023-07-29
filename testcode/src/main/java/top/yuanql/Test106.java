package top.yuanql;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: top.yuanql
 * @BelongsClassName: Test106
 * @Author: yuanql
 * @CreateTime: 2023-07-29  13:27
 * @Description:
 * @Version: 1.0
 */


public class Test106 {
    public static void main(String[] args) {
        int[] inorder = new int[]{9,3,15,20,7};
        int[] postorder = new int[]{9,15,7,20,3};

        Test106 test106 = new Test106();

        test106.buildTree(inorder, postorder);

    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {

//        TreeNode head = new TreeNode();
//
//        head.val = postorder[postorder.length - 1];
//
//        List<Integer> inorderList = new ArrayList<>();


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


    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
