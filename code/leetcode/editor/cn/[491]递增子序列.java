//给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。 
//
// 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,6,7,7]
//输出：[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,4,3,2,1]
//输出：[[4,4]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 15 
// -100 <= nums[i] <= 100 
// 
//
// Related Topics 位运算 数组 哈希表 回溯 👍 696 👎 0


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private List<List<Integer>> result = new ArrayList<>();

    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backtracking(nums, 0);
        return result;
    }

    private void backtracking(int[] nums, int start) {

        if (path.size() >= 2 && path.get(path.size() - 1) < path.get(path.size() - 2)) return;
        if (path.size() >= 2) {
            result.add(new ArrayList<>(path));
        }

        HashSet set = new HashSet<>(); // 同一层进行去重操作
        for (int i = start; i < nums.length; i++) {

            if (set.contains(nums[i])) continue;
            path.add(nums[i]);
            backtracking(nums, i + 1);
            path.remove(path.size() - 1);
            set.add(nums[i]);

        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
