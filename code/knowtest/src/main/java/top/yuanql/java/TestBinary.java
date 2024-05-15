package top.yuanql.java;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: top.yuanql.java
 * @BelongsClassName: TestBinary
 * @Author: yuanql
 * @CreateTime: 2024-01-25  09:48
 * @Description:
 * @Version: 1.0
 */


public class TestBinary {

    public static void main(String[] args) {
        test(1);
    }

    public static int test(int k) {
        if (k == 0) return 0;
        int[] bin = new int[11];
        for (int i = 0; i <= 10; i++) {
            bin[i] = (int) Math.pow(2, i);
        }



        double i1 = Math.pow(2, 10);
        System.out.println(i1);
        System.out.println(Integer.toBinaryString((int) i1));
    }

}
