package top.yuanql.yaxinSafe;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: top.yuanql.yaxinSafe
 * @BelongsClassName: two
 * @Author: yuanql
 * @CreateTime: 2023-09-17  15:14
 * @Description:
 * @Version: 1.0
 */


public class two {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param prices int整型一维数组
     * @param target int整型
     * @return int整型
     */
    public int maxProducts (int[] prices, int target) {
        // write code here

        // 滑动窗口

        int result = 0;
        int left = 0;
        int right = 1;
        long sum = prices[0];

        while (right < prices.length) {
            if (sum > target) {
                result = Math.max(result, right - left - 1);
                sum -= prices[left];
                left++;
            } else {
                sum += prices[right];
                right++;
            }
        }

        if (sum > target) {
            result = Math.max(result, right - left - 1);
        } else {
            result = Math.max(result, right - left);
        }

        return result;
    }
}
