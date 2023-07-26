import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.LogRecord;

/*
 * @lc app=leetcode.cn id=977 lang=java
 *
 * [977] 有序数组的平方
 */

// @lc code=start
class Solution {
    public int[] sortedSquares(int[] nums) {
        
        // 方案一：暴力求解
        // for (int i = 0; i < nums.length; i++)
        //     nums[i] = nums[i] * nums[i];

        // Arrays.sort(nums);
        // return nums;

        // 方案二：双指针
        int left = 0, 
            right = nums.length -1,
            length = nums.length - 1;

        int[] result = new int[nums.length];

        while (left <= right) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                result[length--] = nums[left] * nums[left];
                left++;
            } else {
                result[length--] = nums[right] * nums[right];
                right--;
            }
        }

        return result;

    }
}
// @lc code=end

 