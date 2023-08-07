//给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用 一次 。 
//
// 注意：解集不能包含重复的组合。 
//
// 
//
// 示例 1: 
//
// 
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//输出:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//] 
//
// 示例 2: 
//
// 
//输入: candidates = [2,5,2,1,2], target = 5,
//输出:
//[
//[1,2,2],
//[5]
//] 
//
// 
//
// 提示: 
//
// 
// 1 <= candidates.length <= 100 
// 1 <= candidates[i] <= 50 
// 1 <= target <= 30 
// 
//
// Related Topics 数组 回溯 👍 1413 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(candidates, target, 0, 0, new ArrayList<>(), result);
        return result;
    }

    /**
     * 回溯求解
     * @param candidates 候选人的集合
     * @param target 目标数
     * @param start 集合的开始坐标
     * @param sum 遍历路径的和
     * @param temp 遍历路径上的元素
     * @param result 最终的结果
     */
    private void backtracking(int[] candidates, int target, int start, int sum, List<Integer> temp, List<List<Integer>> result) {
        if (target == sum) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (sum + candidates[i] > target) return;
            temp.add(candidates[i]);
            backtracking(candidates, target, i + 1, sum + candidates[i], temp, result);
            while (i < candidates.length - 1 && candidates[i] == candidates[i + 1]) {
                i++;
            }
            temp.remove(temp.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
