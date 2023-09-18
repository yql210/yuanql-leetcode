package top.yuanql.xiecheng;

import java.util.Scanner;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: top.yuanql.xiecheng
 * @BelongsClassName: three
 * @Author: yuanql
 * @CreateTime: 2023-09-07  19:02
 * @Description:
 * @Version: 1.0
 */


public class three {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        int[][] input = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = in.next();
            for (int j = 0; j < m; j++) {
                if (str.charAt(j) == 'y') {
                    input[i][j] = 1;
                }
                if (str.charAt(j) == 'o') {
                    input[i][j] = 2;
                }
                if (str.charAt(j) == 'u') {
                    input[i][j] = 3;
                }
            }
        }

        int result = 0;
        int[] usedx = new int[4];
        int[] usedy = new int[4];

        int[][] listX = new int[n][4];
        int[][] listY = new int[m][4];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                listX[i][input[i][j]]++;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                listY[i][input[j][i]]++;
            }
        }


        int flag;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                usedx = new int[4];
                usedy = new int[4];
                if (input[i][j] != 0) {
                    flag = input[i][j];

                    int num1 = 0;
                    int num2 = 0;
                    for (int k = 1; k < 4; k++) {
                        if (k != flag) {
                            if (num1 == 0) num1 = k;
                            else num2 = k;
                        }
                    }
                    result += listX[i][num1] * listY[j][num2] + listX[i][num2] * listY[j][num1];

                }
            }
        }


        System.out.println(result);
    }
}
