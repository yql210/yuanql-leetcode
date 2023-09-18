package top.yuanql.baidu;

import java.util.Scanner;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: top.yuanql.baidu
 * @BelongsClassName: first
 * @Author: yuanql
 * @CreateTime: 2023-09-12  19:33
 * @Description:
 * @Version: 1.0
 */


public class first {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int left = 0;
        int result = 0;

        for (int i = 0; i < n; i++) {
            if (in.nextInt() == (left + 1)) {
                left++;
            } else {
                result++;
            }
        }

        if (left == 0) result = -1;

        System.out.println(result);


//        Scanner in = new Scanner(System.in);
//
//        int n = in.nextInt();
//        int[] input = new int[n];
//
//        for (int i = 0; i < n; i++) {
//            input[i] = in.nextInt();
//        }
//
//        int result = 0;
//
//        int left = 0;
//        int right = 0;
//
//        for (; right < n; right++) {
//            if (input[right] == (left + 1)) {
//                left++;
//            } else {
//                result++;
//            }
//        }
//        if (left == 0) result = -1;
//
//        System.out.println(result);
    }

}
