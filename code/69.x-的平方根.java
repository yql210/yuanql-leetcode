/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] x 的平方根 
 */

// @lc code=start
class Solution {
    public int mySqrt(int x) {
        int left = 0,right = x,mid = 0;

        while (left <= right) {
            mid = left + (right - left) / 2;
            if (mid * mid == x) {
                return mid;
            } else if (mid * mid > x || mid > Math.pow(2, 15.5)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return (left + right) / 2;
    }
}
// @lc code=end

