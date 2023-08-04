//给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。 
//
// 你可以按 任何顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4, k = 2
//输出：
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
//
// 示例 2： 
//
// 
//输入：n = 1, k = 1
//输出：[[1]] 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
//
// Related Topics 回溯 👍 1442 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtracking(1, n, k, new ArrayList<>());
        return result;
    }

    private void backtracking(int nStart, int nEnd, int k, List<Integer> tempResult) {
        if (k == 0) {
            result.add(new ArrayList<>(tempResult));
            return;
        }

        for (int i = nStart; i <= nEnd - k + 1; i++) {
            tempResult.add(i);
            backtracking(i + 1, nEnd, k - 1, tempResult);
            tempResult.remove(tempResult.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
