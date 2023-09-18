package top.yuanql.baidu;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: top.yuanql.baidu
 * @BelongsClassName: two
 * @Author: yuanql
 * @CreateTime: 2023-09-12  19:33
 * @Description:
 * @Version: 1.0
 */


public class two {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int a = in.nextInt();
        int[][] time = new int[m][2];


        for (int i = 0; i < m; i++) {
            time[i][0] = in.nextInt();
        }

        for (int i = 0; i < m; i++) {
            time[i][1] = in.nextInt();
        }


        Arrays.sort(time, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        PriorityQueue<Integer> endTime = new PriorityQueue<>();
        int result = 0;
        int indexDay = 1;
        int indexList = 0;


        for (int i = 0; i <= n; i++) { // 去遍历时间吗
            while (indexList < m && time[indexList][0] == i) {
                endTime.add(time[indexList][1]);
                indexList++;
            }
            while (!endTime.isEmpty() && endTime.peek() < i) {
                endTime.poll();
            }
            if (endTime.size() == a) {
                indexDay = i + 1;
                continue;
            }
            if (i - indexDay + 1 >= k) {
                result++;
                indexDay++;
            }
        }

        System.out.println(result);
    }

}
