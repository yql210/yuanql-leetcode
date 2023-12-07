package top.yuanql.lixiang;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: top.yuanql.lixiang
 * @BelongsClassName: two
 * @Author: yuanql
 * @CreateTime: 2023-09-29  09:01
 * @Description:
 * @Version: 1.0
 */


public class two {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int a = in.nextInt();
        int result = 0;
        int[] used = new int[10];
        int temp = 0;

        while (a != 0) {
            temp = a % 10;
            if (used[temp] == 0) {
                used[temp] = 1;
                result = result * 10 + temp;
            }


            a = a / 10;
        }

        System.out.println(result);
    }

}
