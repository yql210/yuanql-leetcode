/*
 * @lc app=leetcode.cn id=35 lang=java
 *
 * [35] 搜索插入位置
 */

// @lc code=start
class Solution {
    public int searchInsert(int[] nums, int target) {

        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[(left + right)/2] > target) {
                right = (left + right)/2;
            } else if (nums[(left + right)/2] == target) {
                return (left + right)/2;
            } else {
                left = (left + right)/2 + 1;
            }
        }
        
        if (((left + right)/2 == nums.length - 1) && (nums[nums.length - 1] < target)) {
            return (left + right)/2 + 1;
        }

        return (left + right)/2;

    }
}
// @lc code=end

