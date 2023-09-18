package top.yuanql.yongyou;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: top.yuanql.yongyou
 * @BelongsClassName: one
 * @Author: yuanql
 * @CreateTime: 2023-09-18  19:24
 * @Description:
 * @Version: 1.0
 */


public class one {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 计算让两个数组相等的所需的最少操作数量
     * @param nums1 int整型一维数组 nums1
     * @param nums2 int整型一维数组 nums2
     * @param k int整型 k
     * @return long长整型
     */
    public long minOperations (int[] nums1, int[] nums2, int k) {
        // write code here

        long up = 0, down = 0;

        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] > nums2[i]) {
                if ((nums1[i] - nums2[i]) % k == 0) {
                    up += (nums1[i] - nums2[i]) / k;
                } else {
                    return -1;
                }
            } else if (nums1[i] < nums2[i]) {
                if ((nums2[i] - nums1[i]) % k == 0) {
                    down += (nums2[i] - nums1[i]) / k;
                } else {
                    return -1;
                }
            }
        }

        if (Math.abs(up - down) % 2 == 1) return -1;


        return Math.max(up, down);
    }
}
