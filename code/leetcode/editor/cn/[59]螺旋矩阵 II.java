//给你一个正整数 n ，生成一个包含 1 到 n² 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
//
// Related Topics 数组 矩阵 模拟 👍 1083 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ints = new int[n][n];
        int flage = 0,  // 定义下一步加入数据的前进方向，0：向右   1：向下   2：向左   3：向上
                up = 1,     // 上节点的阈值
                down = n - 1,   // 下节点的阈值
                left = 0,   //左节点的阈值
                right = n - 1,  // 右节点的阈值
                x = 0,  // 当前所在节点的 x 轴坐标
                y = 0;  // 当前所在节点的 y 轴坐标

        for (int i = 1; i <= n * n; i++) {
            ints[x][y] = i;
            switch (flage) {
                case 0:
                    if (y == right) {
                        flage = 1;
                        x++;
                        right--;
                    } else {
                        y++;
                    }
                    break;
                case 1:
                    if (x == down) {
                        flage = 2;
                        y--;
                        down--;
                    } else {
                        x++;
                    }
                    break;
                case 2:
                    if (y == left) {
                        flage = 3;
                        x--;
                        left++;
                    } else {
                        y--;
                    }
                    break;
                case 3:
                    if (x == up) {
                        flage = 0;
                        y++;
                        up++;
                    } else {
                        x--;
                    }
                    break;
            }
        }
        return ints;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
