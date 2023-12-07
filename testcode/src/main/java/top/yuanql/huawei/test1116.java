package top.yuanql.huawei;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: top.yuanql.huawei
 * @BelongsClassName: test1116
 * @Author: yuanql
 * @CreateTime: 2023-11-16  12:37
 * @Description:
 * @Version: 1.0
 */


public class test1116 {
    public static void main(String[] args) {
        String s = "aacabdkacaa";

        String fun = fun(s);
        System.out.println("fun = " + fun);
    }

    /**
     * 最长回文子串
     * 给你一个字符串 s，找到 s 中最长的回文子串。
     * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
     *
     * 示例 1：
     * 输入：s = "babad"
     * 输出："bab"
     * 解释："aba" 同样是符合题意的答案。
     *
     * 示例 2：
     * 输入：s = "cbbd"
     * 输出："bb"
     *
     * 提示：
     * 1 <= s.length <= 1000
     * s 仅由数字和英文字母组成
     */

    public static String fun(String input) {

        if (input.isEmpty()) return "";

        String result = input.charAt(0) + "";
        int max = 1;

        int[][] dp = new int[input.length()][input.length()];

        for (int i = 0; i < input.length(); i++) {
            dp[i][i] = 1;
        }

        for (int i = input.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j <= input.length() - 1; j++) {
                if (input.charAt(i) == input.charAt(j)) {
                    if (dp[i + 1][j - 1] != j - i - 1) continue;
                    dp[i][j] = dp[i + 1][j - 1] + 2;

                    if (dp[i][j] > max) {
                        max = dp[i][j];
                        result = input.substring(i, j + 1);
                    }
                } else {
                    if (j == 0) continue;
                    dp[i][j] = dp[i + 1][j - 1];
                }
            }
        }

//        System.out.println("max = " + max);


        return result.toString();

    }
}
