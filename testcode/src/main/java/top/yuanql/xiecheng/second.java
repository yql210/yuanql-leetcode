package top.yuanql.xiecheng;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: top.yuanql.xiecheng
 * @BelongsClassName: second
 * @Author: yuanql
 * @CreateTime: 2023-09-07  19:02
 * @Description:
 * @Version: 1.0
 */


public class second {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();


        for (int i = 0; i < t; i++) {

            int n = in.nextInt();
            int left = in.nextInt();
            int right = in.nextInt();
//            int[] input = new int[n];
            int sum = 0;
            int temp;

            PriorityQueue<Integer> queue1 = new PriorityQueue<>((o1, o2) -> o1 - o2); //小到大
            PriorityQueue<Integer> queue2 = new PriorityQueue<>((o1, o2) -> o2 - o1); // 大到小

            for (int j = 0; j < n; j++) {
                temp = in.nextInt();
                sum += temp;
                queue1.add(temp);
                queue2.add(temp);
            }

            if (sum > n * right || sum < n * left) {
                System.out.println("-1");
                continue;
            }


            int result = 0;
            while (queue2.peek() > right || queue1.peek() < left) {
                Integer pollMax = queue2.poll();
                Integer pollMin = queue1.poll();
                if (pollMax - result == 0) {
                    result += left - pollMin;
                } else if (left - pollMin == 0) {
                    result += pollMax - result;
                } else {
                    int min = Math.min(pollMax - result, left - pollMin);
                    result += min;
                    queue2.add(pollMax - min);
                    queue1.add(pollMin + min);
                }



            }

            System.out.println(result);
        }

    }
}
