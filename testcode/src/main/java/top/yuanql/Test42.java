package top.yuanql;

import java.util.Arrays;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: top.yuanql
 * @BelongsClassName: Test42
 * @Author: yuanql
 * @CreateTime: 2023-07-23  12:24
 * @Description: 接雨水
 * @Version: 1.0
 */


public class Test42 {
    public static void main(String[] args) {
        int[] tem = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};

        System.out.println("tem = " + tem);

        int trap = trap(tem);
    }

    public static int trap(int[] height) {
        int result = 0;
        int[][] heightInt = new int[height.length][2];
        for (int i = 0; i < height.length; i++) {
            heightInt[i][0] = height[i];
            heightInt[i][1] = i;
        }

        Arrays.sort(heightInt, ((o1, o2) -> (o2[0] - o1[0])));

        for (int[] te :
                heightInt) {
            System.out.println(te[0] + "------" + te[1]);
        }

        System.out.println(heightInt);

        return result;
    }
}
