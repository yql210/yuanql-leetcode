/*
 * @lc app=leetcode.cn id=704 lang=java
 *
 * [704] 二分查找
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {

        // int result = -1;
        // int left = 0, right = nums.length - 1;

        // if (nums[0] == target) {
        //     return 0;
        // }

        // while (left < right) {
        //     if (nums[((left + right) /2 + 1)] > target) {
        //         right = (left + right) /2;
        //     } else if (nums[((left + right) /2 + 1)] == target) {
        //         return (left + right) /2 + 1;
        //     } else {
        //         left = (left + right) /2 + 1;
        //     }
        // }


        int result = -1;
        int left = 0, right = nums.length;
        while (left < right) {
            if (nums[(left + right) / 2] > target) {
                right = (left + right) / 2;
            } else if (nums[(left + right) / 2] == target) {
                return (left + right) / 2;
            } else {
                left = (left + right) / 2 + 1;
            }
        }

        return result;



        
    }
}
// @lc code=end

