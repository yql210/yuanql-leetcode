package top.yuanql.yuewen;

import java.util.ArrayList;
import java.util.Map;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: top.yuanql.yuewen
 * @BelongsClassName: two
 * @Author: yuanql
 * @CreateTime: 2023-11-03  19:43
 * @Description:
 * @Version: 1.0
 */


public class two {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param nums int整型ArrayList
     * @return int整型
     */

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(-1);
        nums.add(4);
        int longestSubArray = findLongestSubArray(nums);
        System.out.println("longestSubArray = " + longestSubArray);
    }
    public static int findLongestSubArray (ArrayList<Integer> nums) {
        // write code here
        int result = 0;

        int temp = 0;
        int temp1 = 0; // 存放真正的数据

        boolean flag = false;

        for (Integer num : nums) {
            if (num == 0) {
                result = Math.max(result, temp1);
                temp = 0;
                temp1 = 0;
                flag = false;
            } else if (num > 0) {
                if (!flag) {
                    temp1++;
                }
                temp++;
            } else {
                if (!flag) {
                    flag = true;
                    temp++;
                } else {
                    flag = false;
                    temp++;
                    temp1 = temp;
                }
            }
        }

        result = Math.max(result, temp1);

        return result;
    }



}
