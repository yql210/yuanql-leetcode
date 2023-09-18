package top.yuanql.yongyou;

import java.util.Scanner;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: top.yuanql.yongyou
 * @BelongsClassName: two
 * @Author: yuanql
 * @CreateTime: 2023-09-18  19:25
 * @Description:
 * @Version: 1.0
 */


public class two {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int a = in.nextInt();
        int b = in.nextInt();

        long[][] dp = new long[a + 1][b + 1];

        for (int i = 0; i <= a; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i <= b; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= b; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        System.out.println(dp[a][b]);

//        // 注意 hasNext 和 hasNextLine 的区别
//        while (in.hasNextInt()) { // 注意 while 处理多个 case
//            int a = in.nextInt();
//            int b = in.nextInt();
//            System.out.println(a + b);
//        }
    }
}
