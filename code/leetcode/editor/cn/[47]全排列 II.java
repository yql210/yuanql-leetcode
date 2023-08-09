//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
//
// Related Topics 数组 回溯 👍 1422 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private List<List<Integer>> result = new ArrayList<>();

    private List<Integer> path = new ArrayList<>();

    private int[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new int[nums.length];
        Arrays.sort(nums);
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
            used[i] = 1;
            path.add(nums[i]);
            backtracking(nums, size + 1);
            path.remove(path.size() - 1);
            used[i] = 0;
            while (i < used.length - 1 && nums[i] == nums[i + 1]) i++;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
