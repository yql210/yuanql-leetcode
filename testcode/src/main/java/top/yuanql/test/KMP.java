package top.yuanql.test;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: top.yuanql
 * @BelongsClassName: KMP
 * @Author: yuanql
 * @CreateTime: 2023-06-15  10:25
 * @Description: 尝试通过求解字符串前缀表
 * @Version: 1.0
 */


public class KMP {
    public static void main(String[] args) {
        String start = "abcabcabc";
//        String start = "aabaabaaf";

        int[] ints = countNext(start);

        for (int i = 0; i < ints.length; i++) {
            System.out.println("ints[i] = " + ints[i] + "  " + i + "  " + start.charAt(i));
        }
    }

    private static int[] countNext(String start) {
        int[] result = new int[start.length()];

        int i = 1,j = 0;
        for (; i < start.length(); i++) {
            while (j != 0 && start.charAt(i) != start.charAt(j)) {
                j = result[j - 1];
            }
            if (start.charAt(i) == start.charAt(j)) {
                result[i] = ++j;
            }
        }
        return result;
    }


}
