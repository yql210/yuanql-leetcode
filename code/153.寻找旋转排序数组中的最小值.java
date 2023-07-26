/*
 * @lc app=leetcode.cn id=153 lang=java
 *
 * [153] 寻找旋转排序数组中的最小值
 */

// @lc code=start
class Solution {
    public int findMin(int[] nums) {
        int left = 0, 
            right = nums.length - 1, 
            mid = 0,
            end =nums.length - 1;
        if (nums[0] <= nums[end])
            return nums[0];
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] > nums[end]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            if (nums[mid] > nums[mid + 1] ) {
                return nums[mid + 1];
            }

        }
        return nums[mid + 1];

    }
}
// @lc code=end

