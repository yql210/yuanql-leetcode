/*
 * @lc app=leetcode.cn id=59 lang=java
 *
 * [59] 螺旋矩阵 II
 */

// @lc code=start
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];

        // 方法一： 定义边界与方向
        int edge = 0,   // 执行坐标的前进方向： 0 --> 向右，1 --> 向下，2 --> 向左，3 --> 向上
            up = 1,         // 边界，坐标的上边界
            down = n - 1,   // 边界，坐标的下边界
            left = 0,       // 边界，坐标的左边界
            right = n -1,   // 边界，坐标的右边界
            x = 0,      // 坐标的x轴位置
            y = -1;      // 坐标的y轴位置

        for (int i = 1; i <= n * n; i++) {
            switch (edge) {
                case 0:
                    if (++y > right) {
                        y--;
                        edge++;
                        x++;
                        right--;
                    }
                    break;
                case 1:
                    if (++x > down) {
                        x--;
                        edge++;
                        y--;
                        down--;
                    }
                    break;
                case 2:
                    if (--y < left) {
                        y++;
                        edge++;
                        x--;
                        left++;
                    }
                    break;
                case 3:
                    if (--x < up) {
                        x++;
                        edge = 0;
                        y++;
                        up++;
                    }
                    break;

            }
            result[x][y] = i;
        }

        return result;
    }
}
// @lc code=end

