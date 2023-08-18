//给你一个 rows x cols 大小的矩形披萨和一个整数 k ，矩形包含两种字符： 'A' （表示苹果）和 '.' （表示空白格子）。你需要切披萨 k-1
// 次，得到 k 块披萨并送给别人。 
//
// 切披萨的每一刀，先要选择是向垂直还是水平方向切，再在矩形的边界上选一个切的位置，将披萨一分为二。如果垂直地切披萨，那么需要把左边的部分送给一个人，如果水平
//地切，那么需要把上面的部分送给一个人。在切完最后一刀后，需要把剩下来的一块送给最后一个人。 
//
// 请你返回确保每一块披萨包含 至少 一个苹果的切披萨方案数。由于答案可能是个很大的数字，请你返回它对 10^9 + 7 取余的结果。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：pizza = ["A..","AAA","..."], k = 3
//输出：3 
//解释：上图展示了三种切披萨的方案。注意每一块披萨都至少包含一个苹果。
// 
//
// 示例 2： 
//
// 输入：pizza = ["A..","AA.","..."], k = 3
//输出：1
// 
//
// 示例 3： 
//
// 输入：pizza = ["A..","A..","..."], k = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= rows, cols <= 50 
// rows == row
// cols == pizza[i].length 
// 1 <= k <= 10 
// pizza 只包含字符 'A' 和 '.' 。 
// 
//
// Related Topics 记忆化搜索 数组 动态规划 矩阵 👍 161 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int ways(String[] pizza, int k) {
        int row = pizza.length, col = pizza[0].length(), mod = 1000000007;
        int[][] apple = new int[row][col];
        int[][][] dp = new int[k][row][col];

        int sum = 0;
        for (int i = row - 1; i >= 0 ; i--) { // 从右下角向左上角，统计苹果的数据为多少
            String s = pizza[i];
             sum = 0;
            for (int j = col - 1; j >= 0; j--) {
                if (s.charAt(j) == 'A') sum++;
                if (i == row - 1) apple[i][j] = sum;
                else apple[i][j] =  apple[i + 1][j] + sum;
                dp[0][i][j] = apple[i][j] > 0 ? 1 : 0;
//                System.out.print("   " + apple[i][j]);
            }
//            System.out.println();
        }

//        System.out.println("sum = " + sum);

        for (int ki = 1; ki < k; ki++) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {

                    // 按照水平方向去切
                    for (int l = i + 1; l < row; l++) {
                        if (apple[i][j] > apple[l][j]) {
                            dp[ki][i][j] = (dp[ki][i][j] + dp[ki - 1][l][j]) % mod;
                        }
                    }

                    // 按照垂直方向去切
                    for (int l = j + 1; l < col; l++) {
                        if (apple[i][j] > apple[i][l]) {
                            dp[ki][i][j] = (dp[ki][i][j] + dp[ki - 1][i][l]) % mod;
                        }
                    }
                }
            }
        }

        return dp[k - 1][0][0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
