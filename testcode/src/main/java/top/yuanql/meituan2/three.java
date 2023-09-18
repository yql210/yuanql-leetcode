package top.yuanql.meituan2;

import java.util.Scanner;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: top.yuanql.meituan2
 * @BelongsClassName: three
 * @Author: yuanql
 * @CreateTime: 2023-09-09  10:01
 * @Description:
 * @Version: 1.0
 */


public class three {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();
        String str = in.next();
        int index = 0;

        // 尝试一下贪心
//        int result = 0;
//
//        for (int i = 1; i < n; i++) {
//            if (index != i) {
//                if (str.charAt(index) != str.charAt(i)){
//                    if (k > 0){
//                        k--;
//                        index = i + 1;
//                    } else {
//                        result++;
//                        index = i;
//                    }
//                } else {
//                    index = i + 1;
//                }
//            }
//        }
//
//        if (k == 0) {
//            if (index != n) {
//                result++;
//            }
//        } else if (k % 2 == 1){
//            if (index == n) {
//                result += 2;
//            }
//        }

        int[][][] dp = new int[n + 1][2][k + 1];

        for (int i = 0; i < n; i++) {

        }


        System.out.println(Math.max(dp[n][0][k], dp[n][1][k]));
    }
}
