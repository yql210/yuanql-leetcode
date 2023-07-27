//给你两个下标从 0 开始的数组 nums1 和 nums2 ，和一个二维数组 queries 表示一些操作。总共有 3 种类型的操作： 
//
// 
// 操作类型 1 为 queries[i] = [1, l, r] 。你需要将 nums1 从下标 l 到下标 r 的所有 0 反转成 1 或将 1 反转成 
//0 。l 和 r 下标都从 0 开始。 
// 操作类型 2 为 queries[i] = [2, p, 0] 。对于 0 <= i < n 中的所有下标，令 nums2[i] = nums2[i] +
// nums1[i] * p 。 
// 操作类型 3 为 queries[i] = [3, 0, 0] 。求 nums2 中所有元素的和。 
// 
//
// 请你返回一个数组，包含所有第三种操作类型的答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,0,1], nums2 = [0,0,0], queries = [[1,1,1],[2,1,0],[3,0,0]]
//输出：[3]
//解释：第一个操作后 nums1 变为 [1,1,1] 。第二个操作后，nums2 变成 [1,1,1] ，所以第三个操作的答案为 3 。所以返回 [3] 。
//
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1], nums2 = [5], queries = [[2,0,0],[3,0,0]]
//输出：[5]
//解释：第一个操作后，nums2 保持不变为 [5] ，所以第二个操作的答案是 5 。所以返回 [5] 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length,nums2.length <= 10⁵ 
// nums1.length = nums2.length 
// 1 <= queries.length <= 10⁵ 
// queries[i].length = 3 
// 0 <= l <= r <= nums1.length - 1 
// 0 <= p <= 10⁶ 
// 0 <= nums1[i] <= 1 
// 0 <= nums2[i] <= 10⁹ 
// 
//
// Related Topics 线段树 数组 👍 19 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long[] handleQuery(int[] nums1, int[] nums2, int[][] queries) {
        List<Long> result = new ArrayList<>();

        for (int i = 0; i < queries.length; i++) {

            if (queries[i][0] == 1) {

                for (int j = queries[i][1]; j <= queries[i][2]; j++) {
                    if (nums1[j] == 0){
                        nums1[j] = 1;
                    } else {
                        nums1[j] = 0;
                    }
                }
            } else if (queries[i][0] == 2) {
                for (int j = 0; j < nums2.length; j++) {
                    nums2[j] = (int) ((long) nums2[j] + nums1[j] * queries[i][1]);
                }
            } else {
                long tem = 0L;
                for (int j = 0; j < nums2.length; j++) {
                    tem += nums2[j];
                }
                result.add(tem);
            }
        }

        long[] longRes = new long[result.size()];

        for (int i = 0; i < result.size(); i++) {
            longRes[i] = result.get(i);
        }

        return longRes;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
