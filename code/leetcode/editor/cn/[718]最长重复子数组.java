//给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
//输出：3
//解释：长度最长的公共子数组是 [3,2,1] 。
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length, nums2.length <= 1000 
// 0 <= nums1[i], nums2[i] <= 100 
// 
//
// Related Topics 数组 二分查找 动态规划 滑动窗口 哈希函数 滚动哈希 👍 976 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int[] dp = new int[nums1.length + 1];
        int result = 0;
        for (int i = 0; i < nums2.length; i++) {
            for (int j = nums1.length - 1; j >= 0; j--) { // 倒叙进行遍历
                if (nums2[i] == nums1[j]) { // 数值相等的时候，最小赋值为1
                    dp[j + 1] = dp[j] + 1;
                    result = Math.max(result, dp[j + 1]);
                } else dp[j + 1] = 0; // 此时数值不相等，就初始化为0；清除本位的相关信息，这也是为什么进行倒叙遍历的原因！！
            }
//            if (nums2[i] == nums1[0]) {
//                dp[0] = 1;
//                result = Math.max(result, 1);
//            } else dp[0] = 0;

//            for (int j = 0; j < nums1.length; j++) {
//                System.out.print("    " + dp[j]);
//            }
//            System.out.println();
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
