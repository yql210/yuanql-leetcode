package top.yuanql.xiecheng;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: top.yuanql.meituan
 * @BelongsClassName: Test2594
 * @Author: yuanql
 * @CreateTime: 2023-09-07  10:26
 * @Description:
 * @Version: 1.0
 */


public class Test2594 {

    public static void main(String[] args) {
        int[] ranks = new int[]{4,2,3,1};
        int cars = 10;
        repairCars(ranks, cars);

    }

    public static long repairCars(int[] ranks, int cars) {
        long[][] dp = new long[ranks.length + 1][cars + 1];
        long minNum;

        for (int j = 1; j <= cars; j++) {
            dp[1][j] = (long) ranks[0] * j * j;
        }

        for (int i = 2; i <= ranks.length; i ++) {

            for (int j = 1; j <= cars; j++) {
                minNum = Long.MAX_VALUE;
                for (int k = 0; k <= j; k++) {
                    minNum = Math.min(minNum, dp[i - 1][j - k] + (long) ranks[i - 1] * k * k);
                }

                dp[i][j] = minNum;

            }


        }
        return dp[ranks.length][cars];
    }


}
