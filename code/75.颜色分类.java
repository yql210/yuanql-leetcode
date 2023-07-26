/*
 * @lc app=leetcode.cn id=75 lang=java
 *
 * [75] 颜色分类
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {

        // 方法一：统计个数，然后编排
        // int red = 0,white = 0;
        // for (int i = 0; i < nums.length; i++) {
        //     if (nums[i] == 0) {
        //         red++;
        //     } else if (nums[i] == 1) {
        //         white++;
        //     }
        // }

        // for (int i = 0; i < red; i++) {
        //     nums[i] = 0;
        // }
        // for (int i = red; i < red + white; i++) {
        //     nums[i] = 1;
        // }
        // for (int i = red + white; i < nums.length; i++) {
        //     nums[i] = 2;
        // }

        // 方法二： 循环一次执行完成 
        int red = 0, white = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[red] = 0;
                if (red != white)
                    nums[white] = 1;
                red++;
                white++;
            } else if (nums[i] == 1) {
                nums[white] = 1;
                white++;
            }
        }
        for (int i = white; i < nums.length; i++) {
            nums[i] = 2;
        }

    }
}
// @lc code=end

