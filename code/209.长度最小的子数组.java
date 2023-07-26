import java.util.Arrays;
import java.util.logging.LogRecord;

import javax.security.auth.login.FailedLoginException;
import javax.swing.text.AbstractDocument.BranchElement;
import javax.xml.transform.Templates;

/*
 * @lc app=leetcode.cn id=209 lang=java
 *
 * [209] 长度最小的子数组
 */

// @lc code=start
class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        // int left=0,
        // right=-1,
        // result = nums.length,
        // flag = 0,
        // sum = 0;

        // for (int i = 0; i < nums.length; i++) {
        //     sum += nums[++right];
        //     if (sum >= target) {
        //         for (int j = left; j <= right; j++) {
        //             sum -= nums[left++];

        //             if (sum < target && j != right) {
        //                 flag = right - left + 2;
        //                 if (flag < result) {
        //                     result = flag;
        //                 }
        //                 break;
        //             } else if (j == right ) {
        //                 if (nums[j] >= target) {
        //                     return 1;
        //                 }
        //             }

        //         }
        //     }
        // }
        // if (flag == 0) {
        //     return 0;
        // }
        // return result;


        // 滑动窗口

        int result = 0,
                sum = 0,
                left = 0,
                right = 0,
                nums_length = nums.length;
        for (right = 0; right < nums_length; right++) {
            sum += nums[right];
            if (sum >= target) {
                if (result > (right - left + 1) || result == 0) {
                    result = right - left + 1;
                }
                for ( ; left <= right; left++) {
                    sum -= nums[left];
                    if (sum < target) {
                        left++;
                        break;
                    }

                    if (result > (right - left)) {
                        result = right - left;
                    }
                }
            }

        }

        return result;



    }
}
// @lc code=end

