package top.yuanql.ximalaya;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: top.yuanql.ximalaya
 * @BelongsClassName: one
 * @Author: yuanql
 * @CreateTime: 2023-09-24  19:01
 * @Description:
 * @Version: 1.0
 */


public class one {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param nums int整型一维数组
     * @return int整型
     */
    public int maxAbsoluteSum (int[] nums) {
        // write code here

        int result = 0;
        long temp = 0;
//        boolean flag = true;
//        int left = 0, right = 0;

        for (int right = 0; right < nums.length; right++) {
            temp += nums[right];
            if (temp < 0) {
//                left = right;
                temp = 0;
            } else {
                result = (int) Math.max((long) result, temp);
            }
        }

        int result1 = 0;
        temp = 0;
        for (int right = 0; right < nums.length; right++) {
            temp += nums[right];
            if (temp > 0) {
//                left = right;
                temp = 0;
            } else {
                result1 = (int) Math.min((long) result1, temp);
            }
        }

        return Math.max(-result1, result);
    }
}
