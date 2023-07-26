import javax.swing.plaf.synth.Region;

/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {

        int left = 0, 
            right = nums.length, 
            mid = 0, 
            start = nums[0],
            flag = 0;

        if (target < start) 
            flag = 1;

        while (left < right) {
            mid = left + (right - left) / 2;
            if (flag == 0 ) {
                if (nums[mid] < start || nums[mid] > target) {
                    right = mid;
                } else if (nums[mid] == target) {
                    return mid;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] > start || nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] == target) {
                    return mid;
                } else {
                    right = mid;
                }
            }
        }
        return -1;
    }
}
// @lc code=end

