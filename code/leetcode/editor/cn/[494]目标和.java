//给你一个非负整数数组 nums 和一个整数 target 。 
//
// 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ： 
//
// 
// 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。 
// 
//
// 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1,1,1], target = 3
//输出：5
//解释：一共有 5 种方法让最终目标和为 3 。
//-1 + 1 + 1 + 1 + 1 = 3
//+1 - 1 + 1 + 1 + 1 = 3
//+1 + 1 - 1 + 1 + 1 = 3
//+1 + 1 + 1 - 1 + 1 = 3
//+1 + 1 + 1 + 1 - 1 = 3
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], target = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 20 
// 0 <= nums[i] <= 1000 
// 0 <= sum(nums[i]) <= 1000 
// -1000 <= target <= 1000 
// 
//
// Related Topics 数组 动态规划 回溯 👍 1707 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

//    private int result = 0;
    public int findTargetSumWays(int[] nums, int target) {
//        backtracking(nums, target, 0, 0); // 回溯
//        return result;


        int sum = Arrays.stream(nums).sum();

        if ((sum + target) % 2 == 1 || sum < -target) return 0;
        int flag = Math.abs((sum + target) / 2);

        int[] dp = new int[flag + 1];

        dp[0] = 1;

        for (int i = 0; i < nums.length; i++) {
            for (int j = flag; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[flag];
    }

//    private void backtracking(int[] nums, int target, int start, int sum) { // 回溯
//        if (nums.length == start) {
//            if (target == sum) result++;
//            return;
//        }
//
//        backtracking(nums, target, start + 1, sum + nums[start]);
//        backtracking(nums, target, start + 1, sum - nums[start]);
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
