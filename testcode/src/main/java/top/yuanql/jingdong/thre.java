package top.yuanql.jingdong;

import java.util.Scanner;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: top.yuanql.jingdong
 * @BelongsClassName: thre
 * @Author: yuanql
 * @CreateTime: 2023-09-09  19:20
 * @Description:
 * @Version: 1.0
 */


public class thre {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//
//        int n = in.nextInt();
//        int[] input = new int[n];
//
//        int[] dp = new int[n];
//        long result = 0;
//        long temp = 0;
//        long MOD = 1000000000 + 7;
//
//        for (int i = 0; i < n; i++) {
//            input[i] = in.nextInt();
//            dp[i] = input[i];
//            temp += dp[i];
//        }
//
//        result += temp;
//
//        for (int i = 2; i <= n; i++) { // 代表乘数
//            temp = 0;
//            for (int j = 0; j + i - 1 < n; j++) {
//                dp[j] = dp[j] + i * input[j + i - 1];
//                temp += dp[j];
//            }
//            result = (result + temp) % MOD;
//        }
//
//        System.out.println(result);


        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] input = new int[n];



        for (int i = 0; i < n; i++) {
            input[i] = in.nextInt();
        }

        long result = 0;
        long MOD = 1000000000 + 7;
        long temp = 0;

        for (int i = 0; i < n; i++) {

            temp = ((i + 2) * (i + 1) / 2 * input[i] * (n - i)) % MOD;

            result = (result + temp) % MOD;
        }

        System.out.println(result);
    }
}
