//给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics 数组 二分查找 👍 2364 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        int left = 0, right = nums.length - 1, middle = 0, flag = 0;

        // 随便找到一个等于
        while (left <= right) {
            middle = left + (right - left) / 2;
            if (nums[middle] == target) {
                flag = 1;
                break;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        // 此时数组中不存在 target 的数值，直接返回 [-1, -1]
        if (flag == 0) {
            return result;
        }
        // 此时数组中存在 target 的数组。
        flag = middle;
        int right_mid = middle, left_mid = middle;

        while (left <= right_mid) {
            middle = left + (right_mid - left) / 2;
            if (nums[middle] == target) {
                right_mid = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        result[0] = left;

        while (left_mid <= right) {
            middle = left_mid + (right - left_mid) / 2;
            if (nums[middle] == target) {
                left_mid = middle + 1;
            } else {
                right = middle -1;
            }
        }
        result[1] = right;

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
