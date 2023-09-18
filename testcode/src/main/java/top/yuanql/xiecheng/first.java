package top.yuanql.xiecheng;

import java.util.Scanner;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: top.yuanql.xiecheng
 * @BelongsClassName: first
 * @Author: yuanql
 * @CreateTime: 2023-09-07  19:00
 * @Description:
 * @Version: 1.0
 */


public class first {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String str = in.next();

        int result = 0;
        boolean flag = true;
        int sum0 = 0;
        int sum1 = 0;
        int[] dp = new int[str.length()];

        for (int i = 0; i < str.length(); i++) {
            flag = true;
            sum0 = 0;
            sum1 = 0;
            for (int j = i; j < str.length(); j++) {
                if (str.charAt(j) == '0') {
                    result++;
                    if (flag) sum0++;
                } else {
                    flag = false;
                    sum1++;
                    if (sum1 >= sum0) break;
                    result++;
                }
            }
        }


//        int[][][] dp = new int[str.length()][str.length()][3]; // 当前的区间中前缀最长的长度
//
//        for (int i = str.length() - 1; i >= 0; i--) {
//            for (int j = i; j < str.length(); j++) {
//                if (i == j) {
//                    if (str.charAt(i) == '1') dp[i][j][1] = 1;
//                    else {
//                        result++;
//                        dp[i][j][0] = 1;
//                    }
//                } else if (j - i <= 1){
//                    if (str.charAt(i) == '0' && str.charAt(j) == '0') {
//                        result++;
//                        dp[i][j][0] = 2;
//                    } else if (str.charAt(i) == '1') {
//                        result++;
//                        dp[i][j][0] = 1;
//                    } else if (str.charAt(j) == '1')  {
//                        result++;
////                        dp[i][j][0] = 0;
//                        dp[i][j][1] = 1;
//                    } else {
//                        dp[i][j][1] = 1;
//                    }
//                } else {
//                    if (str.charAt(i) == '0') {
//                        if (str.charAt(j) == '0') {
//                            result++;
//                            if (dp[i]) {
//
//                            }
//                        } else {
//
//                        }
//
//                    } else {
//                        if (str.charAt(j) == '0') {
//
//                        } else {
//
//                        }
//                    }
//
//
//                }
//            }
//        }



        System.out.println(result);
    }
}
