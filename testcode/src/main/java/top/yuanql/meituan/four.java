package top.yuanql.meituan;

import java.util.Scanner;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: top.yuanql.meituan
 * @BelongsClassName: four
 * @Author: yuanql
 * @CreateTime: 2023-09-02  19:02
 * @Description:
 * @Version: 1.0
 */


public class four {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        if (n < 7) {
            System.out.println("No");
            return;
        }
        String str = "meituan";
        int index = 0;

        String string = new String();

        for (int i = 0; i < n; i++) {
            string = in.next();
            for (int j = 0; j < m; j++) {
                if (string.charAt(j) == str.charAt(index)) {
                    index++;
                    if (index == 7) {
                        System.out.println("Yes");
                        return;
                    }
                }
            }
        }
        System.out.println("No");



        // // 注意 hasNext 和 hasNextLine 的区别
        // while (in.hasNextInt()) { // 注意 while 处理多个 case
        //     int a = in.nextInt();
        //     int b = in.nextInt();
        //     System.out.println(a + b);
        // }
    }
}
