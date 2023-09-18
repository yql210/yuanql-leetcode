package top.yuanql.meituan;

import netscape.security.UserTarget;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: top.yuanql.meituan
 * @BelongsClassName: sec
 * @Author: yuanql
 * @CreateTime: 2023-09-02  19:02
 * @Description:
 * @Version: 1.0
 */


public class sec {

    public static int result = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();

        // 可以将问题转换为去 n - k 个互为倍数的数组有多少种取法

        int[] input = new int[n];

        for (int i = 0; i < n; i++) {
            input[i] = in.nextInt();
        }

        Arrays.sort(input);

//        // 回溯吗！？
//        backing(input, 0, 0, n - k, 1);

        int[][] dp = new int[n][n - k];
        long num = 0;

        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n - k; j++) {
                num = 0;
                for (int l = 0; l < i; l++) {
                    if (input[i] % input[l] == 0) {
                        num += dp[l][j - 1];
                    }
                }
                dp[i][j] = (int) num % (1000000007);
            }
        }

        int result = 0;

        for (int i = 0; i < n; i++) {
            result += dp[i][n - k - 1];
        }

        System.out.println(result);

        // // 注意 hasNext 和 hasNextLine 的区别
        // while (in.hasNextInt()) { // 注意 while 处理多个 case
        //     int a = in.nextInt();
        //     int b = in.nextInt();
        //     System.out.println(a + b);
        // }
    }

    /**
     *
     * @param input
     * @param start
     * @param length 从1开始计数
     * @param maxLength
     */
    public static void backing(int[] input, int start, int length, int maxLength, int flagNum) {
        if (length == maxLength) {
            result++;
            return;
        }

        for (int i = start; i < input.length - maxLength + length + 1; i++) {
            if (input[i] % flagNum == 0) {
                backing(input, i + 1, length + 1, maxLength, input[i]);
            }
        }
    }


}
