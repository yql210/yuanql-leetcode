package top.yuanql.meituan;

import java.util.Scanner;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: top.yuanql.meituan
 * @BelongsClassName: five
 * @Author: yuanql
 * @CreateTime: 2023-09-02  19:03
 * @Description:
 * @Version: 1.0
 */


public class five {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int length = in.nextInt();
        int[] input = new int[length];
        int[] b = new int[length - 1];
        input[0] = in.nextInt();
        input[1] = in.nextInt();
        b[0] = input[0] + input[1];
        for (int i = 2; i < length; i++) {
            input[i] = in.nextInt();
            b[i - 1] = input[i] + input[i - 1];
            if (input[i] <= input[i - 1] || b[i - 1] <= b[i - 2]) {
                System.out.println("No");
                break;
            }
        }
        System.out.println("Yes");




        // // 注意 hasNext 和 hasNextLine 的区别
        // while (in.hasNextInt()) { // 注意 while 处理多个 case
        //     int a = in.nextInt();
        //     int b = in.nextInt();
        //     System.out.println(a + b);
        // }
    }
}
