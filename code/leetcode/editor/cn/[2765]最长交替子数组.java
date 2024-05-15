//给你一个下标从 0 开始的整数数组 nums 。如果 nums 中长度为 m 的子数组 s 满足以下条件，我们称它是一个 交替子数组 ： 
//
// 
// m 大于 1 。 
// s1 = s0 + 1 。 
// 下标从 0 开始的子数组 s 与数组 [s0, s1, s0, s1,...,s(m-1) % 2] 一样。也就是说，s1 - s0 = 1 ，s2 - 
//s1 = -1 ，s3 - s2 = 1 ，s4 - s3 = -1 ，以此类推，直到 s[m - 1] - s[m - 2] = (-1)ᵐ 。 
// 
//
// 请你返回 nums 中所有 交替 子数组中，最长的长度，如果不存在交替子数组，请你返回 -1 。 
//
// 子数组是一个数组中一段连续 非空 的元素序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,4,3,4]
//输出：4
//解释：交替子数组有 [3,4] ，[3,4,3] 和 [3,4,3,4] 。最长的子数组为 [3,4,3,4] ，长度为4 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,5,6]
//输出：2
//解释：[4,5] 和 [5,6] 是仅有的两个交替子数组。它们长度都为 2 。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 100 
// 1 <= nums[i] <= 10⁴ 
// 
//
// Related Topics 数组 枚举 👍 26 👎 0


import java.util.ArrayList;
import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int alternatingSubarray(int[] nums) {
//        Arrays.sort(nums);
//        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
//
//        int num = nums[0],
//                sum = 1;
//
//        for (int i = 1; i < nums.length; i++) {
//            if (num == nums[i]) {
//                sum++;
//            } else {
//                ArrayList<Integer> list = new ArrayList<>();
//                list.add(num);
//                list.add(sum);
//                lists.add(list);
//
//                num = nums[i];
//                sum = 1;
//            }
//        }
//
//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(num);
//        list.add(sum);
//        lists.add(list);
//
//        int result = -1;
//
//        for (int i = 0; i < lists.size() - 1; i++) {
//            if (lists.get(i).get(0) == lists.get(i + 1).get(0) - 1) {
//                if (lists.get(i).get(1) > lists.get(i + 1).get(1)) {
//                    result = Math.max(result, 2 * lists.get(i + 1).get(1) + 1);
//                } else if (lists.get(i).get(1) == lists.get(i + 1).get(1)){
//                    result = Math.max(result, 2 * lists.get(i + 1).get(1));
//                } else {
//                    result = Math.max(result, 2 * lists.get(i).get(1));
//                }
//            }
//            System.out.println(result);
//        }

        int result = -1;
        int tempResult = -1;
        int flag = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (flag == 1) {
                if (nums[i] == nums[i + 1] + 1) {
                    flag = -1;
                    tempResult++;
                } else {
                    i--;
                    flag = 0;
                    result = Math.max(result, tempResult);
                }
            } else if (flag == -1) {
                if (nums[i] == nums[i + 1] - 1) {
                    flag = 1;
                    tempResult++;
                } else {
                    i--;
                    flag = 0;
                    result = Math.max(result, tempResult);
                }
            } else {
                if (nums[i] == nums[i + 1] - 1) {
                    flag = 1;
                    tempResult = 2;
                } else if (nums[i] == nums[i + 1] - 1) {
                    flag = -1;
                    tempResult = 2;
                }
            }
        }

        result = Math.max(result, tempResult);

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
