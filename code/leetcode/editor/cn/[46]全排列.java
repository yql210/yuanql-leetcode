//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
//
// Related Topics 数组 回溯 👍 2631 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private List<List<Integer>> result = new ArrayList<>();

    private List<Integer> path = new ArrayList<>();

    private int[] used;
    public List<List<Integer>> permute(int[] nums) {
        used = new int[nums.length];
        backtracking(nums, 0);
        return result;
    }

    private void backtracking(int[] nums, int size) {
        if (size == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < used.length; i++) {
            if (used[i] == 1) continue;
            path.add(nums[i]);
            used[i] = 1;
            backtracking(nums, size + 1);
            path.remove(path.size() - 1);
            used[i] = 0;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
