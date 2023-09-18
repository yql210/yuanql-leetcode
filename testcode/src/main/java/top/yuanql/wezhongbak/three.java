package top.yuanql.wezhongbak;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: top.yuanql.wezhongbak
 * @BelongsClassName: three
 * @Author: yuanql
 * @CreateTime: 2023-09-13  20:20
 * @Description:
 * @Version: 1.0
 */


public class three {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] input = new int[n];

        for (int i = 0; i < n; i++) {
            input[i] = in.nextInt();
        }

        HashSet<Integer> set = new HashSet<>();

        for (int i = n - 1; i >= 0; i--) {
            if (set.contains(input[i])) {
                input[i] = 0;
            } else {
                set.add(input[i]);
            }
        }

        for (int i = 0; i < n - 1; i++) {
            if (input[i] != 0) System.out.print(input[i] + " ");
        }
        System.out.println(input[n - 1]);

    }
}
