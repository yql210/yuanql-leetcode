//给你一个 n x n 整数矩阵 grid ，请你返回 非零偏移下降路径 数字和的最小值。 
//
// 非零偏移下降路径 定义为：从 grid 数组中的每一行选择一个数字，且按顺序选出来的数字中，相邻数字不在原数组的同一列。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：grid = [[1,2,3],[4,5,6],[7,8,9]]
//输出：13
//解释：
//所有非零偏移下降路径包括：
//[1,5,9], [1,5,7], [1,6,7], [1,6,8],
//[2,4,8], [2,4,9], [2,6,7], [2,6,8],
//[3,4,8], [3,4,9], [3,5,7], [3,5,9]
//下降路径中数字和最小的是 [1,5,7] ，所以答案是 13 。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[7]]
//输出：7
// 
//
// 
//
// 提示： 
//
// 
// n == grid.length == grid[i].length 
// 1 <= n <= 200 
// -99 <= grid[i][j] <= 99 
// 
//
// Related Topics 数组 动态规划 矩阵 👍 104 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minFallingPathSum(int[][] grid) {
        for (int row = 1; row < grid.length; row++) {
            for (int col = 0; col < grid.length; col++) {
                grid[row][col] = grid[row][col] + findMin(row ,col, grid);
            }
        }
        return findMin(grid.length, -1, grid);
    }

    /**
     * 查找上一行中不与此节点在一列的最小值
     * @param row 当前节点所在行
     * @param col 当前节点所在列
     * @param grid 二维矩阵
     * @return 返回最小值
     */
    private int findMin(int row, int col, int[][] grid) {
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length; i++) {
            if (i == col) continue;
            if (result > grid[row - 1][i]) result = grid[row - 1][i];
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
