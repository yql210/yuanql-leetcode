package top.yuanql.test;

import java.util.Scanner;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: top.yuanql.test
 * @BelongsClassName: 蔚来
 * @Author: yuanql
 * @CreateTime: 2023-09-13  18:47
 * @Description:
 * @Version: 1.0
 */


public class weilai {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();

        for (int i = 0; i < T; i++) {
            int n = in.nextInt();
            String input = in.next();

            int[] result = new int[n];
            int index = -1;
            char flag = input.charAt(0);

            for (int j = 0; j < n; j++) {
                if (input.charAt(j) == flag) {
                    result[j] = index;
                } else {
                    result[j] = j;
                    index = j;
                    flag = input.charAt(j);
                }
            }

            for (int j = 0; j < n - 1; j++) {
                System.out.print(result[j] + " ");
            }
            System.out.print(result[n - 1]);
            System.out.println();
        }

    }
}
