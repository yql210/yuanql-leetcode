package top.yuanql.huawei;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: top.yuanql.huawei
 * @BelongsClassName: test1115
 * @Author: yuanql
 * @CreateTime: 2023-11-15  18:19
 * @Description:
 * @Version: 1.0
 */


public class Test1115 {

    static boolean isFlag = false;
    public static void main(String[] args) {

        /*
[
[1,4,7,11,15],
[2,5,8,12,19],
[3,6,9,16,22],
[10,13,14,17,24],
[18,21,23,26,30]]
         */

        int[][] input = new int[][]{{1,4,7,11,15}, {2,5,8,12,19}, {3,6,9,16,22}, {10,13,14,17,24}, {18,21,23,26,30}};
        int target = 20;

        int index_X = 0, index_Y = 0;

        fun(input, target, index_X, index_Y);

        System.out.println(isFlag);


//        System.out.println("1");
    }

    private static void fun(int[][] input, int target, int index_X, int index_Y) {
        if (index_X == input.length || index_Y == input[0].length) {
            return;
        }
        if (input[index_X][index_Y] > target) {
            return;
        }

        if (input[index_X][index_Y] == target) {
            isFlag = true;
            return;
        }

        fun(input, target, index_X + 1, index_Y);
        fun(input, target, index_X, index_Y + 1);

    }
}
