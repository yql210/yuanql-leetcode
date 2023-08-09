//给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,11,5]
//输出：true
//解释：数组可以分割成 [1, 5, 5] 和 [11] 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,5]
//输出：false
//解释：数组不能分割成两个元素和相等的子集。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
//
// Related Topics 数组 动态规划 👍 1841 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) return false;

        int mid = sum / 2;
//        int[][] dp = new int[nums.length][mid + 1];
        int[] dp1 = new int[mid + 1];

        if (nums[0] == mid) return true;
        for (int i = nums[0]; i < mid + 1; i++) {
            dp1[i] = nums[0];
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = mid; j >= nums[i]; j--) {

                dp1[j] = Math.max(dp1[j], dp1[j - nums[i]] + nums[i]);

                if (dp1[j] == mid) return true;
            }
        }

        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
