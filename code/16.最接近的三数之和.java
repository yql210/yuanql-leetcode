import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.LogRecord;

/*
 * @lc app=leetcode.cn id=16 lang=java
 *
 * [16] 最接近的三数之和
 */

// @lc code=start
class Solution {
    public int threeSumClosest(int[] nums, int target) {

        int result = nums[0] + nums[1] + nums[2] - target;
        int left,right,flag;

        Arrays.sort(nums);

        for (int i = 0; nums[i] < Math.abs(target) && i < nums.length - 2; i++) {
            left = i + 1;
            right = nums.length -1;
            while (left < right) {

                flag = nums[i] + nums[left] + nums[right] - target;

                if (flag > 0) {
                    right--;
                    if (flag < Math.abs(result)) {
                        result = flag;
                    }
                } else if (flag == 0) {
                    return target;
                } else {
                    left++;
                    if (flag < Math.abs(result)) {
                        result = flag;
                    }
                }
            }
        }

        return result + target;

    }
}
// @lc code=end

