package top.yuanql.jingdong;

import java.util.Map;
import java.util.Scanner;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: top.yuanql.jingdong
 * @BelongsClassName: two
 * @Author: yuanql
 * @CreateTime: 2023-09-09  19:19
 * @Description:
 * @Version: 1.0
 */


public class two {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] input = new int[n];

        for (int i = 0; i < n; i++) {
            input[i] = in.nextInt();
        }

        int[] dp = new int[n];



        for (int i = 3; i < n; i++) {
            dp[i] = Math.min(dp[i - 1] + input[i - 1], dp[i - 2] + input[i - 2]);
        }

        System.out.println(dp[n - 1]);
    }
}
