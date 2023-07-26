/*
 * @lc app=leetcode.cn id=162 lang=java
 *
 * [162] 寻找峰值
 */

// @lc code=start
class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0,
            right = nums.length,
            mid = 0;
        if (right == 1)
            return 0; 
        if (nums[0] > nums[1]) 
            return 0;
        if (nums[right - 1] > nums[right -2])
            return right - 1;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid] < nums[mid + 1]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return 0;


    }
}
// @lc code=end

