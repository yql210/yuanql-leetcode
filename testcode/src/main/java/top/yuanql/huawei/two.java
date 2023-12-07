package top.yuanql.huawei;

import java.util.Map;
import java.util.Scanner;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: top.yuanql.huawei
 * @BelongsClassName: two
 * @Author: yuanql
 * @CreateTime: 2023-09-20  19:01
 * @Description:
 * @Version: 1.0
 */


public class two {

    private static long result = Long.MAX_VALUE;
    private static int lengthX;
    private static int lengthY;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        lengthX = in.nextInt();
        lengthY = in.nextInt();

        int[][] input = new int[lengthX][lengthY];

        for (int i = 0; i < lengthX; i++) {
            for (int j = 0; j < lengthY; j++) {
                input[i][j] = in.nextInt();
            }
        }

        for (int i = 0; i < lengthX; i++) {
            backing(input, i, 0, 0, 0);
        }

        if (result == Long.MAX_VALUE) {
            result = -1;
        }
        System.out.println(result);
    }

    private static void backing(int[][] input, int indexX, int indexY, int tep, int dir) {
        if (indexX < 0 || indexX >= lengthX || indexY < 0 || indexY >= lengthY) return;
        if (input[indexX][indexY] == 0) return;
        if (indexY == lengthY - 1) {
            result = Math.min(result, tep);
            return;
        }

        if (input[indexX][indexY + 1] == 1) {
            backing(input, indexX, indexY + 1, tep + 1, 0);
        } else {
            if (dir == 0) {
                backing(input, indexX + 1, indexY, tep + 1, 1);
                backing(input, indexX - 1, indexY, tep + 1, -1);
            } else if (dir == 1) {
                backing(input, indexX + 1, indexY, tep + 1, 1);
            } else if (dir == -1) {
                backing(input, indexX - 1, indexY, tep + 1, -1);
            }
        }
    }

}
