package top.yuanql.meituan2;

import java.util.Map;
import java.util.Scanner;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: top.yuanql.meituan2
 * @BelongsClassName: four
 * @Author: yuanql
 * @CreateTime: 2023-09-09  10:01
 * @Description:
 * @Version: 1.0
 */


public class four {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] input = new int[n];
        long SUM = 0;

        for (int i = 0; i < n; i++) {
            input[i] = in.nextInt();
            SUM += input[i];
        }

        long sum = input[0];
        long result = Long.MAX_VALUE;

        for (int i = 1; i < n; i++) {
            if (sum >= input[i]) {
                result = Math.min(result, SUM - 2 * input[i]);
            }
            sum += input[i];
        }

        if (result == Long.MAX_VALUE) {
            result = -1;
        }
        System.out.println(result);
    }
}
