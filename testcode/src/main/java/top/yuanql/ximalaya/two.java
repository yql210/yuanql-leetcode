package top.yuanql.ximalaya;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: top.yuanql.ximalaya
 * @BelongsClassName: ywo
 * @Author: yuanql
 * @CreateTime: 2023-09-24  19:01
 * @Description:
 * @Version: 1.0
 */


public class two {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param nums int整型一维数组 有序数组
     * @return int整型
     */
    public int removeDuplicates (int[] nums) {
        // write code here

        int result = 1;
        int temp = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (temp != nums[i]) {
                temp = nums[i];
                result++;
            }
        }


        return result;
    }
}
