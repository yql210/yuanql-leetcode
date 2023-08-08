//给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。 
//
// 返回 你可以获得的最大乘积 。 
//
// 
//
// 示例 1: 
//
// 
//输入: n = 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1。 
//
// 示例 2: 
//
// 
//输入: n = 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。 
//
// 
//
// 提示: 
//
// 
// 2 <= n <= 58 
// 
//
// Related Topics 数学 动态规划 👍 1241 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int integerBreak(int n) {
//        int result = 0;
//        int i = 0, i1 = 0;
//        for (int k = 2; k <= n; k++) {
//            i = n / k;
//            i1 = 1;
//
//            for (int j = 0; j < k - (n - k * i); j++) {
//                i1 *= i;
//            }
//            for (int j = 0; j < n - k * i; j++) {
//                i1 *= i + 1;
//            }
//            if (i1 > result) result = i1;
//        }
//
//        return result;

        int[] result = new int[n];

        result[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                int max = Math.max(j * (i - j), j * result[i - j - 1]);
                result[i - 1] = Math.max(result[i - 1], max);
            }
        }
        return result[n - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
