package top.yuanql.yaxinSafe;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: top.yuanql.yaxinSafe
 * @BelongsClassName: one
 * @Author: yuanql
 * @CreateTime: 2023-09-17  15:14
 * @Description:
 * @Version: 1.0
 */


public class one {

    public static void main(String[] args) {
        int[][] maze = new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};

        one one = new one();

        int pathsCnt = one.findPathsCnt(maze);

        System.out.println("pathsCnt = " + pathsCnt);
    }
    private int result = 0;

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * N * N的迷宫，迷宫中有一些格子是墙壁，无法通过。现在有一个机器人位于迷宫的起始点(0, 0)，要求从起始点出发，经过非墙壁的格子且只能经过一次，最终回到起始点。请计算满足条件的路径数量。
     * @param maze int整型二维数组 迷宫二维整数数组maze，其中maze[i][j]值为0表示可以通过，迷宫大小N，1<=N<=10
     * @return int整型
     */
    public int findPathsCnt (int[][] maze) {
        // write code here

        // 通过回溯去做

        backing(maze, 0, 0);
        return result - 2;

    }

    private void backing(int[][] maze, int indexX, int indexY) {

        if (indexX < 0 || indexY < 0 || indexX >= maze.length || indexY >= maze[0].length) return;

        if (maze[indexX][indexY] == 1) {
            if (indexX == 0 && indexY == 0) {
                result++;
            }
            return;
        }

        maze[indexX][indexY] = 1;
        backing(maze, indexX + 1, indexY);
        backing(maze, indexX - 1, indexY);
        backing(maze, indexX, indexY + 1);
        backing(maze, indexX, indexY - 1);
        maze[indexX][indexY] = 0;
    }
}
