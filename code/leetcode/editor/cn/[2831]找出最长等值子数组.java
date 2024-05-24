//给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。 
//
// 如果子数组中所有元素都相等，则认为子数组是一个 等值子数组 。注意，空数组是 等值子数组 。 
//
// 从 nums 中删除最多 k 个元素后，返回可能的最长等值子数组的长度。 
//
// 子数组 是数组中一个连续且可能为空的元素序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,2,3,1,3], k = 3
//输出：3
//解释：最优的方案是删除下标 2 和下标 4 的元素。
//删除后，nums 等于 [1, 3, 3, 3] 。
//最长等值子数组从 i = 1 开始到 j = 3 结束，长度等于 3 。
//可以证明无法创建更长的等值子数组。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,1,2,2,1,1], k = 2
//输出：4
//解释：最优的方案是删除下标 2 和下标 3 的元素。 
//删除后，nums 等于 [1, 1, 1, 1] 。 
//数组自身就是等值子数组，长度等于 4 。 
//可以证明无法创建更长的等值子数组。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= nums.length 
// 0 <= k <= nums.length 
// 
//
// Related Topics 数组 哈希表 二分查找 滑动窗口 👍 55 👎 0


import java.util.HashMap;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestEqualSubarray(List<Integer> nums, int k) {
//        int ans = 0;
//        HashMap<Integer, Integer> map = new HashMap<>();
//        int left = 0,
//                right = 1,
//                error_num = 0,
//                all_num = 1,
//                max = nums.get(0);
//        map.put(max, 1);
//        for (; right < nums.size(); right++) {
//            all_num++;
//            if (max == nums.get(right)) {
//                map.put(max, map.get(max) + 1);
//            } else {
//                error_num++;
//                ans = Math.max(ans, all_num - error_num);
//                map.put(nums.get(right), map.getOrDefault(nums.get(right), 0) + 1);
//                max = findMax(map, nums.get(left), map.get(nums.get(left)));
//                error_num = all_num - map.get(max);
//                if (error_num > k) {
//                    while (left < right && error_num > k) {
//                        all_num--;
//                        if (nums.get(left) == max) {
//                            map.put(max, map.get(max) - 1);
//                        } else {
//                            map.put(nums.get(left), map.get(nums.get(left)) - 1);
//                            error_num--;
//                            left++;
//                            break;
//                        }
//                        left++;
//                        max = findMax(map, nums.get(left), map.get(nums.get(left)));
//                        error_num = all_num - map.get(max);
//                    }
//
////                    System.out.println(max);
//                }
//            }
//        }
//        ans = Math.max(ans, all_num - error_num);
//        ans = Math.max(ans, map.get(findMax(map, 0, 0)));
////        System.out.println(all_num);
////        System.out.println(error_num);
//        return ans;
//    }
//
//    public int findMax(HashMap<Integer, Integer> map, Integer maxKey, Integer maxValue) {
////        int maxKey = 0,
////                maxValue = 0;
//        for (Integer key : map.keySet()) {
////            System.out.println(key + " = " + map.get(key));
//            if (map.get(key) > maxValue) {
//                maxValue = map.get(key);
//                maxKey = key;
//            }
//        }
////        System.out.println();
//        return maxKey;





    }
}
//leetcode submit region end(Prohibit modification and deletion)
