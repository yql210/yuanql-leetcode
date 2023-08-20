//给你两个字符串 s 和 t ，统计并返回在 s 的 子序列 中 t 出现的个数。 
//
// 题目数据保证答案符合 32 位带符号整数范围。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "rabbbit", t = "rabbit"
//输出：3
//解释：
//如下所示, 有 3 种可以从 s 中得到 "rabbit" 的方案。
//rabbbit
//rabbbit
//rabbbit 
//
// 示例 2： 
//
// 
//输入：s = "babgbag", t = "bag"
//输出：5
//解释：
//如下所示, 有 5 种可以从 s 中得到 "bag" 的方案。 
//babgbag
//babgbag
//babgbag
//babgbag
//babgbag
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 1000 
// s 和 t 由英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 1101 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numDistinct(String s, String t) {
//        int[][] dp = new int[s.length()][2];
//
//        for (int i = 0; i < t.length(); i++) {
//            for (int j = s.length() - 1; j >= 0; j--) {
//                if (t.charAt(i) == s.charAt(j)) {
//                    int max = 0, sumMax = 0;
//                    for (int k = 0; k < j; k++) {
//                        if (dp[k][0] > max) {
//                            max = dp[k][0];
//                            sumMax = dp[k][1];
//                        } else if (dp[k][0] == max) {
//                            sumMax += dp[k][1];
//                        }
//                    }
//                    dp[j][0] = max + 1;
//                    dp[j][1] = Math.max(1, sumMax);
//                }
//            }
//
////            for (int j = 0; j < s.length(); j++) {
////                System.out.print("    " + dp[j][0]);
////            }
////            System.out.println();
//        }
//
//        int sum = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if (dp[i][0] == t.length()) {
//                sum += dp[i][1];
//            }
//        }
//        return sum;


        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[s.length()][t.length()];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
