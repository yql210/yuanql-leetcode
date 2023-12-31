//给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。 
//
// 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "bbbab"
//输出：4
//解释：一个可能的最长回文子序列为 "bbbb" 。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出：2
//解释：一个可能的最长回文子序列为 "bb" 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由小写英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 1088 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        int max = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) { // 此时两边的数据相等
                    if (j - i <= 1) {
                        dp[i][j] = j - i + 1;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    }
                    max = Math.max(max, dp[i][j]);
                } else {
                    if (j - i <= 1) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]); // 此处没考虑明白导致没写错这个递推函数
                    }
                    max = Math.max(max, dp[i][j]);
                }
            }
//            for (int j = 0; j < s.length(); j++) {
//                System.out.print("    " + dp[i][j]);
//            }
//            System.out.println();
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
