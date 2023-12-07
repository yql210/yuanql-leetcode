package top.yuanql.lixiang;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Scanner;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: top.yuanql.lixiang
 * @BelongsClassName: three
 * @Author: yuanql
 * @CreateTime: 2023-09-29  09:01
 * @Description:
 * @Version: 1.0
 */


public class three {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] input = new int[11];
        int index = 0;
        long mul = 1;
        int flag = 0;


        for ( ; n != 0; index++) {
            input[index] = n % 10;
            mul = mul * input[index];
            if (input[index] == 0) {
                flag++;
            }
            n = n / 10;
        }
        if (flag == 0) {
            long sum = 1;
            for (int i = 0; i < index - 1; i++) {
                sum = sum * input[i];
                mul = mul / input[i];
                if (sum == mul) {
                    System.out.println("YES");
                    return;
                }
            }

            System.out.println("NO");
        } else if (flag == 1) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }




    }

}
