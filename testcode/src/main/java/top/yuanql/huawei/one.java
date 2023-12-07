package top.yuanql.huawei;

import java.util.Scanner;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: top.yuanql.huawei
 * @BelongsClassName: one
 * @Author: yuanql
 * @CreateTime: 2023-09-20  19:01
 * @Description:
 * @Version: 1.0
 */


public class one {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int[] input = new int[n];

        for (int i = 0; i < n; i++) {
            input[i] = in.nextInt();
        }

        int sn = in.nextInt();

        int indexX = -1, indexY = -1;

        if (sn == input[0]) {
            for (int i = n - 1; i >= 0; i--) {
                if (sn == input[i]) {
                    indexX = i;
                } else {
                    break;
                }
            }
//            if (indexX == 0) {
//                indexY = n - 1;
//            } else {
                for (int i = 0; i < n; i++) {
                    if (sn == input[i]) {
                        indexY = i;
                    } else {
                        break;
                    }
                }
//            }
        } else {
            boolean flag = true;
            for (int i = 0; i < n; i++) {
                if (sn == input[i]) {
                    if (flag) {
                        indexX = i;
                        indexY = i;
                        flag = false;
                    }else {
                        indexY = i;
                    }
                }
            }
        }


        System.out.println(indexX + " " + indexY);
    }
}
