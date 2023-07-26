/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {

        //方法二：双指针--看题解学得

        int l_left=0,l_right=(height.length-1),maxarea = 0,temp;
        while(l_left < l_right){

            temp = (l_right - l_left) * ((height[l_left]<height[l_right]) ? height[l_left]:height[l_right]);
            if (temp > maxarea) {
                maxarea = temp;
            }

            if (height[l_left] > height[l_right]){
                l_right--;
            } else {
                l_left++;
            }
        }

        return maxarea;



        /* 自己编写有问题
        int l_left,l_end,maxarea = 0 ,temp;
        boolean flag = false;
        
        for (l_start = 0; l_start < height.length - 1; l_start++) {
            for (l_end = (height.length - 1); l_end > 0; l_end--) {
                temp = (l_end - l_start) * ((height[l_start]<height[l_end]) ? height[l_start]:height[l_end]);
                if (temp > maxarea) {
                    maxarea = temp;
                }
                if (height[l_start]<height[l_end]){
                    continue;
                }
            }
        }
        return maxarea;
*/

        



        //方法一：暴力求解，导致时间超时
        /*
        int maxarea = (height[1]<height[0]) ? height[1]:height[0], temp;
        for (int i = 0; i < height.length-1; i++) {
            for (int j = i+1 ; j < height.length; j++) {
                temp = (j - i) * ((height[i]<height[j]) ? height[i]:height[j]);
                if (temp > maxarea){
                    maxarea = temp;
                }
            }
        }
        return maxarea;
        */

    }
}
// @lc code=end



