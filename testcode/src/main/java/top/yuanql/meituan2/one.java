package top.yuanql.meituan2;

import java.util.Scanner;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: top.yuanql.meituan2
 * @BelongsClassName: one
 * @Author: yuanql
 * @CreateTime: 2023-09-09  10:00
 * @Description:
 * @Version: 1.0
 */


public class one {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int[] input = new int[n];

        for (int i = 0; i < n; i++) {
            input[i] = in.nextInt();
        }

        long MOD = 1000000007;
        long result = 0;
        long temp = 0;

//        long[][] dp = new long[n + 1][n + 1];
//        long[] dp1 = new long[n + 1];
        long[] dp2 = new long[n + 1];
        long tempL = 0l;
        long tempL1 = 0l;

        // 我已经将时间复杂度降低为 n的平方 了，还是不行呐

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                tempL = dp2[j];
                dp2[j] = dp2[j] + dp2[j - 1] - tempL1 + (input[i] ^ input[j]);
                tempL1 = tempL;
                temp += dp2[j];

            }
            result = (result + temp) % MOD;
            temp = 0;

            tempL1 = 0l;

//            dp2 = dp1;
//            dp1 = new long[n + 1];
//            for (int j = 0; j < n + 1; j++) {
//                dp2[j] = dp1[j];
//                dp1[j] = 0;
//            }
        }

        System.out.println(result);
    }
}
