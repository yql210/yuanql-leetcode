package top.yuanql.test;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: top.yuanql
 * @BelongsClassName: Test96
 * @Author: yuanql
 * @CreateTime: 2023-08-08  19:09
 * @Description:
 * @Version: 1.0
 */


public class Test96 {

    public static void main(String[] args) {
        int i = numTrees(3);

    }

    public static int numTrees(int n) {
        int[] result = new int[n + 1];
        int sum = 0;

        result[0] = 1;
        result[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                sum += result[j - 1] * result[i - j];
            }
            result[i] = sum;
        }

        return result[n];
    }
}
