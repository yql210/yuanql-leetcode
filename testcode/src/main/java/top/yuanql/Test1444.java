package top.yuanql;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: top.yuanql
 * @BelongsClassName: Test1444
 * @Author: yuanql
 * @CreateTime: 2023-08-17  21:55
 * @Description:
 * @Version: 1.0
 */


public class Test1444 {

    public static void main(String[] args) {
        String[] pizza = new String[]{"A..","AAA","..."};
        int k = 3;
        int ways = ways1(pizza, k);

        System.out.println("ways = " + ways);

    }

    public static int ways(String[] pizza, int k) {
        int m = pizza.length, n = pizza[0].length(), mod = 1_000_000_007;
        int[][] apples = new int[m + 1][n + 1];
        int[][][] dp = new int[k + 1][m + 1][n + 1];

        // 预处理
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                apples[i][j] = apples[i][j + 1] + apples[i + 1][j] - apples[i + 1][j + 1] + (pizza[i].charAt(j) == 'A' ? 1 : 0);
                dp[1][i][j] = apples[i][j] > 0 ? 1 : 0;
            }
        }

        for (int ki = 2; ki <= k; ki++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    // 水平方向切
                    for (int i2 = i + 1; i2 < m; i2++) {
                        if (apples[i][j] > apples[i2][j]) {
                            dp[ki][i][j] = (dp[ki][i][j] + dp[ki - 1][i2][j]) % mod;
                        }
                    }
                    // 垂直方向切
                    for (int j2 = j + 1; j2 < n; j2++) {
                        if (apples[i][j] > apples[i][j2]) {
                            dp[ki][i][j] = (dp[ki][i][j] + dp[ki - 1][i][j2]) % mod;
                        }
                    }
                }
            }
        }
        return dp[k][0][0];
    }


    public static int ways1(String[] pizza, int k) {
        int row = pizza.length, col = pizza[0].length(), mod = 1000000007;
        int[][] apple = new int[row][col];
        int[][][] dp = new int[k][row][col];

        int sum = 0;
        for (int i = row - 1; i >= 0 ; i--) { // 从右下角向左上角，统计苹果的数据为多少
            String s = pizza[i];
            sum = 0;
            for (int j = col - 1; j >= 0; j--) {
                if (s.charAt(j) == 'A') sum++;
                if (i == row - 1) apple[i][j] = sum;
                else apple[i][j] =  apple[i + 1][j] + sum;
                dp[0][i][j] = sum > 0 ? 1 : 0;
                System.out.print("   " + apple[i][j]);
            }
            System.out.println();
        }

        System.out.println("sum = " + sum);

        for (int ki = 1; ki < k; ki++) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {

                    // 按照水平方向去切
                    for (int l = i + 1; l < row; l++) {
                        if (apple[i][j] > apple[l][j]) {
                            dp[ki][i][j] = (dp[ki][i][j] + dp[ki - 1][l][j]) % mod;
                        }
                    }

                    // 按照垂直方向去切
                    for (int l = j + 1; l < col; l++) {
                        if (apple[i][j] > apple[i][l]) {
                            dp[ki][i][j] = (dp[ki][i][j] + dp[ki - 1][i][l]) % mod;
                        }
                    }
                }
            }
        }
        return dp[k - 1][0][0];
    }
}
