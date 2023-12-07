package top.yuanql.funplus;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: top.yuanql.funplus
 * @BelongsClassName: one
 * @Author: yuanql
 * @CreateTime: 2023-10-13  19:12
 * @Description:
 * @Version: 1.0
 */


public class one {

    boolean isUp = false;
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * public String solve (String str1, String str1)
     * @param str1 string字符串
     * @param str2 string字符串
     * @return string字符串
     */
    public String solve (String str1, String str2) {
        // write code here

        StringBuilder result = new StringBuilder();
        int index1 = str1.length() - 1;
        int index2 = str2.length() - 1;
        char ch1, ch2;



        while (index1 >= 0 || index2 >= 0 || isUp) {
            if (index1 >= 0) ch1 = str1.charAt(index1);
            else ch1 = '0';
            if (index2 >= 0) ch2 = str2.charAt(index2);
            else ch2 = '0';

            result.append(sum(ch1, ch2));
            index1--;
            index2--;
        }
        result.reverse();
        return result.toString();

    }

    public char sum(char ch1, char ch2) {
        if (isUp) {
            isUp = false;
            if (ch1 == '0' && ch2 == '0') return '1';
            isUp = true;
            if (ch1 == '1' && ch2 == '1') return '1';
            return '0';
        } else {
            if (ch1 == '0' && ch2 == '0') return '0';
            if (ch1 == '1' && ch2 == '1') {
                isUp = true;
                return '0';
            }
            return '1';
        }

    }
}
