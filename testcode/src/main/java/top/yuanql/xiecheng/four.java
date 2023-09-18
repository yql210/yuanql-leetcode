package top.yuanql.xiecheng;

import java.net.BindException;
import java.util.Scanner;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: top.yuanql.xiecheng
 * @BelongsClassName: four
 * @Author: yuanql
 * @CreateTime: 2023-09-07  19:02
 * @Description:
 * @Version: 1.0
 */


public class four {

    public static int result = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int num = in.nextInt();

        rowBacking(0, num, new boolean[num], 0);

        System.out.println(result);
    }

    public static void rowBacking(int index, int sum, boolean[] used, int forword) {
        if (index == sum) {
            result++;
            return;
        }

        for (int i = 0; i < sum; i++) {
            if (!used[i]) { // 没有使用过才进来
                if (forword == 0 || isTrue(forword + i + 1)) {
                    used[i] = true;
                    rowBacking(index + 1, sum, used, i + 1);
                    used[i] = false;
                }
            }
        }
    }


    public static boolean isTrue(int num) {
        if (num == 2 || num == 3 || num == 5 || num == 7 || num == 11 || num == 13 || num == 17 || num == 19) return false;
//        if (num % 2 == 0) return true;
//        if (num % 3 == 0) return true;
//        if (num % 5 == 0) return true;
//        if (num % 7 == 0) return true;
//        for (int i = 11; i < num / 2; i++) {
//            if (num % i == 0) return true;
//        }
        return true;
    }
}
