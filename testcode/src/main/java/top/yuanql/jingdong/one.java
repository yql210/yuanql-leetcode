package top.yuanql.jingdong;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: top.yuanql.jingdong
 * @BelongsClassName: one
 * @Author: yuanql
 * @CreateTime: 2023-09-09  19:19
 * @Description:
 * @Version: 1.0
 */


public class one {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();

        int[] input = new int[n];

        for (int i = 0; i < n; i++) {
            input[i] = in.nextInt();
        }

        Arrays.sort(input);

        long result = 0;
        int index = input.length - 1;

        for (int i = input.length - 2; i >= 0; i--) {
            if (input[index] - input[i] <= k) {
                result += (long) input[index] * input[i];
                index = i - 1;
                i--;
            } else {
                index = i;
            }
        }

        System.out.println(result);
    }
}
