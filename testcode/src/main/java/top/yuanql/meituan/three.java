package top.yuanql.meituan;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: top.yuanql.meituan
 * @BelongsClassName: three
 * @Author: yuanql
 * @CreateTime: 2023-09-02  19:02
 * @Description:
 * @Version: 1.0
 */


public class three {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        long n = in.nextInt();

        int start = in.nextInt();

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int i = 0; i < n - 1; i++) {
            queue.add(in.nextInt());
        }

        int sum = 0;
        while (start <= queue.peek()) {
            sum++;
            start = start * 2;
            Integer poll = queue.poll();
            queue.add(poll / 2);
        }

        System.out.println(sum);




        // // 注意 hasNext 和 hasNextLine 的区别
        // while (in.hasNextInt()) { // 注意 while 处理多个 case
        //     int a = in.nextInt();
        //     int b = in.nextInt();
        //     System.out.println(a + b);
        // }
    }
}
