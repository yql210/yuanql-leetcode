package top.yuanql.meituan2;

import java.util.Scanner;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: top.yuanql.meituan2
 * @BelongsClassName: two
 * @Author: yuanql
 * @CreateTime: 2023-09-09  10:01
 * @Description:
 * @Version: 1.0
 */


public class two {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        int[] result = new int[n];
        // 还是贪心
        int skip = 1;
        result[0] = 1;

        for (int i = 1; i < n; i++) {
            if (result[i - 1] + skip + n - i - 1 <= m) {
                result[i] = result[i - 1] + skip;
                skip++;
            } else {
                result[i] = result[i - 1] + 1;
            }
        }
        for (int i = 0; i < n - 1; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println(result[n - 1]);
    }
}
