package top.yuanql;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: top.yuanql
 * @BelongsClassName: Test59
 * @Author: yuanql
 * @CreateTime: 2023-07-13  11:22
 * @Description: 59 循环矩阵Ⅱ
 * @Version: 1.0
 */


public class Test59 {

    public static void main(String[] args) {
        generateMatrix(3);
    }

    public static int[][] generateMatrix(int n) {
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


