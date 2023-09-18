package top.yuanql.test;

import java.util.Arrays;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: top.yuanql
 * @BelongsClassName: ArraysLi
 * @Author: yuanql
 * @CreateTime: 2023-07-27  08:02
 * @Description: Arraylist测试
 * @Version: 1.0
 */


public class ArraysLi {
    public static void main(String[] args) {
        int[] tem = new int[]{1,2,3,4,5,3,2,1,6,78,4,2};

        System.out.println("tem = " + tem);

        for (int i = 0; i < tem.length; i++) {
            System.out.printf("  " + tem[i]);
        }
        Arrays.sort(tem);
        System.out.println("");
        for (int i = 0; i < tem.length; i++) {
            System.out.printf("  " + tem[i]);
        }
        System.out.println("tem = " + tem);

        System.out.println("--------------------------");
        int[][] grid = new int[2][];

        grid[0] = new int[]{1,2,3,4,5,3,2,1,6,78,4,2};
        grid[1] = new int[]{1,2,333,4,5,3,2,1,6,78,4,2};

        for (int i = 0; i < grid.length; i++) {
            Arrays.sort(grid[i]);
        }

        for (int i = 0; i < grid[0].length; i++) {
            System.out.printf("  " + grid[0][i]);
        }
        System.out.println("");
        for (int i = 0; i < grid[1].length; i++) {
            System.out.printf("  " + grid[1][i]);
        }


        System.out.println();


        Integer i1 = 40;
        Integer i3 = 40;
        Integer i2 = new Integer(40);
        Integer i4 = new Integer(40);
        System.out.println(i1==i2);
        System.out.println(i1==i3);
        System.out.println(i4==i2);
        System.out.println(i4.equals(i2));






    }
}
