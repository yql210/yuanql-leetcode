import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个正序数组的中位数
 */

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // 暴力求解
        int[] flag = new int[nums1.length + nums2.length];

        for (int i = 0; i < nums1.length; i++) {
            flag[i] = nums1[i];
        }

        for (int i = 0; i < nums2.length; i++) {
            flag[nums1.length + i] = nums2[i];
        }

        Arrays.sort(flag);

        if ((flag.length % 2) == 1) {
            return flag[flag.length / 2];
        } else {
            return (flag[flag.length / 2] + flag[(flag.length / 2) -1]) / 2.0;
        }

    }
}
// @lc code=end

