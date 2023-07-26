import javax.swing.text.AbstractDocument.BranchElement;

/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0,
            right = nums.length - 1,
            mid = 0,
            nums_size = nums.length - 1,
            start = -1,
            end = -1;
        if (nums_size == -1)
            return new int[]{start, end};
        while(left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if(nums[mid] == target) {
                start = end = mid;
                while (start > 0) {
                    if (nums[--start] != target)
                    {
                        start++;
                        break; 
                    }
                }
                while (end < nums_size) {
                    if (nums[++end] != target)
                    {
                        end--;
                        break;
                    }
                }
                return new int[]{start, end};
            } else {
                left = mid + 1;
            }
        }
    
        return new int[]{start, end};
    }
}
// @lc code=end

